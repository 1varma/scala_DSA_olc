package in.olc.trees.traversals

import scala.io.StdIn.readLine
import binaryTree.*

object treeFromInOrderLevelOrder {
  private def buildTreeFromInorderAndLevelOrder(inorder: Array[Int], levelOrder: Array[Int]): TreeNode = {
    if inorder.isEmpty || levelOrder.isEmpty then
      null
    else
      val rootValue = levelOrder(0)
      val root = new TreeNode(rootValue)

      val rootIndexInInorder = inorder.indexOf(rootValue)

      val leftInorder = inorder.slice(0, rootIndexInInorder)
      val rightInorder = inorder.slice(rootIndexInInorder + 1, inorder.length)

      val leftLevelOrder = levelOrder.filter(leftInorder.contains)
      val rightLevelOrder = levelOrder.filter(rightInorder.contains)

      root.left = buildTreeFromInorderAndLevelOrder(leftInorder, leftLevelOrder)
      root.right = buildTreeFromInorderAndLevelOrder(rightInorder, rightLevelOrder)

      root
  }

  def main(args: Array[String]): Unit = {
    val inorder = readLine("Enter inorder traversal: ").split(" ").map(_.toInt)
    val levelOrder = readLine("Enter level order traversal: ").split(" ").map(_.toInt)

    val tree = buildTreeFromInorderAndLevelOrder(inorder, levelOrder)
    println("Constructed Tree:")
    printTree(tree)

    println(s"Inorder traversal of the constructed tree is: ${inorderTraversal(tree).mkString(", ")}")
  }
}