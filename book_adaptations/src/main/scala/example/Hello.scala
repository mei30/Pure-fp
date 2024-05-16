package example

import example.Recommendation.bookAdaptations

object Recommendation {
  case class Book(title: String, authors: List[String])
  case class Movie(title: String)

  val books = List(
    Book("FP in scala", List("Chiusano", "Bjarnason")),
    Book("The Hobbit", List("Tolkien"))
  )

  def bookAdaptations(author: String): List[Movie] = {
    if (author == "Tolkien")
      List(Movie("An Unexpected Journey"), Movie("The Desolation of Smaug"))
    else
      List.empty
  }

  def recommendationFeed(books: List[Book]): List[String] = {
    for {
      book <- books
      author <- book.authors
      movie <- bookAdaptations(author)
    } yield s"You may like ${movie.title}, " + s"Because you liked $author's ${book.title}"
  }
}

object Application extends App {
  print(Recommendation.recommendationFeed(Recommendation.books))

}
