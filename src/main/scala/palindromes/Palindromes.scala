package palindromes

case class Palindrome(text: String, startIndex: Int, length: Int) {
  override def toString = s"Text: $text, Index: $startIndex, Length: $length"
}

object Palindromes {

  def allPalindromes(str: String): Iterator[Palindrome] = {
    val indexedChars = str.toCharArray.zip(Stream.from(0))

    for {
      tail <- indexedChars.tails
      subList <- tail.inits
      chars = subList.map(_._1)
      if chars.nonEmpty && chars.sameElements(chars.reverse)
    } yield Palindrome(chars.mkString, subList.head._2, chars.length)
  }

  def biggestPalindromes(palindromes: Iterator[Palindrome], n: Int): Seq[Palindrome] =
    palindromes.toArray.sortBy(- _.length).take(3)
}
