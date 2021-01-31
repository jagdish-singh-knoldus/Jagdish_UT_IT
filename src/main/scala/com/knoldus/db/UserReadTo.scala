package com.knoldus.db

import com.knoldus.models.User

import scala.collection.immutable.HashMap

class UserReadTo {
  val user1: User = User("user1", "lastName", 24, "email", "9876543210", "city", "Knoldus")
  val user2: User = User("user2", "lastName1", 24, "email1", "9876543210", "city1", "Philips")

  val users: HashMap[String, User] = HashMap("user1" -> user1, "user2" -> user2)

  /** *
   * get User details with key of hashmap
   *
   * @param name
   * @return Option[User]
   */

  def getUserByName(name: String): Option[User] = users.get(name)

}