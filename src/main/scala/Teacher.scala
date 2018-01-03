
//name、age是成员变量
abstract  class Teacher(val name:String, val age:Int) {
  val major:String = ""

  def getMajor = major

  def printInfo;
}

//子类中也定义了name的成员变量，需要override
//school没有带val，则外部不能访问school，属于私有变量
//在父类已经实现了的方法，子类需要override复写
class MathTeacher(override val name:String, age:Int, school:String) extends Teacher(name, age) {
  override val major = "Math"

  def getSchool = school
  override def getMajor = major

  def printInfo = {
    println(name + " " + age + " "  + school)
  }
}

object MathTeacher {
  def main(args: Array[String]) {
    val teacher = new MathTeacher("11", 1, "aa")
    println(teacher.major)
    //println(teacher.school)
    println(teacher.name)
    println(teacher.getSchool)

    teacher.printInfo
  }
}
