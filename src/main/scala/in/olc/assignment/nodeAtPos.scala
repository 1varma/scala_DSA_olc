package in.olc.assignment

import scala.io.StdIn.readLine

class Node(var data: Int, var next: Node | Null)

object nodeAtPos {
  private def transform(head: Node, n: Int, node: Node):Node={
    var temp = head
    var count = 0

    while temp != null do
      if count + 1 == n then
        val temp1 = temp.next
        temp.next = node
        node.next = temp1
        return head
      else
        temp = temp.next
        count += 1

    head
  }

  private def newNode(data: Int): Node = new Node(data, null)

  private def createLinkedList(arr: Array[Int]): Node = {
    var head: Node | Null = null
    var tail: Node | Null = null

    for value <- arr do
      val newNode = new Node(value, null)
      if head == null then
        head = newNode
        tail = newNode
      else
        tail.next = newNode
        tail = newNode

    head.asInstanceOf[Node] // Safe conversion due to previous null checks
  }

  private def printList(node: Node): Unit = {
    var temp = node

    while temp != null do

      if temp.next != null then
        print(s"${temp.data} -> ")
      else
        print(s"${temp.data}")

      temp = temp.next
  }

  def main(args: Array[String]): Unit = {
    val list = readLine("Enter elements into the list: ").split(" ").map(_.toInt)
    val n = readLine("Enter the position of node to insert: ").toInt
    val num = readLine("Enter the number to insert into Linked List: ").toInt

    val node = newNode(num)
    val linkedList = createLinkedList(list)

    val result = transform(linkedList, n, node)

    println("Linked list after inserting node at position:")
    printList(result)
  }
}
