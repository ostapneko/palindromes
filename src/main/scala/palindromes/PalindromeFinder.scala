package palindromes

import scala.annotation.tailrec

case class Palindrome(text: String, startIndex: Int, length: Int) {
  override def toString = s"Text: $text, Index: $startIndex, Length: $length"
}

case class PalindromeFinder(str: String) {
  require(str.nonEmpty)
  /**
   * Finds the longest palindrome p2 centered on a particular palindrome p1
   * @param startIndex The starting position of p1
   * @param endIndex The end position of p1
   * @return The longest palindrome centered on p1
   */
  @tailrec
  final def longestAround(startIndex: Int, endIndex: Int): Palindrome = {
    if (startIndex <= 0 || endIndex >= str.length - 1) {
      palindromeBetween(startIndex, endIndex)
    } else {
      val leftChar = str.charAt(startIndex - 1)
      val rightChar = str.charAt(endIndex + 1)
      if (leftChar == rightChar)
        longestAround(startIndex - 1, endIndex + 1)
      else
        palindromeBetween(startIndex, endIndex)
    }
  }

  def doubleLetterIndices: List[Int] = {
    val firstLetter = str.head
    val (_, _, doubleIndices) = str.drop(1).foldLeft((firstLetter, 1, List[Int]())) { case ((prevLetter, currentIndex, doubles), c) =>
      val newDoubles = if (c == prevLetter) (currentIndex - 1) :: doubles else  doubles
      (c, currentIndex + 1, newDoubles)
    }
    doubleIndices.reverse
  }

  /**
   * Returns the list of the longest palindroms, unique in the sense that none share the same
   * center characters
   * @param n The length of the result
   */
  def findLongest(n: Int): Seq[Palindrome] = {
    val odd = Range(0, str.length - 1).map(i => longestAround(i, i))
    val even = doubleLetterIndices.map(i => longestAround(i, i + 1))
    (odd ++ even).sortBy(- _.length).take(3)
  }

  private def palindromeBetween(startIndex: Int, endIndex: Int): Palindrome = {
    val text =  str.slice(startIndex, endIndex + 1)
    Palindrome(text, startIndex, text.length)
  }
}
