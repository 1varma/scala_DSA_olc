package in.olc.linkedList

import scala.io.StdIn.readLine
import addOne.createLinkedList
import loopLinkedList.transform

object detectLoop {
  private def detect(head: Node):Boolean={
    var slow = head
    var fast = head

    while slow != null && fast != null && fast.next != null do
      slow = slow.next
      fast = fast.next.next
      if slow == fast then
        return true

    false
  }

  def main(args: Array[String]): Unit = {
    val list = readLine("Enter elements into the list: ").split(" ").map(_.toInt)

    val linkedList = createLinkedList(list)

    val loopedLinkedList = transform(linkedList, 0)

    detect(loopedLinkedList) match
      case true => println("Loop Found")
      case _ => println("No Loop")
  }
}
