/**
 * Created by changtan.sun on 2016/12/20.
 */


object ActorTest01 {
  def sumOfFactor(number: Int): Int = {
    (0 /: (1 to number)){(sum, i) => if(number%i==0) sum + i else sum }
  }

  def sumOfFactorsInRange(lower:Int, upper: Int, number: Int): Int = {
    (0 /: (lower to upper)){(sum, i) => if(number%i==0) sum + i else sum }
  }

  def isPerfect(candidate: Int): Boolean = 2 * candidate == sumOfFactor(candidate)

  import scala.actors.Actor._
  def isPerfectConcurrent(candidate:Int) = {
    val RANGE = 2000
    val numberOfPartitions = (candidate.toDouble/RANGE).ceil.toInt
    val caller = self

    for(i<-0 until numberOfPartitions){
      val lower = i*RANGE + 1
      val upper = candidate min(i+1)*RANGE

      actor {
        caller ! sumOfFactorsInRange(lower,upper,candidate)
      }
    }

    val sum = (0 /: (0 until numberOfPartitions)){ (partialSum, i) =>
        receive {
          case sumInRange:Int => partialSum + sumInRange
          }
        }
    2 * candidate == sum
  }

  def countTime(candidate: Int, f: Int => Boolean): Unit = {
    val startTime = System.currentTimeMillis()

    println(f(candidate))

    val endTime = System.currentTimeMillis()
    println("花费的时间：" + (endTime - startTime))
  }

  def countTimeEx(number: Int, f: Int => Boolean): Unit = {
    val startTime = System.currentTimeMillis()

    for(i <- 0 to number) if(f(i)) println(i)

    val endTime = System.currentTimeMillis()
    println("花费的时间：" + (endTime - startTime))
  }


  def main(args: Array[String]) {
    //countTime(33550336, isPerfect)

    //countTime(33550336, isPerfectConcurrent)

    countTimeEx(20000, isPerfect)
    countTimeEx(20000, isPerfectConcurrent)
  }

}
