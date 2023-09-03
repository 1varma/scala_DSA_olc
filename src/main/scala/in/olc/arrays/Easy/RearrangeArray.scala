package in.olc.arrays.Easy

import scala.io.StdIn.readLine

object RearrangeArray {
  private def rearrangeArray(arr: Array[Int]): Unit = {
    val n = arr.length

    for (i <- 1 until n) {
      if (i % 2 == 0) {
        if (arr(i) < arr(i - 1)) {
          val temp = arr(i)
          arr(i) = arr(i - 1)
          arr(i - 1) = temp
        }
      }
      else {
        if (arr(i) > arr(i - 1)) {
          val temp = arr(i)
          arr(i) = arr(i - 1)
          arr(i - 1) = temp
        }
      }
    }

    for (i <- 0 until n) {
      print(arr(i) + " ")
    }
  }

  def main(args: Array[String]): Unit = {
    val arr = readLine("Enter numbers into array: ").split(" ").map(_.toInt)
    rearrangeArray(arr)
  }
}
