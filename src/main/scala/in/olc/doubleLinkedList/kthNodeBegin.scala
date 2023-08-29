package in.olc.doubleLinkedList

import scala.io.StdIn.readLine
import maxNode.createList

object kthNodeBegin {
  private def kthNodeBegin(head: Node, k : Int):Unit={
    var count = 0
    var currentNode = head

    while currentNode != null do
      if count == k then
        println(s"${currentNode.data}")
        return
      else
        count += 1
        currentNode = currentNode.next
  }

  def main(args: Array[String]): Unit = {
    val arr = readLine("Enter elements into array: ").split(" ").map(_.toInt)
    val list = createList(arr)
    val k = readLine("Enter the node to print: ").toInt

    kthNodeBegin(list, k)
  }
}
