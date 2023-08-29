package in.olc.arraysEasy

import scala.io.StdIn.readLine

object moveZero {
  private def moveZerosToEnd(arr: Array[Int]): Unit = {
    var nonZeroIndex = 0

    for (i <- 0 until arr.length) {
      if (arr(i) != 0) {
        val temp = arr(nonZeroIndex)
        arr(nonZeroIndex) = arr(i)
        arr(i) = temp
        nonZeroIndex += 1
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val arr = readLine("Enter numbers into the array: ").split(" ").map(_.toInt)
    println("Original array: " + arr.mkString(" "))
    moveZerosToEnd(arr)
    println("Array after moving zeros to end: " + arr.mkString(" "))
  }
}
