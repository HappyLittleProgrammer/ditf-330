object NewtonsMethod extends App{
  def sqrt(n: Double) : Double = sqrtIter(1, n)
  def isGoodEnough(x: Double, n: Double) : Boolean = Math.abs(x - n) < 0.001
  def improve(x: Double, n: Double) : Double = (x + n/x) / 2
  def sqrtIter(x: Double, n: Double) : Double = if(isGoodEnough(x, improve(x, n))) return x else sqrtIter(improve(x, n), n)


  println("Test Nr. 1: " + sqrt(81))
  println("Test Nr. 2: " + sqrt(49))
  println("Test Nr. 3: " + sqrt(36))
}
