package in.olc.arrays.Easy

import scala.Int.MinValue
import scala.io.StdIn.readLine

object secondLargest {
  private def secondLargest(arr: Array[Int]):Unit=
    var n1, n2 = MinValue

    for i <- arr do
      if n1 < i then
        n2 = n1
        n1 = i
      else if n2 < i then
        n2 = i

    println(s"The Second largest number is: ${n2}")

  def main(args: Array[String]): Unit = {
    val arr = readLine("Enter numbers into array: ").split(" ").map(_.toInt)
    secondLargest(arr)
  }
}
