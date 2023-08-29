package in.olc.doubleLinkedList

import scala.io.StdIn.readLine

class Node(var data: Int, var prev: Node = null, var next: Node = null)

object maxNode {
  private def maxNode(head: Node):Int={
    if head == null then
      throw new NoSuchElementException("List is empty")

    var index = 0
    var value = head.data
    var currentNode = head
    var maxIndex = 0

    while currentNode != null do
      if currentNode.data > value then
        value = currentNode.data
        maxIndex = index

      index += 1
      currentNode = currentNode.next

    maxIndex
  }

  def createList(values: Array[Int]): Node = {
    var head: Node | Null = null
    var tail: Node | Null = null

    for value <- values do
      val newNode = new Node(value)
      if head == null then
        head = newNode
        tail = newNode
      else
        tail.next = newNode
        newNode.prev = tail
        tail = newNode

    head.asInstanceOf[Node] // Safe conversion due to previous null checks
  }

  def printList(head: Node): Unit = {
    var current: Node = head

    while current != null do

      if current.next != null then
        print(s"${current.data} <-> ")
        current = current.next
      else
        print(s"${current.data} <-> Null")
        current = current.next

    println()
  }

  def main(args: Array[String]): Unit = {
    val arr = readLine("Enter elements into array: ").split(" ").map(_.toInt)
    val linkedList = createList(arr)

    if linkedList != null then
      println("Doubly Linked List:")
      printList(linkedList)

    else
      println("The list is empty.")

    val max = maxNode(linkedList)
    println(s"The maximum node is: $max")
  }
}
