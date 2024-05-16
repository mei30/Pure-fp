package example

object Recommendation {
  case class Book(name: String, authors: List[String])
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
    List.empty
  }
}

object Application extends App {
  print(
    Recommendation.books
      .flatMap(_.authors)
      .flatMap(Recommendation.bookAdaptations)
  )

}
