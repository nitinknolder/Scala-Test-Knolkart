import edu.knoldus.database.MyDatabase
import edu.knoldus.{InventoryOperation, Searching}
import org.scalatest.FunSuite

class TestingWithFunSuite extends FunSuite {

  val objClothes = MyDatabase ("Clothes", "Shirt", "Cotton 100%", 2999, "Levis", 6)
  val objTv = MyDatabase ("Television", "LedTv", "40 inch", 35000, "Sony", 4)
  val newMap = Map (1 -> objClothes, 2 -> objTv)

  val inventory = new InventoryOperation (newMap)

  test ("Item to be deleted:") {
    assert (inventory.deleteItem () == newMap.take (1))
  }
  val search = new Searching (newMap)
  test ("High to low By Price: ") {
    assert (search.highToLow == Map (2 -> objTv, 1 -> objClothes))
  }
  test ("High to low By Price: ") {
    assert (search.highToLow == Map (1 -> objClothes,2 -> objTv))
  }
  test ("High to low By Ratings: ") {
    assert (search.highToLowRatings == Map (1 -> objClothes,2 -> objTv))
  }
  test ("Low to High By Ratings: ") {
    assert (search.lowToHighRating == Map (2 -> objTv, 1 -> objClothes))
  }
  test ("Search By Price: ") {
    assert (search.searchItemPrice == Map ( 2 -> objTv))
  }
}
