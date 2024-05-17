package example

object TVShowParser {
  case class TvShow(title: String, startDate: Int, endDate: Int)

  val rawShows = List(
    "Breaking Bad (2008-2013)",
    "The Wire 2002 2008",
    "The Mad Man (2015-2017)"
  )

  def addOrResign(parsedShows: Either[String, List[TvShow]], newParsedShows: Either[String, TvShow]): Either[String, List[TvShow]] = {
    for {
      shows <- parsedShows
      parsedShow <- newParsedShows
    } yield shows.appended(parsedShow)
  }

  def extractName(rawShow: String): Either[String, String] = {
    val bracketOpen = rawShow.indexOf('(')
    if (bracketOpen > 0)
      Right(rawShow.substring(0, bracketOpen).trim)
    else Left(s"Can't extract name from $rawShow")
  }

  def extractSingleYear(rawShow: String): Either[String, Int] = {
    val dash = rawShow.indexOf('-')
    val bracketOpen = rawShow.indexOf('(')
    val bracketClose = rawShow.indexOf(')')
    for {
      yearStr <-
        if (dash == -1 && bracketOpen != -1 && bracketClose > bracketOpen + 1)
          Right(rawShow.substring(bracketOpen + 1, bracketClose))
        else Left(s"Cant extract single year from $rawShow")
      year <- yearStr.toIntOption.toRight(s"Cant parse $yearStr")
    } yield year
  }

  def extractYearStart(rawShow: String): Either[String, Int] = {
    val bracketOpen = rawShow.indexOf('(')
    val dash = rawShow.indexOf('-')

    for {
      yearStr <-
        if (bracketOpen != -1 && dash > bracketOpen + 1)
          Right(rawShow.substring(bracketOpen + 1, dash))
        else Left(s"Cant extract start year from $rawShow")
      year <- yearStr.toIntOption.toRight(s"Cant parse $yearStr")
    } yield year
  }

  def extractYearEnd(rawShow: String): Either[String, Int] = {
    val dash = rawShow.indexOf('-')
    val bracketClose = rawShow.indexOf(')')
    for {
      yearStr <-
        if (dash != -1 && bracketClose > dash + 1)
          Right(rawShow.substring(dash + 1, bracketClose))
        else Left(s"Cant extract year year from $rawShow")
      year <- yearStr.toIntOption.toRight(s"Cant parse $yearStr")
    } yield year
  }

  def parseShow(rawShow: String): Either[String, TvShow] = {
    for {
      name <- extractName(rawShow)
      yearStart <- extractYearStart(rawShow).orElse(extractSingleYear(rawShow))
      yearEnd <- extractYearEnd(rawShow).orElse(extractSingleYear(rawShow))
    } yield TvShow(name, yearStart, yearEnd)
  }

  // Best effort strategy of error-handling
  def parseShows(rawShows: List[String]): Either[String, List[TvShow]] = {
    // rawShows.map(parseShow).map(_.toList).flatten
    val initialResult: Either[String, List[TvShow]] = Right(List.empty)
    rawShows.map(parseShow).foldLeft(initialResult)(addOrResign)
  }

  // All-or-nothing strategy of error-handling
  def parseShows2(rawShows: List[String]): Either[String, List[TvShow]] = {
    // rawShows.map(parseShow).map(_.toList).flatten
    val initialResult: Either[String, List[TvShow]] = Right(List.empty)

    rawShows.map(parseShow).foldLeft(initialResult)(addOrResign)
  }

  def SortingTvShow(parsedTvShows: List[TvShow]): List[TvShow] = {
    parsedTvShows.sortBy(show => show.startDate)
  }
}

object Driver extends App {
  print(TVShowParser.parseShows(TVShowParser.rawShows))
}
