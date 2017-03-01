

object toto {

  abstract class CodeTree
  case class Fork(left: CodeTree, right: CodeTree, chars: List[Char], weight: Int) extends CodeTree
  case class Leaf(char: Char, weight: Int) extends CodeTree

  def weight(tree: CodeTree): Int = tree match {
    case Leaf(_, weight) => weight
    case Fork(_, _, _, weight) => weight
  }

  def chars(tree: CodeTree): List[Char] = tree match {
    case Leaf(char, _) => List(char)
    case Fork(_, _, chars, _) => chars
  }

  def makeCodeTree(left: CodeTree, right: CodeTree) =
    Fork(left, right, chars(left) ::: chars(right), weight(left) + weight(right))

  def singleton(trees: List[CodeTree]): Boolean =
    trees.size == 1

  def combine(trees: List[CodeTree]): List[CodeTree] = {
    def loop(fork: Fork, list: List[CodeTree]): List[CodeTree] = {
      if(list.isEmpty) List(fork)
      else {
        list.head match {
          case Fork(_, _, _, weight) => if (fork.weight <= weight) fork :: list
                                        else (list.head :: loop(fork, list.tail))
          case Leaf(_, weight) => if (fork.weight <= weight) fork :: list
                                  else (list.head :: loop(fork, list.tail))
        }
      }
    }

    if(trees.size <= 2) trees
    else {
      val node1 = trees.head
      val node2 = trees.tail.head
      val fork = makeCodeTree(node1, node2)
      loop(fork, trees.tail.tail)
    }
  }




  combine(List(Leaf('a', 2), Leaf('b', 3), Leaf('c', 8), Leaf('d', 10)))


  def times(chars: List[Char]): List[(Char, Int)] = {
    def loop(list: List[Char], result: List[(Char, Int)]): List[(Char, Int)] = {
      if(list.isEmpty) result
      else {
        val a = list.head
        val newList = list.filter(x => x != a)
        loop(newList, (a, list.size - newList.size) :: result)
      }
    }
    loop(chars, List())
  }

  def until(singleton: List[CodeTree] => Boolean, combine: List[CodeTree] => List[CodeTree])(treeNodes: List[CodeTree]): List[CodeTree] = {
    if(singleton(treeNodes)) treeNodes
    else until(singleton, combine)(combine(treeNodes))
  }



  def makeOrderedLeafList(freqs: List[(Char, Int)]): List[Leaf] = {

    def loop(remainder: List[(Char, Int)], result: List[Leaf]): List[Leaf] = {
      if(remainder.isEmpty) result
      else {
        val partialList = loop2(remainder.head, result)
        loop(remainder.tail, partialList)
      }
    }

    def loop2(leaf: (Char, Int), result: List[Leaf]): List[Leaf] = {
      if(result.isEmpty) List(Leaf(leaf._1, leaf._2))
      else if(leaf._2 <= result.head.weight) Leaf(leaf._1, leaf._2) :: result
      else result.head :: loop2(leaf, result.tail)
    }

    loop(freqs, List())
  }

  val list = List('a','b', 'c', 'd', 'e', 'e', 'd', 'a', 'd', 'a')
  val k = times(list)

  makeOrderedLeafList(k)
//  createCodeTree().toString()

  val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
  val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
  until(singleton, combine)(List(t2)).toString()
}


































