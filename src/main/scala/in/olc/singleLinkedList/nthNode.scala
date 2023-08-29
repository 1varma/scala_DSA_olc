package in.olc.linkedList

import scala.io.StdIn.readLine
import identicalList.createLinkedList

object nthNode {
  private def GetNth[T](node: ListNode[T], n: Int):Unit ={
    var count = 0
    var temp = node

    while temp != null do
      if count == n then
        println(s"The $n node is ${temp.value}")
        return

      else
        count += 1
        temp = temp.next
  }

  def main(args: Array[String]): Unit = {
    var t = readLine("Enter number of test cases: ").toInt

    while t > 0 do
      val list = readLine("Enter elements into the list: ").split(" ")
      val n = readLine("Enter the node number: ").toInt

      val linkedList = createLinkedList(list)

      if n <= list.length then
        GetNth(linkedList, n)
      else
        println(s"The value of n ($n) is invalid")

      t -=1
  }
}
