package in.olc.linkedList

import scala.io.StdIn.readLine
import identicalList.createLinkedList

object middleList {

  // Logic 1: Function to find the middle element of a linked list
  private def middleElement[T](value: ListNode[T]): Option[T] = {
    var temp = value
    var temp1 = value
    var count = 0

    while temp != null do
      count += 1
      temp = temp.next

    val mid = count / 2
    count = 0

    while temp1 != null do
      if count == mid then
        return Some(temp1.value)
      else
        temp1 = temp1.next
        count += 1

    None
  }

  //Logic:2 Function to print the middle element of a linked list
  private def printMiddle[T](value: ListNode[T]): Unit = {
    var slow = value
    var fast = value

    while fast != null && fast.next != null do
      slow = slow.next
      fast = fast.next.next

    if slow != null then
      println(s"The middle value is ${slow.value}")
    else
      println("There is no middle value exists.")
  }

  def main(args: Array[String]): Unit = {
    var t = readLine("Enter the number of test cases: ").toInt

    while t > 0 do
      val list1 = readLine("Enter elements into linked list1: ").split(" ") // 1,2,3,4 output 3
      val linkedList1 = createLinkedList(list1)

      val result = middleElement(linkedList1)

      result match
        case Some(value) =>
          println(s"The middle value is $value")
        case None =>
          println("There is no middle value exists.")
      end match

      printMiddle(linkedList1)

      t -= 1
  }
}
