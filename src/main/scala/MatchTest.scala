/**
 * Created by changtan.sun on 2018/1/4.
 */

/**
 * 模式匹配测试
 */
object MatchTest extends App {
  def t(obj: Any): String = obj match {
    case x: String => x
    case x: List[String] => listToStr(x)
    case x: Int => x.toString
    case x: Boolean => x.toString
    case _ => ""
  }

  def listToStr[S](list: List[S]): String = {
    val builder = new StringBuilder
    for(x <- list) {
      builder.append(x.toString).append(",")
    }
    if(builder.size>0) builder.init.toString() else ""
  }

  val list = List("1","2", "3", "4", "5", "6")
  println(t(list))
}
