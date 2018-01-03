/**
 * Created by changtan.sun on 2016/12/19.
 */

package my.test

case class Person(name: String, age: Int) {
  override def toString = {
    "name:" + name + " age:"+ age
  }
}

object Context {
  implicit object PersonOrdering extends Ordering[Person] {
    override def compare(p1: Person, p2: Person): Int = {
      p1.name == p2.name match {
        case false => -p1.name.compareTo(p2.name)
        case _ => p1.age - p2.age
      }
    }
  }
}


object OrderTest {
  def main(args: Array[String]) {

    implicit object PersonOrdering extends Ordering[Person] {
      override def compare(p1: Person, p2: Person): Int = {
        p1.name == p2.name match {
          case false => -p1.name.compareTo(p2.name)
          case _ => p1.age - p2.age
        }
      }
    }

    val p1 = new Person("rain", 24)
    val p2 = new Person("rain", 22)
    val p3 = new Person("Lily", 15)
    val list = List(p1, p2, p3)

    println(list.sorted)
  }

}
