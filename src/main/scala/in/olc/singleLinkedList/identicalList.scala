package in.olc.linkedList

import scala.io.StdIn.readLine

// Definition of a generic ListNode
class ListNode[T](val value: T, var next: ListNode[T] | Null)

object identicalList {

  // Function to check if two linked lists are identical
  private def areIdentical[T](a: ListNode[T], b: ListNode[T]): Boolean = {
    var currentA = a
    var currentB = b

    while currentA != null && currentB != null do
      if currentA.value != currentB.value then
        return false

      currentA = currentA.next
      currentB = currentB.next

    // If both lists are traversed completely and no mismatch found, they are identical
    currentA == null && currentB == null
  }

  // Function to create a linked list from an array of values
  def createLinkedList[T](values: Array[T]): ListNode[T] = {
    var head: ListNode[T] | Null = null
    var tail: ListNode[T] | Null = null

    for value <- values do
      val newNode = new ListNode[T](value, null)
      if head == null then
        head = newNode
        tail = newNode
      else
        tail.next = newNode
        tail = newNode

    head.asInstanceOf[ListNode[T]] // Safe conversion due to previous null checks
  }

  def main(args: Array[String]): Unit = {
    var t = readLine("Enter the number of test case: ").toInt

    while t > 0 do
      val inputA = readLine("Enter elements into first linked list: ").split(" ") // 1 -> 2 -> 3 -> 4 -> null
      val inputB = readLine("Enter elements into second linked list: ").split(" ") //1 -> 2 -> 3 -> 4 -> null

      val a = createLinkedList(inputA)
      val b = createLinkedList(inputB)

      if areIdentical(a, b) then
        println("Identical")
      else
        println("Not Identical")

      t -= 1
  }
}
