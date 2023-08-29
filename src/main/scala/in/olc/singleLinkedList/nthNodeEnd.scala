package in.olc.linkedList

import scala.io.StdIn.readLine
import identicalList.createLinkedList

object nthNodeEnd {
  private def nodeFromEnd[T](value: ListNode[T], n: Int):Unit={
    var count = 0
    var temp = value

    while temp != null do
      count += 1
      temp = temp.next

    if count >= n then
      val diff = count - n
      count = 0
      var temp1 = value

      while temp1 != null && count != diff do
        temp1 = temp1.next
        count += 1

      if count == diff && temp1 != null then
        println(s"The node is ${temp1.value}")
      else
        println(s"The node doesn't exists")
    else
      println(s"The node doesn't exists")
  }

  def main(args: Array[String]): Unit = {
    val list = readLine("Enter elements into the list: ").split(" ") //1 2 3 4
    val n = readLine("Enter the number of node: ").toInt //1

    val linkedList = createLinkedList(list)

    nodeFromEnd(linkedList, n)
  }
}
