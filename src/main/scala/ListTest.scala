/**
 * Created by changtan.sun on 2016/12/12.
 */
object ListTest extends  App {
  val list = List(0 to 1000000 :_*)

  //第一种方式： for循环
  def sum1(list: List[Int]) = {
    var sum = 0
    for(i <- list) {
      sum += i
    }
    sum
  }
  //第二种方式： foldLeft
  def sum2(list: List[Int]) = {
    (0 /: list){(sum, item)=> sum+item}
  }

  //第三方式： 模式匹配(一般递归) 容易Exception in thread "main" java.lang.StackOverflowError
  def sum3(list: List[Int]): Int = {
    list match {
      case List() => 0
      case head::tail => head + sum3(tail)
    }
  }

  //第四方式： 模式匹配(尾递归)
  def sum4(list: List[Int], partialValue: BigInt = 0 ): BigInt = {
    list match {
      case Nil => partialValue
      case head::tail => sum4(tail, partialValue + head)
    }
  }

  def timePerform(sum: (List[Int])=>Int, data: List[Int]): Unit = {
    val start = System.currentTimeMillis()

    for( i <- 1 to 100000) {
      sum(data)
    }

    val end = System.currentTimeMillis()
    println("耗时："+ (end - start)/100)
  }

  def timePerform2(sum: (List[Int], Int)=>Int, data: List[Int]): Unit = {
    val start = System.currentTimeMillis()

    for( i <- 1 to 100000) {
      sum(data, 0)
    }

    val end = System.currentTimeMillis()
    println("耗时："+ (end - start)/100)
  }

//  timePerform(sum1, list)  //耗时：36
//  timePerform(sum2, list)  //耗时：49
//  timePerform(sum3, list)  //Exception in thread "main" java.lang.StackOverflowError
//  timePerform2(sum4, list)

  println(sum4(list))
}
