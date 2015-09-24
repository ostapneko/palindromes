package palindromes

import org.scalatest.FreeSpecLike

class PalindromesSpec extends FreeSpecLike {
  "Palindromes" - {
    "longestAround returns the longest string centered on a particular palindrome" in {
      assertResult(
        Palindrome("aba", 1, 3)
      )(PalindromeFinder("caba").longestAround(2,2))
    }

    "doubleLetterIndices returns the list of indices for the first letter of all doubles" in {
      assertResult(List(2, 3, 6))(PalindromeFinder("abcccdee").doubleLetterIndices)
    }

    "findLongest returns the list of the n longest unique palindroms" in {
      assertResult(Seq(
        Palindrome("hijkllkjih", 23, 10),
        Palindrome("defggfed", 13, 8),
        Palindrome("abccba", 5, 6)
      ))(PalindromeFinder("sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop").findLongest(3))
    }
  }
}
