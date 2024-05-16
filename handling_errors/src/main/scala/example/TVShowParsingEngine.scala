package example

import example.TVShowParser.TvShow

object TVShowParser {
  case class TvShow(title: String, startDate: Int, endDate: Int)

  val rawShows = List("Breaking Bad (2008-2013)",
      "The Wire (2002-2008)",
      "The Mad Man (2015-2017)")
  
  def parseShow(rawShow: String): TvShow = {
    val indexofopenbracket: Int = rawShow.indexOf("(")
    val indexofdash: Int = rawShow.indexOf("-")
    val indexofclosebracket: Int = rawShow.indexOf(")")
    val title: String = rawShow.substring(0, indexofopenbracket).trim()
    val startDate: Int = rawShow.substring(indexofopenbracket + 1, indexofdash).toInt
    val endDate: Int = rawShow.substring(indexofdash + 1, indexofclosebracket).toInt

    TvShow(title, startDate, endDate)
    
  }

  def parseShows(rawShows: List[String]): List[TvShow] = {
    rawShows.map(rawShow => parseShow(rawShow))
  }

  def SortingTvShow(parsedTvShows: List[TvShow]): List[TvShow] = {
    parsedTvShows.sortBy(show => show.startDate)
  }
}

object Driver extends App {
  // print(TVShowParser.parseShows(TVShowParser.rawShows))
  print(TVShowParser.SortingTvShow(TVShowParser.parseShows(TVShowParser.rawShows)))
}