package in.olc.trees.traversals

import scala.io.StdIn.readLine
import binaryTree.{buildTreeFromArray, preorderTraversal}
import scala.math.log

object depthPreOrder {
  def calculateFullBinaryTreeDepth(preorder: Array[Int]): Int = {
    val numberOfNodes = preorder.length
    math.ceil(log(numberOfNodes + 1) / log(2)).toInt
  }

  def main(args: Array[String]): Unit = {
    val arr = readLine("Enter elements into array: ").split(" ").map(_.toInt)
    val tree = buildTreeFromArray(arr)

    val preorderResult = binaryTree.preorderTraversal(tree).toArray

    val fullBinaryTreeDepth = calculateFullBinaryTreeDepth(preorderResult)
    println(s"Depth of the full binary tree: $fullBinaryTreeDepth")
  }
}