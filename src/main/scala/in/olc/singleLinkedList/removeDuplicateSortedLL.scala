package in.olc.linkedList

import scala.io.StdIn.readLine
import addOne.createLinkedList

object removeDuplicateSortedLL {
  private def transform(head: Node):Node={
    if head == null || head.next == null then
      return head

    var current = head

    while current != null && current.next != null do

      if current.data == current.next.data then
        while current != null && current.next != null && current.data == current.next.data do
          current.next = current.next.next

      current = current.next

    head
  }

  def main(args: Array[String]): Unit = {
    val list = readLine("Enter elements into the list: ").split(" ").map(_.toInt).sorted
    val linkedList = createLinkedList(list)

    val result = transform(linkedList)
    var temp = result

    while temp != null do

      if temp.next != null then
        print(s"${temp.data} -> ")
      else
        print(s"${temp.data}")

      temp = temp.next
  }
}
