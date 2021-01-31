package validator

import com.knoldus.db.{CompanyReadDto, UserReadTo}
import com.knoldus.models.User
import com.knoldus.request.UserImpl
import com.knoldus.validator.{EmailValidator, UserValidator}
import org.scalatest.flatspec.AnyFlatSpec

class UserValidatorSpec extends AnyFlatSpec {

  val companyRead = new CompanyReadDto
  val emailValidate = new EmailValidator
  val userRead = new UserReadTo
  val userValidate = new UserValidator(userRead, emailValidate, companyRead)
  val userImpl = new UserImpl(userValidate)

  "User details" should "send success if user is valid" in {
    val user1: User = User("user1", "lastName", 24, "jagdish.singh@knoldus.com", "9876543210", "city", "Knoldus")
    val res = userValidate.userValidator(user1)
    assert(res == true)
  }

  "User details" should "send failed if user is valid but company is not" in {
    val user1: User = User("user1", "lastName", 24, "jagdish.singh@knoldus.com", "9876543210", "city", "Hawk")
    val res = userValidate.userValidator(user1)
    assert(res == false)
  }
  "user details" should "send failed for invalid user details" in {
    val user1: User = User("user1", "lastName", 24, "email", "9876543210", "city", "")
    val res = userValidate.userValidator(user1)
    assert(res == false)
  }
}
