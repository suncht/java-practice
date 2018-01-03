/**
 * Created by changtan.sun on 2016/12/20.
 */



object ActorTest02 {

  def main(args: Array[String]) {
    import scala.actors.Actor._
    import scala.actors._

    var actor3 = actor{
      while(true) {
        receive{
          case x => println("actor3:" + x)
        }
      }
    }

    val actor1 = actor {
      while (true) {
        receive{
            case (caller: Actor, msg: Int) => {
              actor {
                println("actor1:" + msg)
                Thread.sleep(100)
                actor3 ! msg + "aaaaa"
              }
            }
            case "quit" => exit()
        }
      }
    }

    val actor2 = actor {
      for(i <- 0 to 200) {
        actor1 ! (self, i)
      }
      actor1 ! "quit"


    }

  }
}
