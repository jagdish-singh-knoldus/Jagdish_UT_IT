package com.knoldus.request

import com.knoldus.models.Employee
import com.knoldus.validator.EmployeeValidator

class EmployeeImpl(employeeValidator: EmployeeValidator) {

  /** *
   * check if employee details exist in the hashmap
   *
   * @param employee
   * @return Option[String]
   */

  def createEmployee(employee: Employee): Option[String] = {
    if (employeeValidator.employeeIsValid(employee))
      Option(employee.emailId)
    else None
  }
}
