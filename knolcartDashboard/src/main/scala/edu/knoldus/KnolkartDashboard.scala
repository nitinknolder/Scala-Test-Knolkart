package edu.knoldus

import edu.knoldus.database.{MyDatabase, Registration}
import org.apache.log4j.Logger

import scala.io.StdIn

object KnolkartDashboard extends App {

  val log = Logger.getLogger (this.getClass)
  val firstName = "Nitin"
  val lastName = "Arora"
  val age = 23
  val gender = "Male"
  val phoneNum = 9877665
  val password = "1234"

  val user = Registration (firstName, lastName, age, gender, phoneNum, password)
  val map = Map (user.mobileNumber -> user)
  val obj = new AccountServices (map)

  log.info ("Account Service Menu--> \n1: For Registration \n2: For Login \n")
  val choice = StdIn.readInt ()
  choice match {
    case 1 => obj.servicesMenu ()
    case 2 =>
      log.info ("Enter Your Mobile Number: ")
      val mobileNum = StdIn.readLong ()
      log.info ("Enter Your Password: ")
      val pass = StdIn.readLine ()
      obj.authenticateUser (mobileNum, pass) match {
        case None => "not successful"
        case _ => new InventoryOperation ().inventoryMenu ()
      }
    case _ => obj.servicesMenu ()
  }

  val iType = "Shoes"
  val iName = "Sports Shoes"
  val info = "Branded"
  val price = 1000
  val vendInfo = "Adidas"
  val ratings = 3

  val objShoes = MyDatabase (iType, iName, info, price, vendInfo, ratings)
  val objClothes = MyDatabase ("Clothes", "Shirt", "Cotton 100%", 2999, "Levis", 6)
  val objTv = MyDatabase ("Television", "LedTv", "40 inch", 35000, "Sony", 4)
  val objMobiles = MyDatabase ("Mobiles", "SmartPhone", "5 inch", 12000, "Asus", 2)
  val objSports = MyDatabase ("Cricket", "Bat", "nice Stroke", 3900, "Reebok", 4)
  val objCloth = MyDatabase ("Clothes", "Trouser", "pure Fabric", 2223, "Levis", 9)
  val newMap = Map (1 -> objShoes, 2 -> objClothes, 3 -> objTv, 4 -> objMobiles)
  val inventObj = new InventoryOperation (newMap)
  inventObj.inventoryMenu ()

}
