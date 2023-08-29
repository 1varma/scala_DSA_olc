package in.olc.linkedList

import scala.io.StdIn.readLine
import scala.collection.mutable.Stack
import addOne.createLinkedList

object palindrome {

  private def isPalindromeReverse(head: Node): Boolean = {
    def reverse(node: Node): Node = {
      var prev: Node = null
      var current = node

      while current != null do
        val next = current.next
        current.next = prev
        prev = current
        current = next

      prev
    }

    val reversedHead = reverse(head)
    var original = head
    var reversed = reversedHead

    while original != null && reversed != null do
      if original.data != reversed.data then
        return false

      original = original.next
      reversed = reversed.next

    true
  }

  private def isPalindromeStack(head: Node): Boolean = {
    var slow = head
    var fast = head
    val stack = Stack[Int]()

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
    val list = readLine("Enter elements into the list:").split(' ').map(_.toInt)

    val linkedList = createLinkedList(list)

    isPalindromeReverse(linkedList) match
      case true => println("Linked List a palindrome using Reverse Linked List")
      case _ => println("Linked List is not a palindrome using Reverse Linked List")
    end match

    isPalindromeStack(linkedList) match
      case true => println("Linked List a palindrome using Stack Method")
      case _ => println("Linked List is not a palindrome using Stack Method")
  }
}
