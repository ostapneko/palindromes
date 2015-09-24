package palindromes

import scala.util.Random

object Benchmark {
  def main(args: Array[String]) =
    args.headOption.filter(_.forall(_.isDigit)).fold {
      println("Please supply an integer as argument")
      sys.exit(1)
    }{ num =>
      val str = Random.alphanumeric.filter(_.isLetter).map(_.toLower).take(num.toInt).mkString
      val timeStart = System.currentTimeMillis
      val palindromes = PalindromeFinder(str).findLongest(3)
      palindromes.map(_.toString).foreach(println)
      val timeEnd = System.currentTimeMillis
      println(s"This took ${timeEnd - timeStart} ms")
    }
}
