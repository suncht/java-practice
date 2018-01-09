package com.covariant

import scala.collection.mutable.ListBuffer
import scala.math._
/**
 * Created by changtan.sun on 2018/1/9.
 */

trait ShapeComputeable {
  def area: Double
  def circumference: Double
}

class Shape extends ShapeComputeable{
  def area: Double = {0}

  def circumference: Double = {0}

  def draw = {
    println("draw a shape")
  }
}

object Context {
  implicit class RichShape(val shape: Shape) extends Ordering[Shape]{
    def compare(x: Shape, y: Shape): Int = {
      if(x == y) 0
      else (x.area - y.area).toInt
    }

    def draw2 = {
      println("draw a shape2")
    }
  }
}


class Oval(val a:Double, val b: Double) extends Shape {
  override def area: Double = {
    Pi * a * b
  }

  override def circumference: Double = {
    if(a>=b) {
      2 * Pi * b + 4 * (a -b)
    } else {
      2 * Pi * a + 4 * (b -a)
    }
  }

  override def draw = {
    println("draw a Oval")
  }
}

class Circle(val r: Double) extends Shape {
  override def area: Double = {
    Pi * r * r
  }

  override def circumference: Double = {
    2 * Pi * r
  }

  override def draw = {
    println("draw a Circle")
  }
}

class Rectange(val a: Double, val b: Double) extends Shape {
  override def area: Double = {
    a * b
  }

  override def circumference: Double = {
    2 * (a + b)
  }

  override def draw = {
    println("draw a Rectange")
  }
}

trait Function1[+T] {
  def draw[R >: T](x: R): R
}

trait Function2[-T] {
  def draw[R <: T](x: R): R
}

trait Function3[-T, +U] {
  def draw(x: T): U
}

trait Function4[+T, -U] {
  def draw[R >: T, S <: U](x: R): S
}

trait Function5[+T, -U] {
  def draw[U](x: U): T
}



class DrawBoard[+T <: Shape] {
  import com.covariant.Context._

  var shapes = ListBuffer[Shape]()

  def draw[R >: T <: Shape](shape: R) : R = {
    shape.draw
    shape.draw2
    shapes += shape
    shape
  }

  def count = {
    shapes.length
  }

  def sumArea = {
    var area = 0.0
    for(s <- shapes) {
      area += s.asInstanceOf[Shape].area
    }
    area
  }


}

class DrawBoard2[-T <: Shape] {
  def draw[T <: Shape](shape: T) : T = {
    shape.draw
    shape
  }
}


object DrawBoard {
  def main(args: Array[String]) {
    val board = new DrawBoard
    board.draw(new Circle(1.0))
    board.draw(new Oval(1.0, 2.0))
    board.draw(new Rectange(1.0, 2.0))

//    println(board.count)
//    println(board.sumArea)
  }
}

class Person1[+A] {
  def test1: A = null.asInstanceOf[A]

  def test2[T >: A](a: T): T = null.asInstanceOf[T]

  def test3[T >: A](a: T): Unit = {}
}

class Person2[-A] {
  def test1[T <: A]: T = null.asInstanceOf[T]

  def test2[T <: A](a: A) : T = null.asInstanceOf[T]

  def test3(a: A): Unit = {}
}

