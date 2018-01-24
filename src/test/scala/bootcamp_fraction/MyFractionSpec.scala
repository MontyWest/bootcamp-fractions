package bootcamp_fraction

import org.scalatest.FlatSpec

class MyFractionSpec extends FlatSpec {

  "MyFraction constructor" should "not accept 0 as denominator" in {
    assertThrows[IllegalArgumentException]{
      new MyFraction(1, 0)
    }
  }

  "apply" should "take in numerator and denominator" in {
    assertResult(new MyFraction(1,2))(MyFraction(1,2))
  }

  it should "not accept 0 as denominator" in {
    assertThrows[IllegalArgumentException]{
      MyFraction(1, 0)
    }
  }

  it should "take in a single integer, return the corresponding whole fraction" in {
    assertResult(new MyFraction(4,1))(MyFraction(4))
  }

  it should "take in no arguments and return fraction 1/1" in {
    assertResult(new MyFraction(1,1))(MyFraction())
  }

  "sum" should "add two fractions together" in {
    assertResult(MyFraction(10,12)){
      MyFraction(2,4).add(MyFraction(1,3))
    }
  }

  "subtract" should "subtract two fractions together" in {
    assertResult(MyFraction(58,30)){
      MyFraction(7,3).subtract(MyFraction(4,10))
    }
  }

  "multiply" should "multiply two fractions together" in {
    assertResult(MyFraction(12,40)){
      MyFraction(3,8).multiply(MyFraction(4,5))
    }
  }

  "divide" should "divide two fractions together" in {
    assertResult(MyFraction(14,20)){
      MyFraction(2,5).divide(MyFraction(4,7))
    }
  }

  "toString" should "format as <numerator>/<denominator>" in {
    assertResult("5/3")(MyFraction(5,3).toString)
  }

  "toDouble" should "return double representation of double" in {
    assertResult(1.625d)(MyFraction(13,8).toDouble)
  }
}
