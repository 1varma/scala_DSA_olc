package in.olc.arrays.Easy

import scala.annotation.tailrec
import scala.io.StdIn.readLine

object reverseByNum {
  private def reverse[A](ls: List[A], n: Int):List[A] =
    @tailrec
    def helper(list: List[A], rList: List[A], count: Int):List[A]=
      list match
        case head :: tail if count < n => helper(tail, head :: rList, count+1)
        case head :: tail if count >= n => list ::: rList.reverse
        case Nil => rList
    helper(ls, Nil, 0)

  private def reverseByFold[A](ls: List[A], n: Int): List[A] = {
    val (reversed, rest) = ls.splitAt(n)
    rest ::: reversed.foldRight(List.empty[A])((element, acc) => element :: acc)
  }

  private def rotate[A](num: Int, ls: List[A]): List[A] = ls.drop(num) ::: ls.take(num)

  private def reverseByNum[A](ls: List[A], n: Int): List[A] =
    val nBounded = if (ls.isEmpty) 0 else n % ls.length
    if (nBounded < 0) rotate(nBounded + ls.length, ls)
    else (ls drop nBounded) ::: (ls take nBounded)

  def main(args: Array[String]): Unit = {
    val ls = readLine("Enter elements into array: ").split(" ").toList
    val num = readLine("Enter a number for rotation: ").toInt
    println(reverse(ls, num))
    println(reverseByFold(ls, num))
    println(reverseByNum(ls, num))
  }
}
