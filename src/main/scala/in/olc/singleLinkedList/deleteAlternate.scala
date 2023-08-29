package in.olc.linkedList

import scala.io.StdIn.readLine
import identicalList.createLinkedList

object deleteAlternate {
  private def transform[T](head: ListNode[T]): ListNode[T] = {
    if head == null && head.next == null then
      return head

    var current = head

    while current != null && current.next != null do
      val node = current.next
      current.next = node.next
      current = current.next
      node.next = null

    head
  }

  def main(args: Array[String]): Unit = {
    //Input: 1 -> 2 -> 3 -> 4
    //output: 1 -> 3

    val list = readLine("Enter elements into List: ").split(" ")

    val linkedList = createLinkedList(list)

    val result = transform(linkedList)

    println("The transformed linkedList is:")
    var temp = result
    while temp != null do
      if temp.next != null then
        print(s"${temp.value} -> ")
      else
        print(s"${temp.value}")
      temp = temp.next
  }
}
