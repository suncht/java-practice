package com.xml.test

import scala.xml.XML

/**
 * Created by changtan.sun on 2016/12/22.
 */
class XmlReader {
  def readFromXml(fileName: String): List[Person] = {
    val xmlFile = XML.load(fileName)
    //println(xmlFile)

    val personList = getPersons(xmlFile)

    personList
  }

  private[this] def getPersons[T <: scala.xml.Node](xml: T): List[Person] = {
    import scala.collection.mutable.ListBuffer
    val listBuffer = ListBuffer[Person]()
    (listBuffer /: (xml \ "person")) {
      (buffer, node) => {
        val id = (node \ "@id").toString
        val name = (node \ "name").text.toString
        val age = (node \ "age").text.toInt
        val sex = (node \ "sex").text.toString
        buffer += new Person(id, name, age, sex)
      }
    }

    listBuffer.toList
  }
}
