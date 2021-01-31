package com.knoldus.request

import com.knoldus.models.User
import com.knoldus.validator.UserValidator

class UserImpl(userValidator: UserValidator) {

  /** *
   * check if user details exist in the hashmap
   *
   * @param user
   * @return Option[String]
   */

  def createUser(user: User): Option[String] = {
    if (userValidator.userValidator(user))
      Option(user.email)
    else None
  }
}
