package com.knoldus

import org.scalatest.flatspec.AnyFlatSpec

class FibonacciSpec extends AnyFlatSpec {

  "Fibonacci" should "send success for right series" in {
    val result: Array[Int] = Array(1, 1, 2, 3, 5)
    val res = Fibonacci.fibonacci(5)
    assert(result.sameElements(res))
  }

  "Fibonacci" should "send failed for negative input" in {
    val caught =
      intercept[NegativeArraySizeException] {
        Fibonacci.fibonacci(-1)
      }
    assert(caught.getMessage.indexOf("-1") != -1)
  }
}