package in.olc.assignment

import in.olc.trees.traversals.TreeNode
import in.olc.trees.traversals.binaryTree.buildTreeFromArray

import scala.io.StdIn.readLine

object searchBT {
  private def find(root: TreeNode, value: Int):Boolean={
    if root == null then
      return false

    if root.value == value then
      true

    else if root.left != null then
      find(root.left, value)

    else
      find(root.right, value)
  }

  def main(args: Array[String]): Unit = {
    val arr = readLine("Enter elements into the array: ").split(" ").map(_.toInt)
    val tree = buildTreeFromArray(arr)
    val value = readLine("Enter the value to find in the binary tree: ").toInt

    find(tree, value) match
      case true => println(s"The value $value exists")
      case _ => println(s"The value $value doesn't exists")
    end match
  }
}
