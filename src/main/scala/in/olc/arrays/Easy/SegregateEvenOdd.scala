package in.olc.arrays.Easy

import scala.io.StdIn.readLine

object SegregateEvenOdd {
  private def segregateArray(arr: Array[Int]): Unit = {
    val n = arr.length

    var evenIndex = 0

    for (i <- 0 until n) do
      if arr(i) % 2 == 0 then
        val temp = arr(i)
        arr(i) = arr(evenIndex)
        arr(evenIndex) = temp
        evenIndex += 1
  }

  def main(args: Array[String]): Unit = {
    val arr = readLine("Enter numbers into array: ").split(" ").map(_.toInt)
    segregateArray(arr)
    println("Segregated array: " + arr.mkString(" "))
  }
}