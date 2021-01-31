package com.knoldus

import scala.io.StdIn._

object Fibonacci {

  /** *
   * stores series of fibonacci in Array
   *
   * @param n
   * @return Array[Int]
   */

  def fibonacci(n: Int): Array[Int] = {
    var fibonacciArray: Array[Int] = new Array[Int](n)
    var temp = 0

    for (i <- 0 to n - 1; if (n > 0)) {
      if (i < 2) {
        fibonacciArray(i) = 1
        temp = fibonacciArray(i)
      } else {
        fibonacciArray(i) = fibonacciArray(i - 1) + temp
        temp = fibonacciArray(i - 1)
      }
    }
    fibonacciArray
  }

  def main(args: Array[String]) {
    print("Enter range for series : ")
    val a = readInt()
    var ar = fibonacci(a)
    ar.foreach(x => print(x + ", "))
  }
}
