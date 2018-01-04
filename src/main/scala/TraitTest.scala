/**
 * Created by changtan.sun on 2018/1/4.
 */


trait Logger {
  def log(msg: String) = {
    println("logger :" + msg)
  }

  def append(msg: String): Unit;
}

trait Timer {
  var startTime: Long = _
  var endTime: Long = _
  def start = {
    startTime = System.currentTimeMillis()
  }

  def end = {
    endTime = System.currentTimeMillis()
  }

  def printEllispe = println("耗时：" + (endTime - startTime))
}

trait Action {
  def doAction
}

trait TimerAction extends Action with Timer {
  abstract override def doAction = {
    start
    super.doAction
    end

    printEllispe
  }
}

class BaseClass {

}

//ClassA集成Logger
class ClassA extends BaseClass with Logger{
  def append(msg: String): Unit = {

  }

//  override def log(msg: String) = {
//    println("logger of ClassA :" + msg)
//  }

  val name: String = "aa";
}

class ClassB {


}

class ClassC {
  //ClassA混入Logger
  val classB = new ClassB() with Logger {
    def append(msg: String): Unit = {
    }
  }

}

class ClassD(val number: Int) extends Action {
  private def computeSum(): BigInt = {
    var sum = 0
    for(n <- 1 to number) {
      sum += n
    }
    sum
  }

  def doAction = {
    val sum = this.computeSum()
    println("sum = " + sum)
  }
}

object TraitTest extends App {
  val classA = new ClassA()
  classA.log("1111")

  val classC = new ClassC
  classC.classB.log("2222")

  //ClassD混入TimerAction特质
  val classD = new ClassD(100) with TimerAction

  classD.doAction
}