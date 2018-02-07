import edu.knoldus.AccountServices
import edu.knoldus.database.Registration
import org.scalatest.FunSuite

class TestingWithFunSuite extends FunSuite {

  val register: List[Registration] = List(
    Registration ("Nitin", "Arora", 23, "Male", 987898, "1234"),
    Registration ("Nitish", "Mishra", 23, "Male", 9877, "4567"),
    Registration ("Dipankar", "Ranswal", 24, "Male", 3223, "88998")
  )
  val accountService = new AccountServices
  val existingUser = Registration ("Nitin", "Arora", 23, "Male", 987898, "1234")
  val newUser = Registration ("Nikhil", "Arora", 23, "Male", 987892, "1234")

  test("Login Successful") {
    assert(accountService.authenticateUser(existingUser.mobileNumber,existingUser.password).getOrElse("Nothing") == existingUser)
  }
  test("UnSuccessful") {
    assert (accountService.authenticateUser (367673, "2233").getOrElse ("Nothing") == "Nothing")
  }

    test("SuccessFull") {
      assert(accountService.getRegisteredUsers == List[Registration](
        Registration ("Nitin", "Arora", 23, "Male", 987898, "1234"),
        Registration ("Nitish", "Mishra", 23, "Male", 9877, "4567"),
        Registration ("Dipankar", "Ranswal", 24, "Male", 3223, "88998")))
    }
  }

