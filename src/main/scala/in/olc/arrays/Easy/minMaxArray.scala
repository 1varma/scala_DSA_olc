package in.olc.arrays.Easy

import scala.io.StdIn.readLine

object minMaxArray {
  private def minMax(arr: Array[Int]): Unit =
    val n = arr.length

    val sortedArr = arr.sorted
    val temp = Array.ofDim[Int](n)

    var left = 0
    var right = n - 1

    for (i <- 0 until n) do
      if i % 2 == 0 then
        temp(i) = sortedArr(right)
        right -= 1
      else
        temp(i) = sortedArr(left)
        left += 1

    for (i <- 0 until n) do
      arr(i) = temp(i)

  def main(args: Array[String]): Unit = {
    val arr = readLine("Enter numbers into the array: ").split(" ").map(_.toInt)
    minMax(arr)
    println(s"Rearranged array: ${arr.mkString(", ")}")
  }
}
