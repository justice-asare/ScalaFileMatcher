package Exercise_3_Pattern_Matching

import scala.annotation.tailrec

object Warm_up {

  //Q1
  val response: Int = 37;
  val matchedNumber = response match {
    case x if x < 0 => "<0"
    case x if x >= 0 && x <= 18 => "0<=number<=18"
    case x if x >= 19 && x <= 35 => "19<=number<=35"
    case x if x >= 36 && x <= 54 => "36<=number<=54"
    case x if x > 65 => ">65"
    case _ => "Do nothing"
  }

  def numberInRange(respone: Int): String = respone match {
    case x if x < 0 => "<0"
    case x if x >= 0 && x <= 18 => "0<=number<=18"
    case x if x >= 19 && x <= 35 => "19<=number<=35"
    case x if x >= 36 && x <= 54 => "36<=number<=54"
    case x if x > 65 => ">65"
  }

  //Q2
  def matchListType(x: List[Any]): Any = x match {
    case Nil => 0
    case List(_,_,third) => s"The third element is $third"
    case List(first,_*) => s"The first element is $first"
  }

  //Q3
  def lengthOfAgivenDataType(x: Any): Int = x match {
    case x: List[Any] => x.size
    case x: Map[Any, Any] => x.size
    case x: Vector[Any] => x.size
    case _ => -1
  }

  //Q4
  def hasValidParenthesis(s:String): Boolean = {
    @tailrec
    def hasValidParenthesisAcc(s:String, numberOfOpenParens: Int): Boolean = {
      if(s.isEmpty && numberOfOpenParens == 0) true
      else if(s.isEmpty && numberOfOpenParens != 0) false
      else
        if(numberOfOpenParens == 0 && s.head == ')') false
        else {
          if(s.head == '(') hasValidParenthesisAcc(s.tail, numberOfOpenParens + 1)
          else if(s.head == ')') hasValidParenthesisAcc(s.tail, numberOfOpenParens - 1)
          else hasValidParenthesisAcc(s.tail, numberOfOpenParens)
        }
    }
    hasValidParenthesisAcc(s, 0)
  }



  def main(args: Array[String]): Unit = {
//    println(matchedNumber)

//    println(matchListType(List()))

//    println(matchListType(List("Calvin", "Emma", "Ampofo")))

//    println(matchListType(List("Calvin", "Emma", "Ampofo", "Ivan")))

        println(matchListType(List(1,4,5,6)))

    println(lengthOfAgivenDataType(List("Kofi", "Kwadwo")))
    println(lengthOfAgivenDataType(List(1, 4,6 , 7, 64, 5)))
    println(lengthOfAgivenDataType(Vector(1,4,6,4)))
    println(lengthOfAgivenDataType(Map("one"->1, "two"->2, "three"->3)))

  }

}
