package in.olc.arrays.Easy

import scala.io.StdIn.readLine

object sortArrayWithoutReplacement {
  private def sortArray(arr: Array[Int]): Unit = {
    var i = 0
    while i < arr.length do
      // Check if the element is in the correct position

      if arr(i) != i + 1 then
        // Swap the element with the one at the correct position
        val temp = arr(i)
        arr(i) = arr(temp - 1)
        arr(temp - 1) = temp

      else
        i += 1
  }

  def main(args: Array[String]): Unit = {
    val arr = readLine("Enter elements into the array: ").split(" ").map(_.toInt)

    // Function call to sort the array
    sortArray(arr)

    // Printing the sorted array
    println(arr.mkString(" ")) // Output: 1 2 3 4 5 6
  }
}