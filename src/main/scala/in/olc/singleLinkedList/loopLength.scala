package in.olc.linkedList

import scala.io.StdIn.readLine
import addOne.createLinkedList
import loopLinkedList.transform

object loopLength {
  private def findLoopLength(head: Node): Int = {
    var slow = head
    var fast = head
    var loopExists = false

    while slow != null && fast != null && fast.next != null && !loopExists do
      slow = slow.next
      fast = fast.next.next
      if slow == fast then
        loopExists = true

    if !loopExists then
      return 0

    var length = 1
    fast = fast.next
    while slow != fast do
      fast = fast.next
      length += 1

    length
  }

  def main(args: Array[String]): Unit = {
    val ls = readLine("Enter elements into the list: ").split(" ").map(_.toInt)
    val n = readLine("Enter index of node where to add a loop: ").toInt

    val linkedList = createLinkedList(ls)
    val result = transform(linkedList, n)

    val loopLength = findLoopLength(result)
    println(s"Length of the loop: $loopLength")
  }
}
