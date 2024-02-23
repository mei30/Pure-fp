object RankedWord {
  def rankedWord(wordScore: String => Integer, words: List[String]): List[String] = {
    words.sortBy(wordScore)
}

object ch02_ShoppingCartDiscountsScala extends App {

  val words = List("Apple", "Orange", "Melon");

  print(RankedWord.rankedWord())
}