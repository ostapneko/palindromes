# Overview
This is an exercise that consists of finding the 3 longest palindromes in a given string. The results need to be such that no two results share the same central letter or pair of letters.
For example, the longest palindromes in the string `sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop` are, in order:

1. hijkllkjih
1. defggfed
1. abccba

#Usage

## Running

`sbt "run STRING"`. You should see an output such as

```
    Text: hijkllkjih, Index: 23, Length: 10
    Text: defggfed, Index: 13, Length: 8
    Text: abccba, Index: 5 Length: 6
```

for the example above

## Testing

`sbt test`

## Benchmarking

`sbt "benchmark LENGTH` where LENGTH is the length of a randomly generating string. You should see an output such as:

```
    Running palindromes.Benchmark 10000
    Text: arsesra, Index: 4788, Length: 7
    Text: fmwbwmf, Index: 8086, Length: 7
    Text: kahhak, Index: 3519, Length: 6
    This took 54 ms
```

# Note on the implementation

This uses a fairly simple algorithm, where:

1. We iterate over each character or each double consecutive letter
1. For each of those, we check the characters left and right
1. If they match, we continue expanding
1. If they don't match, we found the longest palindrome centered around or focal point
1. We then sort all those palindromes

While quite naive (there are apparently some super fancy algorithms on the web), I think that this implementation strikes a good trade-off between clarity and performance. For example, finding the longest palindromes in a string of 1 million characters takes well below 1 second, which should be practical for most purposes.
