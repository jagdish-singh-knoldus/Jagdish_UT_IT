package db

import com.knoldus.db.EmployeeReadto
import org.scalatest.flatspec.AnyFlatSpec

class EmployeeReadtoSpec extends AnyFlatSpec {
  val employeeRead = new EmployeeReadto

  "Employee details " should "send success for valid employee name" in {
    val res = employeeRead.getEmployeeByName("Jagdish")
    assert(!res.isEmpty)
  }

  "Employee details " should "send failed for invalid employee name" in {
    val res = employeeRead.getEmployeeByName("name")
    assert(res.isEmpty)
  }
}