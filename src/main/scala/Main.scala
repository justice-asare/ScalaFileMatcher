import scala.annotation.tailrec

object Main {
  def main(args: Array[String]): Unit = {
    println("Hello World")
//    println(Age.arr(0))
    println(factorial(1))
    println(factorial(2))
    println(factorial(3))
    println(factorial(24))
  }

  def factorial(n: Int): Int = {
    @tailrec
    def factorialTailRec(x: Int, acc: Int): Int = {
      if(x == 0) acc
      else factorialTailRec(x - 1, x * acc)
    }
    factorialTailRec(n, 1)
  }

  def fibonacci(n: Int): Int = {
    def fibonacciTailRec(first: Int, last: Int, acc: Int): Int = {
      if(first >= n)
    }
  }
}


object Age {
  val arr = new Array[Int](2)
  arr(0) = 19;

}
