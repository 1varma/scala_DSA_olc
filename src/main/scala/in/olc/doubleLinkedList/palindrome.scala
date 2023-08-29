package in.olc.doubleLinkedList

import scala.io.StdIn.readLine
import maxNode.createList

object palindrome {
  def isPalindromeStack(head: Node): Boolean = {
    var slow = head
    var fast = head
    val stack = scala.collection.mutable.Stack[Int]()

    while fast != null && fast.next != null do
      stack.push(slow.data)
      slow = slow.next
      fast = fast.next.next

    if fast != null then
      slow = slow.next

    while slow != null do
      val top = stack.pop()

      if top != slow.data then
        return false

      slow = slow.next

    true
  }

  def main(args: Array[String]): Unit = {
    val arr = readLine("Enter elements into array: ").split(" ").map(_.toInt)
    val list = createList(arr)

    if isPalindromeStack(list) then
      println("Double Linked List is a Palindrome")
    else
      println("Not a Palindrome")
  }
}
