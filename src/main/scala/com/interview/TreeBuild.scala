package com.interview

import java.util

/**
 * 根据前序遍历和中序遍历的结果，重建二叉树
 * Created by changtan.sun on 2018/1/4.
 */
object TreeBuild extends App{
  val preorder = List(1,2,4,7,3,5,6,8)
  val middleorder = List(4,7,2,1,5,3,8,6)

  //从前序遍历中获取第一个元素，也就是根元素
  def getRootNodeFromPreorder[T](list: List[T])(implicit s:T => Ordered[T]): Option[T] = list match {
    case head::tail => Option(head)
    case _ => Option.empty
  }

  //从中序遍历中获取左树和右树
  def getLeafNodeFromMiddleorder[T](list: List[T], value: T)(implicit s:T => Ordered[T]) : (List[T], List[T]) = {
    import scala.util.control.Breaks._
    var left = List[T]()
    var right = List[T]()

    var index = -1
    for(x <- 0 until list.length if list(x)==value) {
      breakable {
        index = x
        break()
      }
    }

    for(x <- 0 until list.length ) {
      if( x < index) {
        left = left :+ list(x)
      } else if( x > index){
        right = right :+ list(x)
      }
    }

    (left, right)
  }
  
  def getSubPreorderListFromPreorder[T](preorder: List[T], leaf: List[T])(implicit s:T => Ordered[T]): List[T] = {
    var result = List[T]()
    
    for(a <- preorder; b <- leaf if a==b) {
      result = result :+ a
    }
    result
  }


//  val a = getLeafNodeFromMiddleorder(middleorder, 1);
//  println(a._1, a._2)

  def rebuildTree[T](preorderList: List[T], middleorderList: List[T])(implicit s:T => Ordered[T]): Node[T] = {
    val root = getRootNodeFromPreorder(preorderList)
    if(!root.isEmpty) {
      var tree = new Node[T]()
      //println(root)
      tree.value = root.get

      val left_right_leaf = getLeafNodeFromMiddleorder(middleorderList, root.get)
      
      val left_middeorder = left_right_leaf._1
      val left_preorder = getSubPreorderListFromPreorder(preorderList, left_middeorder)
      val leftNode = rebuildTree(left_preorder, left_middeorder)
      tree.left = leftNode
      
      val right_middeorder = left_right_leaf._2
      val right_preorder = getSubPreorderListFromPreorder(preorderList, right_middeorder)
      val rightNode = rebuildTree(right_preorder, right_middeorder)
      tree.right = rightNode

      tree
    } else {
      null
    }
  }


  
  val tree = rebuildTree(preorder, middleorder)
  tree.printTree

  def printPostorder[T](tree: Node[T] = null)(implicit s:T => Ordered[T]): Unit = {

  }
}

class Node[T] {
  var value: T = _
  var left: Node[T] = _
  var right: Node[T] = _


  def printTree: Unit = {
    println(value)

    if(left!=null) {
      left.printTree
    }

    if(right!=null) {
      right.printTree
    }
  }

}






