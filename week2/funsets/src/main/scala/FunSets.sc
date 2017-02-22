val bound = 5

def toString(s: Set): String = {
  val xs = for (i <- -bound to bound if contains(s, i)) yield i
  xs.mkString("{", ",", "}")
}

type Set = Int => Boolean

def printSet(s: Set) {
  val xs = for (i <- -bound to bound if contains(s, i)) yield i
  xs.mkString("{", ",", "}")
  println(xs)
}

/**
  * Indicates whether a set contains a given element.
  */
def contains(s: Set, elem: Int): Boolean = s(elem)

def singletonSet(elem: Int): Set = Set(elem)

def union(s: Set, t: Set): Set = (x: Int) => contains(s, x) || contains(t, x)


def map(s: Set, f: Int => Int): Set = {

  def loop(a: Int, y: Int, result: Set): Set = {
    if(a > bound) result

    else if(a <= bound && contains(s, a))
      union(result, loop(a + 1, f(a + 1), singletonSet(y)))

    else
      union(result, loop(a + 1, f(a + 1), Set()))
  }

  loop(-bound, f(-bound), Set())
}

printSet(map(Set(1,2,3), x => x + 1))
