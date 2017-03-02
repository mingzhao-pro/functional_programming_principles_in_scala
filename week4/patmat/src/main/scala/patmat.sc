import patmat.Huffman._

object toto {
  val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)


  codeBits(convert(t2))('d')
}


































