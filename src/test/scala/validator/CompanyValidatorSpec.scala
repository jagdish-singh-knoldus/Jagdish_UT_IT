package validator

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.Company
import com.knoldus.request.CompanyImpl
import com.knoldus.validator.{CompanyValidator, EmailValidator}
import org.scalatest.flatspec.AnyFlatSpec

class CompanyValidatorSpec extends AnyFlatSpec {
  val companyRead = new CompanyReadDto
  val emailValidate = new EmailValidator
  val companyValidate = new CompanyValidator(companyRead, emailValidate)

  "Company details" should "send success for valid parameter" in {
    val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")
    val res = companyValidate.companyIsValid(knoldusCompany)
    assert(res == true)
  }

  "Company details" should "send failed for invalid parameter" in {
    val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.om", "Noida")
    val res = companyValidate.companyIsValid(knoldusCompany)
    assert(res == false)
  }

}