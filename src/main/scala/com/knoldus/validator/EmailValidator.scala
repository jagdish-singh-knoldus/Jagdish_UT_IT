package com.knoldus.validator

class EmailValidator {

  /** *
   * check if emailId has the valid format
   *
   * @param emailId
   * @return Boolean
   */

  def emailIdIsValid(emailId: String): Boolean = {
    val emailPattern = "^([a-zA-Z\\d\\.-]+)@([a-zA-Z\\d-]+)\\.(com|net|org)$"
    emailId.matches(emailPattern)
  }
}