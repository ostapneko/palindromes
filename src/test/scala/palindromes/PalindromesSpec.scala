package palindromes

import org.scalatest.FreeSpecLike

class PalindromesSpec extends FreeSpecLike {
  val palindromes = Seq(
    Palindrome("a", 0, 1),
    Palindrome("b", 1, 1),
    Palindrome("b", 2, 1),
    Palindrome("a", 3, 1),
    Palindrome("b", 4, 1),
    Palindrome("abba", 0, 4),
    Palindrome("bb", 1, 2),
    Palindrome("bab", 2, 3)
  )

  "Palindromes" - {
    "allPalindromes should return all palindromes in a given string" in {
      assertResult(palindromes.toSet)(Palindromes.allPalindromes("abbab").toSet)
    }

    "biggestPalindromes should return the n longest palindromes in a list" in {
      assertResult(Seq(
        Palindrome("abba", 0, 4),
        Palindrome("bab", 2, 3),
        Palindrome("bb", 1, 2)
      ))(Palindromes.biggestPalindromes(palindromes.toIterator, 3))
    }
  }
}
