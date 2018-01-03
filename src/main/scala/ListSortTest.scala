/**
 * Created by changtan.sun on 2016/12/29.
 */
object ListSortTest extends App {
  val list = List("sdf", "asdf", "ere", "cvsd", "123d", "2sd")

  def sort1(list: List[String]) = {
    list.sortWith((a, b)=>a<b)
  }

  println(sort1(list))
}
