package palindromes

object Main {
  def main(args: Array[String]) =
    args.headOption.fold {
      println("Please supply a string as argument")
      sys.exit(1)
    }{str =>
      val palindromes = PalindromeFinder(str).findLongest(3)
      palindromes.map(_.toString).foreach(println)
    }
}
