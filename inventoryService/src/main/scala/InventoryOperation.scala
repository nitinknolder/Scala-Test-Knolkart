package edu.knoldus

import edu.knoldus.database.MyDatabase
import org.apache.log4j.Logger

import scala.io.StdIn


class InventoryOperation (product: Map[Int, MyDatabase] = Map ()) {

  val log = Logger.getLogger (getClass)

  def inventoryMenu (): Unit = {

    log.info ("Welcome To Inventory!!! \n Select Your Choice From Menu: \n")
    log.info ("1: Add Item \n")
    log.info ("2: Delete Item \n")
    log.info ("3: View Item \n")
    log.info ("4: Search Item \n")
    log.info ("5: Exit \n")
    log.info ("Enter your Choice: ")
    val select = StdIn.readInt ()

    select match {
      case 1 => addItem ()
      case 2 => deleteItem ()
      case 3 => viewItem ()
      case 4 => new Searching (product).searchMenu (product)
      case 5 => exit ()
    }
  }

  // ***********Add Items****************
  def addItem (): Map[Int, MyDatabase] = {

    log.info ("Add Your Items \n")
    log.info ("Enter Type Of Item")
    val iType = StdIn.readLine ()

    log.info ("Enter Item Name: \n ")
    val iName = StdIn.readLine ()

    log.info ("Enter Product Description: \n")
    val info = StdIn.readLine ()

    log.info ("Enter Price: \n")
    val price = StdIn.readDouble ()

    log.info ("Enter Vendor Info: \n")
    val vendInfo = StdIn.readLine ()
    log.info ("Enter the Product rating: \n")
    val ratings = StdIn.readFloat ()
    log.info (s"$iName $info $price $vendInfo $ratings Added" + "\n")

    val list = product.keySet.toList
    val maximum = list.max
    val reInventoryInfo = MyDatabase (iType: String, iName: String, info: String, price: Double, vendInfo: String, ratings: Float)
    val newMap = Map (maximum + 1 -> reInventoryInfo)
    new InventoryOperation (product ++ newMap).inventoryMenu ()
    product
  }

  //****************View Items***********
  def viewItem (): Map[Int, MyDatabase] = {

    val viewData = product.toList
    for (product <- viewData)
      log.info (product + "\n")

    new InventoryOperation (product).inventoryMenu ()
    product
  }

  //***************Delete Items**********
  def deleteItem (): Map[Int, MyDatabase] = {
    log.info ("Enter Item to Be deleted")

    val itemToBeDeleted = 2
    val prod = product.filterKeys (_ != itemToBeDeleted)
    new InventoryOperation (prod).inventoryMenu ()
    product
  }

  //***************Exit******************
  def exit () = "<-----Thanks For Using KnolKart<---- \n"

}















