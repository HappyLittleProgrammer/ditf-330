object RTUSet {
  /**
    * We define a set by its characteristic function
    */
  type Set = Int => Boolean

  /**
    * If  a set contains an element.
    */
  def contains(s: Set, elem: Int): Boolean = s(elem)

  /**
    * Singleton set from one element
    */
  def singletonSet(elem: Int): Set = set => set == elem

  /**
    * Union of the two sets
    */
  def union(s: Set, t: Set): Set = (x : Int) => contains(s, x) || contains(t, x)

  /**
    * Intersection of the two sets
    */
  def intersect(s: Set, t: Set): Set = (x : Int) => contains(s, x) && contains(t, x)

  /**
    * Difference of two given sets
    */
  def diff(s: Set, t: Set): Set = (x : Int) => contains(s, x) != contains(t, x)

  /**
    * Filter
    */
  def filter(s: Set, p: Int => Boolean): Set = intersect(s, p)

  /** =========== For brave enough =========== */


  val bound = 1000

  /**
    * if  all bounded integers within s satisfy p
    */
  def forall(s: Set, p: Int => Boolean): Boolean = {
    def iter(a: Int): Boolean = {
      if (a > bound) true
      else if (s(a) && !p(a)) false
      else iter(a + 1)
    }
    iter(-bound)
  }


  def exists(s: Set, p: Int => Boolean): Boolean = !forall(s, x => !p(x))


  def map(s: Set, f: Int => Int): Set = (x: Int) => exists(s, (o => x == f(o)))

  /**
    * Displays the contents of a set
    */
  def toString(s: Set): String = {
    (0 to bound).withFilter(x => s(x)).map(x => { x }).mkString("{", ",", "}")
  }
}
