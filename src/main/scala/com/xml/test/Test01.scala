package com.xml.test

/**
 * Created by changtan.sun on 2016/12/22.
 */
object Test01 {
  def writeToFile = {
    val fileName = "c:/test.xml"
    val persons = new scala.collection.mutable.ListBuffer[Person]
    persons += new Person("1", "name", 10, "nan")
    persons += new Person("2", "suncht", 30, "nan")
    persons += new Person("3", "孙畅谈", 20, "nan")
    persons += new Person("4", "好收到回复发阿斯蒂芬", 20, "nan")
    val xmlWriter = new XmlWriter(persons.toList)
    xmlWriter.write2File(fileName)
  }

  def readToFile = {
    val fileName = "c:/test.xml"
    val xmlReader = new XmlReader
    val persons: List[Person] = xmlReader.readFromXml(fileName)

    persons.foreach(p => println(p))
  }

  def main(args: Array[String]) {
    readToFile

    println((1 to 100).reduceLeft((sum, x)=> {println(sum + ": " + x); sum + x}))
  }
}
