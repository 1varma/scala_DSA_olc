package in.olc.trees.traversals

import scala.collection.mutable
import scala.io.StdIn.readLine
import binaryTree.buildTreeFromArray

object maxDepth {
  private def findMaxDepth(root: TreeNode): Int = {
    if root == null then
      0
    else
      var maxDepth = 0
      val queue = mutable.Queue[TreeNode]()
      queue.enqueue(root)

      while queue.nonEmpty do
        maxDepth += 1
        val levelSize = queue.size
        for (_ <- 0 until levelSize) do
          val node = queue.dequeue()
          if (node.left != null) queue.enqueue(node.left)
          if (node.right != null) queue.enqueue(node.right)
          
      maxDepth
  }

  def main(args: Array[String]): Unit = {
    val arr = readLine("Enter elements into array: ").split(" ").map(_.toInt)
    val tree = binaryTree.buildTreeFromArray(arr)

    val maxDepth = findMaxDepth(tree)
    println(s"Maximum depth of the tree: $maxDepth")
  }
}