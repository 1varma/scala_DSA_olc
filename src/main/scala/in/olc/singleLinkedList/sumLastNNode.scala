package in.olc.linkedList

import scala.io.StdIn.readLine
import addOne.createLinkedList

object sumLastNNode {
  private def transform(head: Node, n: Int):Int={
    var temp = head
    var count = 0
    var sum = 0

    while temp != null do
      count += 1
      temp = temp.next

    val diff = math.abs(count - n)
    println(diff)

    count = 0
    var temp1 = head

    while temp1 != null do
      if count >= diff then
        sum += temp1.data
      else
        count += 1
      temp1 = temp1.next

    sum
  }

  def main(args: Array[String]): Unit = {
    val list = readLine("Enter the elements into list: ").split(" ").map(_.toInt)
    val num = readLine("Enter the number: ").toInt

    val linkedList = createLinkedList(list)

    println(s"The sum of last $num in linked list is: ${transform(linkedList, num)}")
  }
}
