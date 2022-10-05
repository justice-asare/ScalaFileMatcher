package Exercises2FunctionsHOFsandCurrying

import org.scalatest.funsuite.AnyFunSuite

class scalaFunctionsTest extends AnyFunSuite {

  val functionTest = new ScalaFunctions


  test("sum of all five strings using long hand syntax") {
    assert(functionTest.sumOfStringsUsingLongHand("5", "3", "2", "4", "1") == 15)
  }

  test("sum of all five strings using short hand syntax") {
    assert(functionTest.sumOfStringsUsingShortHand("5", "3", "2", "4", "16") == 30)
  }

  test("function that takes an int as an argument and returns another function as a result") {
    assert(functionTest.doOperation(functionTest.myDoubler, 9) == 18)
  }

  test("Convert the following function in to a curried version and provide an example of " +
    "calling both the curried and uncurried version of the function") {
    assert(functionTest.curriedAddThreeNumbers(15)(6)(9) == 30)
    assert(functionTest.uncurriedAddThreeNumbers(20, 40, 30) == 90)
  }

}
