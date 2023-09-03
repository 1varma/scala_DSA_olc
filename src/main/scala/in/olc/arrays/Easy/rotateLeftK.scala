package in.olc.arrays.Easy

import scala.io.StdIn.readLine

object rotateLeftK {
  private def rotatedLeftK[A](arr: List[A], k: Int):List[A] ={
    val n = arr.length
    val rotations = k % n
    val (left, right) = arr.splitAt(rotations)
    left.foldLeft(right)((acc, element) => acc :+ element)
  }

  def main(args: Array[String]): Unit = {
    val arr = readLine("Enter elements into array: ").split(" ").toList
    val k = readLine("Enter the number of positions to rotate left: ").toInt
    println(s"Rotate array: ${rotatedLeftK(arr, k).mkString(", ")}")
  }
}
