package in.olc.linkedList

import scala.io.StdIn.readLine
import addOne.createLinkedList

object loopLinkedList {
  def transform(head: Node, n: Int):Node={
    var tail = head

    while tail.next != null do
      tail = tail.next

    var count = 0
    var temp = head

    while temp != null do
      temp = temp.next
      count += 1
      if count == n then
        tail.next = temp
        return head

    head
  }

  def main(args: Array[String]): Unit = {
    val ls = readLine("Enter elements into the list: ").split(" ").map(_.toInt)
    val n = readLine("Enter index of node where to add  a loop: ").toInt

    val linkedList = createLinkedList(ls)
    val result = transform(linkedList, n)
  }
}
