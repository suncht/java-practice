package my.test.enrich

import java.io.File

import scala.io.Codec

/**
 * Created by changtan.sun on 2016/12/19.
 */
object ImplicitContext {
  //隐式转换 --- 通过隐式方法来转换
  implicit def file2RichFile(f: File) = new RichFile(f)
  //定义隐式参数值
  implicit val fileCoding = Codec.UTF8
}
