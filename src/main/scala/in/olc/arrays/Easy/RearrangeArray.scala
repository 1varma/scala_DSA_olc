package in.olc.arrays.Easy

import scala.io.StdIn.readLine

object RearrangeArray {
  private def swap(arr: Array[Int], i:Int):Unit={
    val temp = arr(i)
    arr(i) = arr(i - 1)
    arr(i - 1) = temp
  }

  private def rearrangeArray(arr: Array[Int]): Unit = {
    val n = arr.length

    for i <- 1 until n do
      if i % 2 == 0 then
        if arr(i) < arr(i - 1) then
          swap(arr, i)
      else
        if arr(i) > arr(i - 1) then
          swap(arr, i)

    for i <- arr.indices do
      print(arr(i) + " ")
  }

  def main(args: Array[String]): Unit = {
    val arr = readLine("Enter numbers into array: ").split(" ").map(_.toInt)
    rearrangeArray(arr)
  }
}
