package in.olc.arrays.Easy

import scala.io.StdIn.readLine
import scala.util.Sorting

object WaveArray {
  private def sortInWave(arr: Array[Int]): Unit =
    val n = arr.length

    for (i <- 0 until n by 2) do
      if i > 0 && arr(i) < arr(i - 1) then
        val temp = arr(i)
        arr(i) = arr(i - 1)
        arr(i - 1) = temp

      if i < n - 1 && arr(i) < arr(i + 1) then
        val temp = arr(i)
        arr(i) = arr(i + 1)
        arr(i + 1) = temp

  def main(args: Array[String]): Unit = {
    val arr = readLine("Enter elements into array: ").split(" ").map(_.toInt)
    sortInWave(arr)
    println(arr.mkString(" "))
  }
}
