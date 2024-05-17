package example

object TVShowParser {
  case class TvShow(title: String, startDate: Int, endDate: Int)

  val rawShows = List(
    "Breaking Bad (2008-2013)",
    "The Wire 2002 2008",
    "The Mad Man (2015-2017)"
  )

  def addOrResign(parsedShows: Option[List[TvShow]], newParsedShows: Option[TvShow]): Option[List[TvShow]] = {
    for {
      shows <- parsedShows
      parsedShow <- newParsedShows
    } yield shows.appended(parsedShow)
  }

  def extractName(rawShow: String): Option[String] = {
    val bracketOpen = rawShow.indexOf('(')
    if (bracketOpen > 0)
      Some(rawShow.substring(0, bracketOpen).trim)
    else None
  }

  def extractSingleYear(rawShow: String): Option[Int] = {
    val dash = rawShow.indexOf('-')
    val bracketOpen = rawShow.indexOf('(')
    val bracketClose = rawShow.indexOf(')')
    for {
      yearStr <-
        if (dash == -1 && bracketOpen != -1 && bracketClose > bracketOpen + 1)
          Some(rawShow.substring(bracketOpen + 1, bracketClose))
        else None
      year <- yearStr.toIntOption
    } yield year
  }

  def extractYearStart(rawShow: String): Option[Int] = {
    val bracketOpen = rawShow.indexOf('(')
    val dash = rawShow.indexOf('-')
    for {
      yearStr <-
        if (bracketOpen != -1 && dash > bracketOpen + 1)
          Some(rawShow.substring(bracketOpen + 1, dash))
        else None
      year <- yearStr.toIntOption
    } yield year
  }

  def extractYearEnd(rawShow: String): Option[Int] = {
    val dash = rawShow.indexOf('-')
    val bracketClose = rawShow.indexOf(')')
    for {
      yearStr <-
        if (dash != -1 && bracketClose > dash + 1)
          Some(rawShow.substring(dash + 1, bracketClose))
        else None
      year <- yearStr.toIntOption
    } yield year
  }

  def parseShow(rawShow: String): Option[TvShow] = {
    for {
      name <- extractName(rawShow)
      yearStart <- extractYearStart(rawShow).orElse(extractSingleYear(rawShow))
      yearEnd <- extractYearEnd(rawShow).orElse(extractSingleYear(rawShow))
    } yield TvShow(name, yearStart, yearEnd)
  }

  // Best effort strategy of error-handling
  def parseShows(rawShows: List[String]): List[TvShow] = {
    // rawShows.map(parseShow).map(_.toList).flatten
    rawShows.flatMap(parseShow)
  }

  // All-or-nothing strategy of error-handling
  def parseShows2(rawShows: List[String]): Option[List[TvShow]] = {
    // rawShows.map(parseShow).map(_.toList).flatten
    val initialResult: Option[List[TvShow]] = Some(List.empty)

    rawShows.map(parseShow).foldLeft(initialResult)(addOrResign)
  }

  def SortingTvShow(parsedTvShows: List[TvShow]): List[TvShow] = {
    parsedTvShows.sortBy(show => show.startDate)
  }
}

object Driver extends App {
  print(TVShowParser.parseShows(TVShowParser.rawShows))
}
