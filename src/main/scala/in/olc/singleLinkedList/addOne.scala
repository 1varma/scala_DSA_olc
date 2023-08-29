package in.olc.linkedList

import scala.io.StdIn.readLine
import addTwoLinkedList.splitToDigits

class Node(var data: Int, var next: Node | Null)

object addOne {

  def newNode(data: Int): Node = new Node(data, null)

  private def addOne(head: Node): Node = {
    var one = head

    var num1 = 0

    while one != null do
      if one.next != null then
        num1 += one.data
        num1 *= 10
      else
        num1 += one.data
      one = one.next

    createLinkedList(splitToDigits(num1+1))
  }

  private def printList(node: Node): Unit = {
    var temp = node

    while temp != null do
      if temp.next != null then
        print(s"${temp.data} -> ")
      else
        print(s"${temp.data}")
      temp = temp.next
  }

  def createLinkedList(arr: Array[Int]): Node = {
    var head: Node | Null = null
    var tail: Node | Null = null

    for value <- arr do
      val newNode = new Node(value, null)
      if head == null then
        head = newNode
        tail = newNode
      else
        tail.next = newNode
        tail = newNode

    head.asInstanceOf[Node] // Safe conversion due to previous null checks
  }

  def main(args: Array[String]): Unit = {
    val inputArray = readLine("Enter elements into the array: ").split(" ").map(_.toInt)

    val linkedList = createLinkedList(inputArray)

    print("List is ")
    printList(linkedList)

    val newHead = addOne(linkedList)

    println()
    print("Resultant list is ")
    printList(newHead)
  }
}