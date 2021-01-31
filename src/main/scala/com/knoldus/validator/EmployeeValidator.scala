package com.knoldus.validator

import com.knoldus.db.EmployeeReadto
import com.knoldus.models.Employee

class EmployeeValidator(employeeRead: EmployeeReadto, validateEmail: EmailValidator) {

  /** *
   * check if employee details are valid
   * check if email is of correct format
   * check if employee details are stored in the hashmap
   *
   * @param employee
   * @return Boolean
   */

  def employeeIsValid(employee: Employee): Boolean = {

    val emailValidate = validateEmail.emailIdIsValid(employee.emailId)
    val employeeValidate = employeeRead.getEmployeeByName(employee.firstName)

    /**
     * returns true if employee details are found
     * else returns false
     */

    (emailValidate, employeeValidate) match {
      case (true, Some(value)) =>
        true
      case _ =>
        false
    }
  }
}
