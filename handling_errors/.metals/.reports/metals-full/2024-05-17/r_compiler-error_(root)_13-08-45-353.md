file://<WORKSPACE>/src/main/scala/example/TVShowParsingEngine.scala
### java.lang.IndexOutOfBoundsException: -1 is out of bounds (min 0, max 2)

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 2.13.12
Classpath:
<WORKSPACE>/.bloop/root/bloop-bsp-clients-classes/classes-Metals-FICpSu9cThCvD-xzQ5cTkw== [exists ], <HOME>/.cache/bloop/semanticdb/com.sourcegraph.semanticdb-javac.0.9.9/semanticdb-javac-0.9.9.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12.jar [exists ]
Options:
-Yrangepos -Xplugin-require:semanticdb


action parameters:
offset: 303
uri: file://<WORKSPACE>/src/main/scala/example/TVShowParsingEngine.scala
text:
```scala
package example

object TVShowParser {
  case class TvShow(title: String, startDate: Int, endDate: Int)

  val rawShows = List(
    "Breaking Bad (2008-2013)",
    "The Wire 2002 2008",
    "The Mad Man (2015-2017)"
  )

  def addOrResign(parsedShows: Option[List[TvShow]], newParsedShows: Either[String@@TvShow]): Either[String, List[TvShow]] = {
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
    rawShows.foldLeft(initialResult)(addOrResign)
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

```



#### Error stacktrace:

```
scala.collection.mutable.ArrayBuffer.apply(ArrayBuffer.scala:106)
	scala.reflect.internal.Types$Type.findMemberInternal$1(Types.scala:1030)
	scala.reflect.internal.Types$Type.findMember(Types.scala:1035)
	scala.reflect.internal.Types$Type.memberBasedOnName(Types.scala:661)
	scala.reflect.internal.Types$Type.nonPrivateMember(Types.scala:632)
	scala.tools.nsc.typechecker.Infer$Inferencer.followApply(Infer.scala:661)
	scala.tools.nsc.typechecker.Infer$Inferencer.isApplicableBasedOnArity(Infer.scala:626)
	scala.tools.nsc.typechecker.Typers$Typer.isLooseFit$1(Typers.scala:3571)
	scala.tools.nsc.typechecker.Typers$Typer.$anonfun$doTypedApply$5(Typers.scala:3572)
	scala.tools.nsc.typechecker.Typers$Typer.$anonfun$doTypedApply$5$adapted(Typers.scala:3572)
	scala.reflect.internal.Symbols$Symbol.filter(Symbols.scala:2027)
	scala.tools.nsc.typechecker.Typers$Typer.preSelectOverloaded$1(Typers.scala:3572)
	scala.tools.nsc.typechecker.Typers$Typer.doTypedApply(Typers.scala:3582)
	scala.tools.nsc.typechecker.Typers$Typer.$anonfun$typed1$28(Typers.scala:5093)
	scala.tools.nsc.typechecker.Typers$Typer.silent(Typers.scala:698)
	scala.tools.nsc.typechecker.Typers$Typer.tryTypedApply$1(Typers.scala:5093)
	scala.tools.nsc.typechecker.Typers$Typer.normalTypedApply$1(Typers.scala:5181)
	scala.tools.nsc.typechecker.Typers$Typer.typedApply$1(Typers.scala:5194)
	scala.tools.nsc.typechecker.Typers$Typer.typed1(Typers.scala:6097)
	scala.tools.nsc.typechecker.Typers$Typer.typed(Typers.scala:6153)
	scala.tools.nsc.typechecker.Typers$Typer.typedIf$1(Typers.scala:6231)
	scala.tools.nsc.typechecker.Typers$Typer.typedOutsidePatternMode$1(Typers.scala:6073)
	scala.tools.nsc.typechecker.Typers$Typer.typed1(Typers.scala:6107)
	scala.tools.nsc.typechecker.Typers$Typer.typed(Typers.scala:6153)
	scala.tools.nsc.typechecker.Typers$Typer.typedBlock(Typers.scala:2598)
	scala.tools.nsc.typechecker.Typers$Typer.typedOutsidePatternMode$1(Typers.scala:6071)
	scala.tools.nsc.typechecker.Typers$Typer.typed1(Typers.scala:6107)
	scala.tools.nsc.typechecker.Typers$Typer.typed(Typers.scala:6153)
	scala.tools.nsc.typechecker.Typers$Typer.typedDefDef(Typers.scala:6417)
	scala.tools.nsc.typechecker.Typers$Typer.typed1(Typers.scala:6059)
	scala.tools.nsc.typechecker.Typers$Typer.typed(Typers.scala:6153)
	scala.tools.nsc.typechecker.Typers$Typer.typedStat$1(Typers.scala:6231)
	scala.tools.nsc.typechecker.Typers$Typer.$anonfun$typedStats$8(Typers.scala:3470)
	scala.tools.nsc.typechecker.Typers$Typer.typedStats(Typers.scala:3470)
	scala.tools.nsc.typechecker.Typers$Typer.typedTemplate(Typers.scala:2089)
	scala.tools.nsc.typechecker.Typers$Typer.typedModuleDef(Typers.scala:1965)
	scala.tools.nsc.typechecker.Typers$Typer.typed1(Typers.scala:6061)
	scala.tools.nsc.typechecker.Typers$Typer.typed(Typers.scala:6153)
	scala.tools.nsc.typechecker.Typers$Typer.typedStat$1(Typers.scala:6231)
	scala.tools.nsc.typechecker.Typers$Typer.$anonfun$typedStats$8(Typers.scala:3470)
	scala.tools.nsc.typechecker.Typers$Typer.typedStats(Typers.scala:3470)
	scala.tools.nsc.typechecker.Typers$Typer.typedPackageDef$1(Typers.scala:5743)
	scala.tools.nsc.typechecker.Typers$Typer.typed1(Typers.scala:6063)
	scala.tools.nsc.typechecker.Typers$Typer.typed(Typers.scala:6153)
	scala.tools.nsc.typechecker.Analyzer$typerFactory$TyperPhase.apply(Analyzer.scala:124)
	scala.tools.nsc.Global$GlobalPhase.applyPhase(Global.scala:480)
	scala.tools.nsc.interactive.Global$TyperRun.applyPhase(Global.scala:1370)
	scala.tools.nsc.interactive.Global$TyperRun.typeCheck(Global.scala:1363)
	scala.tools.nsc.interactive.Global.typeCheck(Global.scala:680)
	scala.meta.internal.pc.PcCollector.<init>(PcCollector.scala:29)
	scala.meta.internal.pc.PcDocumentHighlightProvider.<init>(PcDocumentHighlightProvider.scala:12)
	scala.meta.internal.pc.ScalaPresentationCompiler.$anonfun$documentHighlight$1(ScalaPresentationCompiler.scala:384)
```
#### Short summary: 

java.lang.IndexOutOfBoundsException: -1 is out of bounds (min 0, max 2)