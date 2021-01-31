package validator

import com.knoldus.db.EmployeeReadto
import com.knoldus.models.Employee
import com.knoldus.request.EmployeeImpl
import com.knoldus.validator.{EmailValidator, EmployeeValidator}
import org.scalatest.flatspec.AnyFlatSpec

class EmployeeValidatorSpec extends AnyFlatSpec {

  val employeeRead = new EmployeeReadto
  val emailValidate = new EmailValidator
  val employeeValidate = new EmployeeValidator(employeeRead, emailValidate)
  val employeeImpl = new EmployeeImpl(employeeValidate)

  "Employee details" should "send success for valid Employee" in {
    val employeeJagdish = Employee("Jagdish", "Singh", 24, 15000, "Intern", "Knoldus", "jadish.singh@knoldus.com")
    val res = employeeValidate.employeeIsValid(employeeJagdish)
    assert(res == true)
  }

  "Employee details" should "send failed for invalid Employee" in {
    val employeeInvalid = Employee("Jagdish", "Singh", 24, 15000, "Intern", "Knoldus", "jadish.singh@knoldus.om")
    val res = employeeValidate.employeeIsValid(employeeInvalid)
    assert(res == false)
  }

}