package db

import com.knoldus.db.UserReadTo
import org.scalatest.flatspec.AnyFlatSpec

class UserReadToSpec extends AnyFlatSpec {
  val userRead = new UserReadTo
  "User details " should "send success for valid name" in {
    val res = userRead.getUserByName("user1")
    assert(!res.isEmpty)
  }

  "User details " should "send failed for invalid name" in {
    val res = userRead.getUserByName("user")
    assert(res.isEmpty)
  }
}