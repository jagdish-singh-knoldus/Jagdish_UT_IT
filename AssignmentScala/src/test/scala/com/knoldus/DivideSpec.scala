package com.knoldus

import org.scalatest.flatspec.AnyFlatSpec

class DivideSpec extends AnyFlatSpec {

  "send failed" should "not divide by zero" in {
    val result = Divide.divideIntegers(1, 0)
    assert(result == "not defined")
  }

  "send success" should "divide integers" in {
    val result = Divide.divideIntegers(10, 2)
    assert(result == 5)
  }
}
