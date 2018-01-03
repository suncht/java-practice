/**
 * Created by changtan.sun on 2016/12/12.
 */
object FunctionTest extends App{

  def myprint(s: Any) = println(s)

  def compute(arr: Array[Int])(f: (Int)=>Int): Int = {
    var sum = 0
    for(i <- arr) {
      sum += f(i)
    }
    sum
  }

  val arr = Array(2,3,1,2,5,2,8)
  myprint(compute(arr)(item=>item))
  myprint(compute(arr)(item=>item*2))
  myprint(compute(arr)(_*2))
  myprint(compute(arr)(_*8))
}
