package bootcamp_fraction

class MyFraction(val numerator: Int, val denominator: Int) {

  def add(other: MyFraction): MyFraction = ???

  def subtract(other: MyFraction): MyFraction = ???

  def divide(divisor: MyFraction): MyFraction = ???

  def multiply(other: MyFraction): MyFraction = ???

  override def toString: String = ???

  def toDouble: Double = ???

}

object MyFraction {

  def apply(numerator: Int, denominator: Int): MyFraction = new MyFraction(numerator, denominator)
  def apply(integer: Int): MyFraction = new MyFraction(integer, 1)
  def apply(): MyFraction = new MyFraction(1, 1)

}