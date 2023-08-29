package in.olc.doubleLinkedList

import scala.io.StdIn.readLine
import maxNode.createList

object reverse {
  private def reverseList(head: Node): Node = {
    var current = head

    while current != null do
      val temp = current.next
      current.next = current.prev
      current.prev = temp

      if temp == null then
        return current

      current = temp

    null
  }

  def main(args: Array[String]): Unit = {
    val arr = readLine("Enter elements into array: ").split(' ').map(_.toInt)
    val linkedList = createList(arr)

    val reverse = reverseList(linkedList)
    maxNode.printList(reverse)
  }
}
