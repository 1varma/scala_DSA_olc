package in.olc.arrays.Easy

import scala.io.StdIn.readLine

object minMaxArray {
  private def minMax(arr: Array[Int]): Unit = {
    val sortedArr = arr.sorted
    val result = arr.indices.map { i =>
      if (i % 2 == 0) sortedArr(arr.length - 1 - i / 2)
      else sortedArr(i / 2)
    }.toArray

    result.copyToArray(arr)
  }

  def main(args: Array[String]): Unit = {
    val arr = readLine("Enter numbers into the array: ").split(" ").map(_.toInt)
    minMax(arr)
    println(s"Rearranged array: ${arr.mkString(", ")}")
  }
}
