package com.knoldus.db

import com.knoldus.models.Employee

import scala.collection.immutable.HashMap

class EmployeeReadto {
  val employeeJagdish = Employee("Jagdish", "Singh", 24, 15000, "Intern", "Knoldus", "jadish.singh@knoldus.com")
  val employeeSample = Employee("firstName", "lastName", 24, 15000, "Designation", "Company", "email@domain.com")
  val employees: HashMap[String, Employee] = HashMap("Jagdish" -> employeeJagdish, "Sample" -> employeeSample)

  /** *
   * get employee details with key of hashmap
   *
   * @param name
   * @return Option[Employee]
   */

  def getEmployeeByName(name: String): Option[Employee] = employees.get(name)
}
