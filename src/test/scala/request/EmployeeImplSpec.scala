package request

import com.knoldus.db._
import com.knoldus.models.{Company, Employee}
import com.knoldus.request.EmployeeImpl
import com.knoldus.validator.{CompanyValidator, EmailValidator, EmployeeValidator}
import org.scalatest.flatspec.AnyFlatSpec

class EmployeeImplSpec extends AnyFlatSpec {
  val employeeRead = new EmployeeReadto
  val emailValidate = new EmailValidator
  val employeeValidate = new EmployeeValidator(employeeRead, emailValidate)
  val employeeImpl = new EmployeeImpl(employeeValidate)

  "Employee details" should "send success valid parameter" in {
    val employeeJagdish = Employee("Jagdish", "Singh", 24, 15000, "Intern", "Knoldus", "jadish.singh@knoldus.com")
    val res = employeeImpl.createEmployee(employeeJagdish)
    assert(!res.isEmpty)
  }

  "Company details" should "send failed for invalid parameter" in {
    val employeeJagdish = Employee("Jagdish", "Singh", 24, 15000, "Intern", "Knoldus", "jadish.singh@knolds.om")
    val res = employeeImpl.createEmployee(employeeJagdish)
    assert(res.isEmpty)
  }
}