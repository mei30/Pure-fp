error id: file://<WORKSPACE>/src/main/scala/example/TVShowParsingEngine.scala:[301..302) in Input.VirtualFile("file://<WORKSPACE>/src/main/scala/example/TVShowParsingEngine.scala", "package example

object TVShowParser {
  case class TvShow(title: String, startDate: Int, endDate: Int)

  val rawShows = List("Breaking Bad (2008-2013)",
      "The Wire (2002-2008)",
      "The Mad Man (2015-2017)")
  
  def parseShows(rawShows: String): List[TvShow] = {
    List.empty
  }

  def 
}

object Driver extends App {
}")
file://<WORKSPACE>/src/main/scala/example/TVShowParsingEngine.scala
file://<WORKSPACE>/src/main/scala/example/TVShowParsingEngine.scala:15: error: expected identifier; obtained rbrace
}
^
#### Short summary: 

expected identifier; obtained rbrace