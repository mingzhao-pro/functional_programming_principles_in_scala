package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
     if(c == 0 || c == r) 1
     else pascal(c, r - 1) + pascal(c - 1, r - 1)
    }
  
  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {

    def loop(count: Int, rest: List[Char]): Int = {

      if(rest.isEmpty || count < 0) count
      else {
        val a = rest.head
        if (a == ')')  loop(count - 1, rest.tail)
        else if (a == '(') loop(count + 1, rest.tail)
        else loop(count, rest.tail)
      }
    }

    loop(0, chars) == 0
  }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = ???

  }
