package com.knoldus

import scala.util.matching.Regex

object EMailValidation {

  /** *
   * check if eamil is valid
   *
   * @param mail
   * @return Boolean
   */

  def validEmail(mail: String): Boolean = {
    val emailPattern = "^([a-zA-Z\\d\\.-]+)@([a-zA-Z\\d-]+)\\.(com|net|org)$"
    mail.matches(emailPattern)
  }

  def main(args: Array[String]): Unit = {
    println(validEmail("jagdish.singh@knoldus.com"))
    println(validEmail("Jagd12@gmail.aom"))
    println(validEmail("Jagd12@gmail.inet"))
    println(validEmail("Jagd12@gmai131l.aom"))

  }
}