import objsets.{Empty, Tweet}

object toto {
  val set1 = new Empty
  val set2 = set1.incl(new Tweet("a", "a body", 321))
  val set3 = set2.incl(new Tweet("b", "b body", 205))


  
  set2.filter(x => x.retweets > 205).union(set3.filter(x => x.retweets > 205)).foreach(println _)

  val c = new Tweet("c", "c body", 7)
  val d = new Tweet("d", "d body", 9)
  val set4c = set3.incl(c)
  val set4d = set3.incl(d)
  val set5 = set4c.incl(d)

  val filter2 = set2.filter(x => x.retweets > 100).union(set3.filter(x => x.retweets > 80))
  filter2.foreach(println _)

  val filter1 = set5.filter(x => x.text.contains("a"))
  filter1.foreach(println _)

  val union1 = set2.union(set4c)
  union1.foreach(println _)

  val filter3 = set5.descendingByRetweet.foreach(println _)

  set5.mostRetweeted
}
