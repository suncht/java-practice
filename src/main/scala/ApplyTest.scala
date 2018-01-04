/**
 * Created by changtan.sun on 2018/1/4.
 */

/**
 * 第一个测试： apply
 * 第二个测试： 用apply实现单例模式
 * 第三个测试：同名方法中没有默认值参数和有默认值参数的多态问题
 * @param name
 */
class AAA(val name: String = "") {

  def print(msg: String) = println(msg)
  //同名方法没有默认值参数和有默认值的参数的多态问题
  def print(msg: String, flag: Int) = println(msg + flag)
  def print(msg: String, flag: Int, flag2: Int = 2) = println(msg + flag + flag2)
  //def print(msg: String, flag: Int = 0, flag2: Boolean = true) = println(msg + flag + flag2)
}

object AAA {
  def apply() = new AAA

//  def apply(name: String) = {
//    new AAA(name)
//  }

  //用apply方法实现单例模式
  var instanceMap: Map[String, AAA] = Map[String, AAA]()
  def apply(name: String, isSingleton: Boolean = true): AAA = {
    if(isSingleton) {
      val option = instanceMap.get(name)
      if(!option.isEmpty) option.get
      else {
        val newa = new AAA(name)
        instanceMap += (name -> newa)
        newa
      }
    } else {
      new AAA(name)
    }
  }
}

object ApplyTest extends App {
  val a = AAA("suncht") //调用的AAA伴生对象的apply方法
  println(a.toString)

  val b = AAA("suncht", false)
  println(b.toString)

  val c = AAA("sunct")
  println(c.toString)


  c.print("ddd")
  c.print("ccc", 2)
  c.print("eee", 2, 1)
}
