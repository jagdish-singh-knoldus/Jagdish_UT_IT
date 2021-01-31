package db

import com.knoldus.db.CompanyReadDto
import org.scalatest.flatspec.AnyFlatSpec

class ComapnyReadto extends AnyFlatSpec {

  val companyRead = new CompanyReadDto()
  "Company details " should "send success for valid company name" in {
    val res = companyRead.getCompanyByName("Knoldus")
    assert(!res.isEmpty)
  }

  "Company details " should "send failed for invalid company name" in {
    val res = companyRead.getCompanyByName("name")
    assert(res.isEmpty)
  }

}