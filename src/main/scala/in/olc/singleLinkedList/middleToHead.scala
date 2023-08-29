package in.olc.linkedList

import scala.io.StdIn.readLine
import identicalList.createLinkedList

object middleToHead {
  private def transform[T](head: ListNode[T]):ListNode[T] = {
    if head == null || head.next == null then
      return head

    var temp = head
    var temp1 = head
    var prev: ListNode[T] | Null = null

    while temp1 != null && temp1.next != null do
      prev = temp
      temp = temp.next
      temp1 = temp1.next.next

    prev.next = prev.next.next
    temp.next = head

    temp
  }

  def main(args: Array[String]): Unit = {
    val list = readLine("Enter elements into list: ").split(" ")

    val linkedList = createLinkedList(list)

    val result = transform(linkedList)

    println("Transformed linked list:")
    var temp = result
    while temp != null do
      print(temp.value + " ")
      temp = temp.next
  }
}
