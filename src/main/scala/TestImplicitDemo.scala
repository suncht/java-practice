import java.io.File

/**
 * Created by changtan.sun on 2016/12/19.
 */
case class UserEx(val name: String, val age: Int) extends Ordered[UserEx] {
  override def compare(that: UserEx): Int = {
    this.age - that.age
  }
}

object TestImplicitDemo {
  def min[T](x: T, y: T)(implicit s:T => Ordered[T]) = if(x<y) x else y

  def mins[T](x: T*)(implicit s:T => Ordered[T]): T = {
    x.reduceLeft[T]((x, y) => if(x<y) x else y)
  }

  def main(args: Array[String]) {
    import my.test.enrich.ImplicitContext._
    val f = new File("c:/test.txt")
    println(f.myRead)
    println(f.getFilePath)
    println(f.myRead2)

    println(min("aa", "bbb"))

    val user1 = new UserEx("suncht", 30)
    val user2 = new UserEx("aa", 24)
    val user3 = new UserEx("bb", 10)
    val user4 = new UserEx("cc", 40)
    println(min(user1, user2))

    println(mins(user1, user2, user3, user4))
    println(mins(user1))
  }
}




