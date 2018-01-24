package bootcamp_fraction

class MyFraction(val numerator: Int, val denominator: Int) {

  if (denominator == 0) throw new IllegalArgumentException

  def add(other: MyFraction): MyFraction = {
    val result0 = numerator * other.denominator
    val result1 = denominator * other.numerator
    val resultDenominator = denominator * other.denominator
    val resultNumerator = result0 + result1
    MyFraction(resultNumerator, resultDenominator)
  }

  def subtract(other: MyFraction): MyFraction = {
    val result0 = numerator * other.numerator
    val result1 = denominator * other.denominator
    val resultNumerator = result0 + result1
    MyFraction(resultNumerator, result1)
  }

  def divide(divisor: MyFraction): MyFraction = {
    val resultNumerator = numerator * divisor.denominator
    val resultDenominator = divisor.numerator * denominator
    MyFraction(resultNumerator, resultDenominator)
  }

  def multiply(other: MyFraction): MyFraction = {
    val resultNumerator = numerator * other.numerator
    val resultDenominator = denominator * other.denominator
    MyFraction(resultNumerator, resultDenominator)
  }

  override def toString: String = s"$numerator/$denominator"

  def toDouble: Double = numerator.toDouble / denominator.toDouble

  def reduced: MyFraction = {
    val gcd = MyFraction.gcd(numerator, denominator)
    MyFraction(numerator/gcd, denominator/gcd)
  }

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

  def apply(decimal: Double): MyFraction = {
    var d = decimal
    var j = 1
    while(!d.isValidInt) {
      j *= 10
      d *= j
    }
    MyFraction(d.toInt, j).reduced
  }

  def gcd(a: Int, b: Int): Int =
    if (b == 0) a
    else gcd(b, a % b)
}