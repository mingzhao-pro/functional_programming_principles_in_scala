
def factorial(n: Int): Int = {
  def loop(a: Int, total: Int): Int = {
    if(a == 0) 0
    else if( a > n) total
    else loop(a + 1, total * a)
  }

  loop(1, 1)
}
factorial(3)


type Set = Int => Boolean

/**
  * Indicates whether a set contains a given element.
  */
def contains(s: Set, elem: Int): Boolean = s(elem)

val bound = 1000

def printSet(s: Set) {
  val xs = for (i <- -bound to bound if contains(s, i)) yield i
  println(xs.mkString("{", ",", "}"))
}


//type Set = Int => Boolean
//def contains(s: Set, elem: Int): Boolean = s(elem)
//val bound = 1000

def forall(s: Set, p: Int => Boolean): Boolean = {
  def iter(a: Int): Boolean = {
    if (a == bound) {
      if (contains(s, a)) p(a)
      else true
    } else if (a < bound && contains(s, a)) {
      if(p(a)) iter(a + 1)
      else false
    } else iter(a + 1)
  }
  iter(-bound)
}

forall(Set(1, 2, 4), Set(1,2,3))

def singletonSet(elem: Int): Set = Set(elem)

def exists(s: Set, p: Int => Boolean): Boolean = {
  def iter(a: Int): Boolean = {
    if(a == bound) s(a) && forall(singletonSet(a), p)
    else if(a < bound) {
      if(s(a) && forall(singletonSet(a), p))  true
      else iter(a + 1)
    } else iter(a + 1)
  }
  iter(-bound)
}


exists(Set(2,3), Set(1, 3))

def filter(s: Set, p: Int => Boolean): Set = (x: Int) => contains(s, x) && p(x)
val a = filter(Set(1, 2, 8, 100, 3), Set(1, 2, 8))

printSet(a)



def intersect(s: Set, t: Set): Set = (x: Int) => contains(s, x) && contains(t, x)



