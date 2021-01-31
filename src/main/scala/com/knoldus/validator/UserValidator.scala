package com.knoldus.validator

import com.knoldus.db.{CompanyReadDto, UserReadTo}
import com.knoldus.models.User

class UserValidator(userReadTo: UserReadTo, validateEmail: EmailValidator,
                    companyReadDto: CompanyReadDto) {

  /** *
   * check if user details are valid
   * check if email has the correct format
   * check user has valid company name
   * check if user details are stored in the hashmap
   *
   * @param user
   * @return Boolean
   */

  def userValidator(user: User): Boolean = {

    val emailValidate = validateEmail.emailIdIsValid(user.email)
    val userValidate = userReadTo.getUserByName(user.firstName)
    val companyValidate = companyReadDto.getCompanyByName(user.companyName)

    /** *
     * returns true if user details are found
     * else returns false
     */

    (emailValidate, userValidate, companyValidate) match {
      case (true, Some(value), Some(details)) =>
        true
      case _ =>
        false
    }
  }
}