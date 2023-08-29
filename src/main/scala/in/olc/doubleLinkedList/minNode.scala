package in.olc.doubleLinkedList

import scala.io.StdIn.readLine
import maxNode.createList

object minNode {
  private def minNode(head: Node):Int = {
    if head == null then
      throw new NoSuchElementException("List is empty")

    var index = 0
    var value = head.data
    var currentNode = head
    var minIndex = 0

    while currentNode != null do
      if currentNode.data <= value then
        value = currentNode.data
        minIndex = index

      index += 1
      currentNode = currentNode.next

    minIndex
  }

  def main(args: Array[String]): Unit = {
    val arr = readLine("Enter elements into array: ").split(" ").map(_.toInt)
    val linkedList = createList(arr)

    println(s"The minimum node is ${minNode(linkedList)}")
  }
}