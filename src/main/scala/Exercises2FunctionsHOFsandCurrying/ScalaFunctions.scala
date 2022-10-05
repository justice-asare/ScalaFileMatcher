package Exercises2FunctionsHOFsandCurrying



class ScalaFunctions {

  //Q1. Write a function value that takes five strings and returns the sum of the length of all
  //of the strings.  Write this function using both long hand syntax (e.g. FunctionX) and
  //short hand. Which do you prefer and why?

  val sumOfStringsUsingLongHand: (String, String, String, String, String) => Int = (a: String, b: String, c: String, d: String, e: String) => a.toInt + b.toInt + c.toInt + d.toInt + e.toInt

  val sumOfStringsUsingShortHand: (String, String, String, String, String) => Int = _.toInt + _.toInt + _.toInt + _.toInt + _.toInt

  // Because the problem is basic, I like to use short hand syntax because it makes the code more brief.



  // Q2. Write a function that takes an int as an argument and returns another function as a result

//  val add: Int => (Int => Int) = (a: Int) => (b: Int) => a + b
  val myDoubler: (Int) => Int = _ * 2
  val doOperation: ((Int => Int), Int) => Int = (f:Int => Int, a: Int) => f(a)

  def multy(x: Int) = (y: Int) => x * y


  /* Q3. Explain (in words) and provide an example implementation (the implementation does
  not need to be meaningful but it must compile) what the following type signature
  says: val function: (String, (Int, (String => Int)) => Int) => (Int => Int) */

  /*Answer:  The return type of this function is another function that takes in an Int and returns an Int.
  The function have two parameters which one is a String and the second is this (String => Int)) => Int) and is another
  function which takes in String to a function Int and return type is Int.
   */


  /* Q4. Convert the following function in to a curried version and provide an example of
   calling both the curried and uncurried version of the function
   val addThreeNumbers(x: Int, y: Int, z: Int) = x + y + z
   */

  val uncurriedAddThreeNumbers: (Int, Int, Int) => Int = (x: Int, y: Int, z: Int) => x + y + z
  val curriedAddThreeNumbers: Int => (Int => Int => Int) = (x: Int) => (y: Int) => (z: Int) => x + y + z


}
