package in.olc.linkedList

import scala.io.StdIn.readLine
import addOne.createLinkedList
import addTwoLinkedList.splitToDigits

object subtractTwoLinkedList {
  private def transform(list1: Node, list2: Node):Node={
    var one = list1
    var two = list2

    var num1 = 0
    var num2 = 0

    while one != null do
      if one.next != null then
        num1 += one.data
        num1 *= 10
      else
        num1 += one.data
      one = one.next

    while two != null do
      if two.next != null then
        num2 += two.data
        num2 *= 10
      else
        num2 += two.data
      two = two.next

    val result = math.abs(num1 - num2)


    val arr = splitToDigits(result)

    createLinkedList(arr)
  }

  def main(args: Array[String]): Unit = {
    val list1 = readLine("Enter elements into the LinkedList1: ").split(" ").map(_.toInt)
    val list2 = readLine("Enter elements into the LinkedList2: ").split(" ").map(_.toInt)

    val linkedList1 = createLinkedList(list1)
    val linkedList2 = createLinkedList(list2)

    val result = transform(linkedList1, linkedList2)

    println("The Resultant list is:")

    var temp = result
    while temp != null do
      if temp.next != null then
        print(s"${temp.data} -> ")
      else
        print(s"${temp.data} -> Null")
      temp = temp.next
  }
}
