package in.olc.linkedList

import scala.io.StdIn.readLine
import identicalList.createLinkedList

object lastToFront {
  private def transform[T](value: ListNode[T]):ListNode[T]={
    var head = value
    var tail = value
    var temp : ListNode[T] | Null = null

    while tail != null && tail.next != null && tail.next.next != null do
      tail = tail.next

    if tail != null then
      temp = tail.next
      tail.next = null
      temp.next = head
      head = temp

    head
  }

  def main(args: Array[String]): Unit = {
    val ls = readLine("Enter elements into the list: ").split(" ")

    val linkedList = createLinkedList(ls)

    val result = transform(linkedList)
    println("Transformed linked list:")
    var temp = result
    while temp != null do
      print(temp.value + " ")
      temp = temp.next
  }
}
