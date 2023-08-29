package in.olc.trees.traversals

import scala.collection.mutable
import scala.io.StdIn.readLine

class TreeNode(var value: Int, var left: TreeNode = null, var right: TreeNode = null)

object binaryTree {
  def insert(root: TreeNode, value: Int): TreeNode = {
    if root == null then
      new TreeNode(value)
    else
      if value < root.value then
        root.left = insert(root.left, value)
      else
        root.right = insert(root.right, value)
      root
  }

  def buildTreeFromArray(arr: Array[Int]): TreeNode = {
    var root: TreeNode = null
    for value <- arr do
      root = insert(root, value)
    root
  }

  def printTree(root: TreeNode): Unit = {
    case class TreeNodeInfo(node: TreeNode, level: Int)

    if root == null then
      return

    val queue = mutable.Queue[TreeNodeInfo]()
    queue.enqueue(TreeNodeInfo(root, 1))

    while queue.nonEmpty do
      val TreeNodeInfo(node, level) = queue.dequeue()

      if level > 1 then
        print(" -> ")

      print(node.value)

      if node.left != null || node.right != null then
        print(" (")

        if node.left != null then
          queue.enqueue(TreeNodeInfo(node.left, level + 1))
          print(s"L: ${node.left.value}")
          print(", ")

        if node.right != null then
          queue.enqueue(TreeNodeInfo(node.right, level + 1))
          print(s"R: ${node.right.value}")
        print(")")

      println()
  }

  def inorderTraversal(root: TreeNode): List[Int] = {
    if root == null then
      List.empty[Int]
    else
      inorderTraversal(root.left) ++ List(root.value) ++ inorderTraversal(root.right)
  }

  def preorderTraversal(root: TreeNode): List[Int] = {
    if root == null then
      List.empty[Int]
    else
      List(root.value) ++ preorderTraversal(root.left) ++ preorderTraversal(root.right)
  }

  def postorderTraversal(root: TreeNode): List[Int] = {
    if root == null then
      List.empty[Int]
    else
      postorderTraversal(root.left) ++ postorderTraversal(root.right) ++ List(root.value)
  }

  def main(args: Array[String]): Unit = {
    val inputArray = readLine("Enter elements into array: ").split(" ").map(_.toInt)
    val root = buildTreeFromArray(inputArray)
    printTree(root)

    val inorderResult = binaryTree.inorderTraversal(root)
    println(s"Inorder traversal: ${inorderResult.mkString(", ")}")

    val preorderResult = binaryTree.preorderTraversal(root)
    println(s"Preorder traversal: ${preorderResult.mkString(", ")}")

    val postorderResult = binaryTree.postorderTraversal(root)
    println(s"Postorder traversal: ${postorderResult.mkString(", ")}")
  }
}