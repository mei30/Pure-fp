package Rank

class RankingWordSpec extends munit.FunSuite {
  test("Ranking words should be sorted correctly") {
    val input = List("ada", "haskell", "scala", "java", "rust")
    val expected = List("haskell", "rust", "scala", "java", "ada")

    val obtained = Ranking.rank_words(Ranking.negative_score,input)
    println(obtained)

    assertEquals(obtained, expected)
  }

  test("Ranking words should be sorted correctly for combination of bonus and scores except a char") {
    val input = List("ada", "haskell", "scala", "java", "rust")
    val expected = List("ada", "java", "rust", "haskell", "scala")

    val obtained = Ranking.rank_words(w => Ranking.score(w) + Ranking.bonus(w), input)
    println(obtained)

    assertEquals(obtained, expected)
  }

  test("Ranking words should be sorted correctly for combination of penalty and scores except a char") {
    val input = List("ada", "haskell", "scala", "java", "rust")
    val expected = List("scala", "rust", "haskell", "ada", "java")

    val obtained = Ranking.rank_words(w => Ranking.score(w) + Ranking.penalty(w), input)

    assertEquals(obtained, expected)
  }

  test("for a given list higher score algorithms should filter items with scoring number more than 3") {
    val input = List("ada", "haskell", "scala", "java", "rust")
    val expected = List("haskell", "rust")

    val algorithm = Ranking.hightScoringWord(w => Ranking.score(w))
    val morethan3 = algorithm(3)
    val obtained = morethan3(input)

    assertEquals(obtained, expected)
  }

  test("for a given list cumulative scores should return correct cumulated score") {
    val input = List("ada", "haskell")
    val expected = 7

    val obtained = Ranking.cumulativeScore(w => Ranking.score(w), input)

    assertEquals(obtained, expected)
  }
}
