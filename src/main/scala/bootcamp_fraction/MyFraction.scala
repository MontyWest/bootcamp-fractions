package bootcamp_fraction

class MyFraction(val numerator: Int, val denominator: Int) {

  def add(other: MyFraction): MyFraction = ???

  def subtract(other: MyFraction): MyFraction = ???

  def divide(divisor: MyFraction): MyFraction = ???

  def multiply(other: MyFraction): MyFraction = ???

  override def toString: String = s"$numerator/$denominator"

  def toDouble: Double = numerator.toDouble / denominator.toDouble

  def reduced: MyFraction = ???

  def canEqual(other: Any): Boolean = other.isInstanceOf[MyFraction]

  override def equals(other: Any): Boolean = other match {
    case that: MyFraction =>
      (that canEqual this) &&
        numerator == that.numerator &&
        denominator == that.denominator
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(numerator, denominator)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

object MyFraction {

  def apply(numerator: Int, denominator: Int): MyFraction = new MyFraction(numerator, denominator)
  def apply(integer: Int): MyFraction = new MyFraction(integer, 1)
  def apply(): MyFraction = new MyFraction(1, 1)

  def apply(decimal: Double): MyFraction = ???

  def gcd(a: Int, b: Int): Int =
    if (b == 0) a
    else gcd(b, a % b)
}