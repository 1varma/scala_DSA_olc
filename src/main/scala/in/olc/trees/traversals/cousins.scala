package in.olc.trees.traversals

import in.olc.trees.traversals.TreeNode

class BinaryTree(var root: TreeNode | Null = null):

  def level(node: TreeNode, ptr: TreeNode, lev: Int): Int =
    if node == null then 0
    else if node == ptr then lev
    else
      val l = level(node.left, ptr, lev + 1)
      if l != 0 then l else level(node.right, ptr, lev + 1)

  def isCousin(node: TreeNode, a: TreeNode, b: TreeNode): Boolean =
    level(node, a, 1) == level(node, b, 1)

object cousins {
  def main(args: Array[String]): Unit = {
    val tree = BinaryTree()
    tree.root = TreeNode(1)
    tree.root.left = TreeNode(2)
    tree.root.right = TreeNode(3)
    tree.root.left.left = TreeNode(4)
    tree.root.left.right = TreeNode(5)
    tree.root.left.right.right = TreeNode(15)
    tree.root.right.left = TreeNode(6)
    tree.root.right.right = TreeNode(7)
    tree.root.right.left.right = TreeNode(8)

    val node1 = tree.root.left.left
    val node2 = tree.root.right.left.right
    if tree.isCousin(tree.root, node1, node2) then
      println("Yes")
    else
      println("No")
  }
}
