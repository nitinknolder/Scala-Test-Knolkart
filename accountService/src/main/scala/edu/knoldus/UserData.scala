package edu.knoldus

import edu.knoldus.database.Registration

trait UserData {
  def registration (): Map[Long, Registration]

  def viewAllUser (): Map[Long, Registration]
  def authenticateUser (phoneNumber: Long, password: String): Option[Registration]
  def getRegisteredUsers: List[Registration]
}
