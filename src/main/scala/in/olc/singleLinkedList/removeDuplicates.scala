package in.olc.linkedList

import scala.io.StdIn.readLine
import addOne.createLinkedList

import scala.collection.mutable

object removeDuplicates {
  private def removeDuplicates(head: Node):Node ={
    if head == null || head.next == null then
      return head

    val hashSet = mutable.HashSet[Int]()
    var current = head
    hashSet.add(head.data)

    while current.next != null do
      if hashSet.contains(current.next.data) then
        current.next = current.next.next
      else
        hashSet.add(current.next.data)
        current = current.next

    head
  }

  def main(args: Array[String]): Unit = {
    val list = readLine("Enter elements into the linkedList: ").split(" ").map(_.toInt)
    val linkedList = createLinkedList(list)

    val result = removeDuplicates(linkedList)
    var temp = result

    while temp != null do
      if temp.next != null then
        print(s"${temp.data} -> ")
      else
        print(s"${temp.data}")
      temp = temp.next
  }
}