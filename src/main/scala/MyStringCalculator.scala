package example

import scala.util.matching.Regex

object MyStringCalculator{

  def add(numbers: String): Int = {
    if (numbers.isEmpty) {
      0
    } else if (numbers.startsWith("//")) {
      val regex: Regex = raw"\/\/(.+)\n(.*)".r
      numbers match {
        case regex(token, numbers) => accumulate(numbers, token)
      }
    } else {
      val newNumbers = numbers.replace("\n", ",")
      accumulate(newNumbers, ",")
    }
  }

  private def accumulate(numbers: String, token: String): Int = {
    numbers.split(token)
      .map(_.toInt)
      .map( number =>
        if (number < 0) {
          throw new RuntimeException("")
        } else {
          number
        }
      ).sum
  }
}
