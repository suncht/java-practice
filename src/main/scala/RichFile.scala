/**
 * Created by changtan.sun on 2016/12/19.
 */
package my.test.enrich

import java.io.File
import scala.io.{Codec, Source}

class RichFile(f: File) {
  def myRead = Source.fromFile(f.getPath)(Codec.UTF8).mkString
  def getFilePath = f.getAbsolutePath

  def myRead2(implicit fileCoding: Codec) = {
    Source.fromFile(f.getPath)(fileCoding).mkString
  }
}
