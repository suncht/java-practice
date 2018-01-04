/**
 * Created by changtan.sun on 2018/1/4.
 */
object BodyTest extends App{

  def action(f: => Unit) = {
    f
  }

  def action2(f: => Int) = {
    f
  }

  def timedAction(f: => Unit) = {
    val start = System.currentTimeMillis()
    f
    val end = System.currentTimeMillis()

    println("耗时:" + (end - start))
  }
  action {
    println("aa")
  }

  val res = action2 {
    1
  }

  timedAction {
    for(i <- 0 to 100) {
      Thread.sleep(100)
    }
  }


}
