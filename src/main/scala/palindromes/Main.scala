package palindromes
import Palindromes._

object Main {
  def main(args: Array[String]) =
    args.headOption.fold {
      println("Usage: palidromes STRING")
      sys.exit(1)
    }{str =>
      val palindromes = biggestPalindromes(allPalindromes(str), 3)
      palindromes.map(_.toString).foreach(println)
    }
}
