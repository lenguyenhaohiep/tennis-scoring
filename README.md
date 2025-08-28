# Tennis scoring
## How to run
### with gradle
Run main
`
./gradlew run
`

Example run:
```
============
ABABAA
Player A: 15 / Player B : 0
Player A: 15 / Player B : 15
Player A: 30 / Player B : 15
Player A: 30 / Player B : 30
Player A: 40 / Player B : 30
Player A wins
============
ABAABBBAABBAABBAABBB
Player A: 15 / Player B : 0
Player A: 15 / Player B : 15
Player A: 30 / Player B : 15
Player A: 40 / Player B : 15
Player A: 40 / Player B : 30
Deuce
Advantage-B
Deuce
Advantage-A
Deuce
Advantage-B
Deuce
Advantage-A
Deuce
Advantage-B
Deuce
Advantage-A
Deuce
Advantage-B
Player B wins
============
AAABBBAB
Player A: 15 / Player B : 0
Player A: 30 / Player B : 0
Player A: 40 / Player B : 0
Player A: 40 / Player B : 15
Player A: 40 / Player B : 30
Deuce
Advantage-A
Deuce
Match doesn't end
```

Run test
`
./gradlew test
`

```
> Task :test
SUCCESS (35 tests, 35 successes, 0 failures, 0 skipped)
>
```

### without gradle
Run main

```
javac -d out src/main/java/com/kata/Solution.java && java -cp out com.kata.Solution
```

Run test
```
javac -d out -cp "libs/*" src/main/java/com/kata/Solution.java src/test/java/com/kata/SolutionTest.java && java -jar libs/junit-platform-console-standalone-1.13.0.jar --class-path out --select-class com.kata.SolutionTest

```