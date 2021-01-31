package com.knoldus.validator

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.Company

class CompanyValidator(companyRead: CompanyReadDto, validateEmail: EmailValidator) {

  /** *
   * check if company details are correct
   * check if the email has valid format
   * check if company details are stored in the hashmap
   *
   * @param company
   * @return Boolean
   */

  def companyIsValid(company: Company): Boolean = {

    val emailValidate = validateEmail.emailIdIsValid(company.emailId)
    val companyValidate = companyRead.getCompanyByName(company.name)

    /** *
     * returns true if company details are valid
     * else returns false
     */

    (emailValidate, companyValidate) match {
      case (true, Some(value)) =>
        true
      case _ =>
        false
    }
  }

}