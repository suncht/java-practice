class StaticObjectTest {

}

/**
 * StaticObjectTest的伴生对象，相当于StaticObjectTest的静态方法
 */
object StaticObjectTest {
  def main(args: Array[String]) {
    println(StaticFunc.add(2,3))
  }
}

object StaticFunc {
  def add(x:Int, y:Int):Int = x + y
}