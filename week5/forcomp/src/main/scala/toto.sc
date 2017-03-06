import forcomp.Anagrams._

object toto {
  val a = List("aaa", "bbb")

  val so = sentenceOccurrences(a)
  val list = combinations(so)
  lazy val dictionaryByOccurrences: Map[Occurrences, List[Word]] = (dictionary groupBy(w => wordOccurrences(w))) withDefaultValue(Nil)

  val a1 = subtract(so, list(0))
  val a2 = subtract(a1, list(1))

  val occWithWords = for(x <- list if !dictionaryByOccurrences(x).isEmpty) yield (x -> dictionaryByOccurrences(x))
  val occList = for(x <- occWithWords) yield x._1


  def iterate() = {
    def loop(x: Occurrences, n: Int) = {

    }

    for(l <- list) {
      val c = so(0)._1
      val total = so(0)._2

      for(o <- occList) {

      }

    }



  }

//  def loop(current: Occurrences, occToSub: Occurrences, n: Int, result: List[Occurrences]): List[Occurrences] = {
//    dictionaryByOccurrences(current) match {
//      case Nil => loop(list(n+1), so, 0, List())
//      case words => loop(list(n+1), )
//    }
//    subtract(occToSub, current)
//  }

}