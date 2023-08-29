package in.olc.doubleLinkedList

import scala.io.StdIn.readLine
import maxNode.createList

object mergeList {
  def mergeSortedLists(list1: Node, list2: Node): Node = {
    if (list1 == null) return list2
    if (list2 == null) return list1

    var mergedHead: Node = null
    var mergedTail: Node = null
    var current1 = list1
    var current2 = list2

    if current1.data <= current2.data then
      mergedHead = current1
      current1 = current1.next
    else
      mergedHead = current2
      current2 = current2.next

    mergedTail = mergedHead

    while current1 != null && current2 != null do
      if current1.data <= current2.data then
        mergedTail.next = current1
        current1.prev = mergedTail
        mergedTail = current1
        current1 = current1.next
      else
        mergedTail.next = current2
        current2.prev = mergedTail
        mergedTail = current2
        current2 = current2.next

    if current1 != null then
      mergedTail.next = current1
      current1.prev = mergedTail
    else if current2 != null then
      mergedTail.next = current2
      current2.prev = mergedTail

    mergedHead
  }

  def main(args: Array[String]): Unit = {
    val arr = readLine("Enter elements into array: ").split(" ").map(_.toInt)
    val arr1 = readLine("Enter elements into array: ").split(" ").map(_.toInt)

    val list1 = createList(arr)
    val list2 = createList(arr1)

    val result = mergeSortedLists(list1, list2)
    maxNode.printList(result)
  }
}
