package Rank

object Ranking {
  def score(word: String): Int = {
    word.replaceAll("a", "").length()
  }

  def bonus(word: String): Int = {
    if (word.contains('c')) return 5 else 0
  }

  def penalty(word: String): Int = {
    if (word.contains('s')) return -7 else 0
  }

  def negative_score(word: String): Int = -score(word)

  def rank_words(score: String => Int, words: List[String]): List[String] = {
    words.sortBy(score)
  }
  
  def hightScoringWord(score: String => Int): Int => List[String] => List[String] = {
    higherThan => words => words.filter(word => score(word) > higherThan)
  }

  def cumulativeScore(score: String => Int, words: List[String]): Int = {
    words.map(word => score(word)).foldLeft(0)((total, wordScore) => total + wordScore)
  }
}

object Application extends App {
  println(Ranking.score("hello world"))
}