import com.util.Utils

/**
 * Created by changtan.sun on 2016/12/12.
 */
object MapTest extends App{
  var map: Map[Int, String]  = Map()
  //map += (1 -> "1")
  for(i <- 1 to 100) {
    map += (i -> i.toString)
  }

  //println(map)

  map.foreach(item => println(item._1) )

  //Utils.readFile("")
  import scala.collection.mutable.{HashMap => MutableHashMap}
  val map2: MutableHashMap[Int, (String, String)] = new MutableHashMap[Int, (String, String)]
  map2 += (1 -> ("a", "aa"))  //增加新元素
  val map3 = map2 + (3 -> ("b", "bb")) //创建新的对象
  println(map2)
  println(map3)

  val map4 = map2 + "121212" ///变成字符串了
  map4.foreach(item => println(item) )
}
