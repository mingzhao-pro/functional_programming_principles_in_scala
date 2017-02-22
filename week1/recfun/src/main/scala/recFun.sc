def balance(chars: List[Char]): Boolean = {

  def loop(count: Int, rest: List[Char]): Int = {

    if(rest.isEmpty || count < 0) {
      println(count)
      count
    } else {

      val a = rest.head

      if (a == ')') {
        println(")")
        loop(count - 1, rest.tail)
      }
      else if (a == '(') {
        println("(")
        loop(count + 1, rest.tail)
      }
      else {
        println("a:" + a)
        loop(count, rest.tail)
      }
    }
  }

  loop(0, chars) == 0
}

balance("(if (zero? x) max (/ 1 x))".toList)