package in.olc.arraysEasy

import scala.Int.MinValue
import scala.io.StdIn.readLine

object largestThree {
  private def largest(n: Array[Int]):Unit =
    var n1, n2, n3 = MinValue

    for i <- n do
      if n1 < i then
        n3 = n2
        n2 = n1
        n1 = i
      else if n2 < i then
        n3 = n2
        n2 = i
      else if n3 < i then
        n3 = i

    println(s"The largest three numbers are: $n1 $n2 $n3")


  def main(args: Array[String]): Unit = {
    val arr = readLine("Enter numbers into the array: ").split(" ").map(_.toInt)
    largest(arr)
  }
}
