package com.knoldus

import org.scalatest.flatspec.AnyFlatSpec

class EMailValidationSpec extends AnyFlatSpec {

  "send success" should " email has alphanumeric username in lowercase or uppercase" in {
    val result: Boolean = EMailValidation.validEmail("jagdish.singh@knoldus.com")
    assert(result == true)
  }

  "send failed" should " for invalid email" in {
    val result: Boolean = EMailValidation.validEmail("testEmail@email.test")
    assert(result == false)
  }
}