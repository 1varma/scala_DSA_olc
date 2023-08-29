package in.olc.trees.traversals

import scala.io.StdIn.readLine
import binaryTree.buildTreeFromArray

object sumTree {
  private def sum(root: TreeNode):Int={
    if root == null then
      return 0

    sum(root.left) + root.value + sum(root.right)
  }

  private def isSum(root: TreeNode):Boolean={
    if root == null then
      return false

    val leftValue = sum(root.left)
    val rightValue = sum(root.right)

    root.value == leftValue+rightValue
  }

  def main(args: Array[String]): Unit = {
    val arr = readLine("Enter elements into array: ").split(" ").map(_.toInt)
    val tree = buildTreeFromArray(arr)

    isSum(tree) match
      case true => println(s"The tree is a sum tree")
      case _ => println(s"The tree is not a sum tree")
  }
}
