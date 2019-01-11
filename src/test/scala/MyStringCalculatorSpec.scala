import org.scalatest._
import example._
class MyStringCalculatorSpec extends WordSpec with MustMatchers {

  "MyStringCalculator" should {
    "return 0 for 0" in {
      MyStringCalculator.add("") mustEqual 0
    }

    "return 1 for 1" in {
      MyStringCalculator.add("1") mustEqual 1
    }

    "return 3 for 1,2" in {
      MyStringCalculator.add("1,2") mustEqual 3
    }

    "return 12 for 1,2,3,1,2,3" in {
      MyStringCalculator.add("1,2,3,1,2,3") mustEqual 12
    }

    "return 6 for 1\n2,3" in {
      MyStringCalculator.add("1\n2,3") mustEqual 6
    }

    "return 6 for //;\n1;2;3" in {
      MyStringCalculator.add("//;\n1;2;3") mustEqual 6
    }

    "throw an exception when given -1" in {

      an [RuntimeException] must be thrownBy MyStringCalculator.add("-1")
    }
  }

}