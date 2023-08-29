package in.olc.doubleLinkedList

import maxNode.createList
import scala.io.StdIn.readLine

object kthNodeEnd {
  private def kthNodeEnd(head: Node, k: Int): Unit = {
    var count = 0
    var currentNode = head

    while currentNode != null do
      count += 1
      currentNode = currentNode.next

    val n = count - k
    count = 0

    var current = head
    while current != null do
      if n == count then
        println(s"${current.data}")
        return
      else
        count += 1
        current = current.next
  }

  def main(args: Array[String]): Unit = {
    val arr = readLine("Enter elements into array: ").split(" ").map(_.toInt)
    val list = createList(arr)
    val k = readLine("Enter the node to print: ").toInt

    kthNodeEnd(list, k)
  }
}
