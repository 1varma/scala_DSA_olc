package in.olc.trees.traversals

import binaryTree.{buildTreeFromArray, printTree}
import scala.io.StdIn.readLine

object numberOfNodes {
  private def countNodes(root: TreeNode): Int = {
    if root == null then
      0
    else
      1 + countNodes(root.left) + countNodes(root.right)
  }

  def main(args: Array[String]): Unit = {
    val arr = readLine("Enter elements into array: ").split(" ").map(_.toInt)
    val tree = binaryTree.buildTreeFromArray(arr)
    binaryTree.printTree(tree)

    val nodeCount = countNodes(tree)
    println(s"Number of nodes in the tree: $nodeCount")
  }
}
