package com.util

import java.io.File

import scala.io.Source
import scala.reflect.io.File

/**
 * Created by changtan.sun on 2016/12/12.
 */
object Utils {
  def readFile(file: String): Iterator[String] = {
    Source.fromFile(file).getLines()
  }
}
