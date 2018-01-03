package com.xml.test

/**
 * Created by changtan.sun on 2016/12/22.
 */

import scala.io.Codec
import scala.xml._
class XmlWriter(val data: List[Person]) {
  def updateXmlItem(person: Person) = {
    <person id={person.id}>
      <name>{person.name}</name>
      <age>{person.age}</age>
      <sex>{person.sex}</sex>
    </person>
  }

  var updatedXml = <persons>
    {data.map{updateXmlItem(_)}}
  </persons>

  def write2File(fileName: String) = {
    XML.save(fileName, updatedXml, Codec.UTF8.toString())

  }
}
