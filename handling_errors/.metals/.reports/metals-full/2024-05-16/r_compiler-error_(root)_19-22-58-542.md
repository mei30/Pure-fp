file://<WORKSPACE>/src/main/scala/example/TVShowParsingEngine.scala
### java.lang.IndexOutOfBoundsException: -1 is out of bounds (min 0, max 2)

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 2.13.12
Classpath:
<WORKSPACE>/.bloop/root/bloop-bsp-clients-classes/classes-Metals-q_cra2MBSNyt3dbAa3aD2w== [exists ], <HOME>/.cache/bloop/semanticdb/com.sourcegraph.semanticdb-javac.0.9.9/semanticdb-javac-0.9.9.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12.jar [exists ]
Options:
-Yrangepos -Xplugin-require:semanticdb


action parameters:
offset: 412
uri: file://<WORKSPACE>/src/main/scala/example/TVShowParsingEngine.scala
text:
```scala
package example

object TVShowParser {
  case class TvShow(title: String, startDate: Int, endDate: Int)

  val rawShows = List("Breaking Bad (2008-2013)",
      "The Wire (2002-2008)",
      "The Mad Man (2015-2017)")
  
  def parseShow(rawShow: String): List[TvShow] = {
    // acquire index of (
    
    // acquire index of -
    // acquire index of )
    List.empty
  }

  def parseShows(rawShow: List[String@@])

  def SortingTvShow(parsedTvShows: List[TvShow]): List[TvShow] = {
    parsedTvShows.sortBy(show => show.startDate)
  }
}

object Driver extends App {
}
```



#### Error stacktrace:

```
scala.collection.mutable.ArrayBuffer.apply(ArrayBuffer.scala:106)
	scala.reflect.internal.Types$Type.findMemberInternal$1(Types.scala:1030)
	scala.reflect.internal.Types$Type.findMember(Types.scala:1035)
	scala.reflect.internal.Types$Type.memberBasedOnName(Types.scala:661)
	scala.reflect.internal.Types$Type.member(Types.scala:625)
	scala.tools.nsc.typechecker.Contexts$SymbolLookup.apply(Contexts.scala:1435)
	scala.tools.nsc.typechecker.Contexts$Context.lookupSymbol(Contexts.scala:1286)
	scala.tools.nsc.typechecker.Typers$Typer.typedIdent$2(Typers.scala:5572)
	scala.tools.nsc.typechecker.Typers$Typer.typedIdentOrWildcard$1(Typers.scala:5631)
	scala.tools.nsc.typechecker.Typers$Typer.typed1(Typers.scala:6095)
	scala.tools.nsc.typechecker.Typers$Typer.typed(Typers.scala:6153)
	scala.tools.nsc.typechecker.Typers$Typer.typedType(Typers.scala:6337)
	scala.tools.nsc.typechecker.Typers$Typer.typedType(Typers.scala:6340)
	scala.tools.nsc.typechecker.Namers$Namer.valDefSig(Namers.scala:1790)
	scala.tools.nsc.typechecker.Namers$Namer.memberSig(Namers.scala:1976)
	scala.tools.nsc.typechecker.Namers$Namer.typeSig(Namers.scala:1926)
	scala.tools.nsc.typechecker.Namers$Namer$MonoTypeCompleter.completeImpl(Namers.scala:874)
	scala.tools.nsc.typechecker.Namers$LockingTypeCompleter.complete(Namers.scala:2123)
	scala.tools.nsc.typechecker.Namers$LockingTypeCompleter.complete$(Namers.scala:2121)
	scala.tools.nsc.typechecker.Namers$TypeCompleterBase.complete(Namers.scala:2116)
	scala.reflect.internal.Symbols$Symbol.completeInfo(Symbols.scala:1565)
	scala.reflect.internal.Symbols$Symbol.info(Symbols.scala:1537)
	scala.tools.nsc.typechecker.Namers$DependentTypeChecker.$anonfun$check$2(Namers.scala:2201)
	scala.tools.nsc.typechecker.Namers$DependentTypeChecker.$anonfun$check$1(Namers.scala:2200)
	scala.tools.nsc.typechecker.Namers$DependentTypeChecker.check(Namers.scala:2199)
	scala.tools.nsc.typechecker.Namers$Namer.methodSig(Namers.scala:1482)
	scala.tools.nsc.typechecker.Namers$Namer.memberSig(Namers.scala:1975)
	scala.tools.nsc.typechecker.Namers$Namer.typeSig(Namers.scala:1926)
	scala.tools.nsc.typechecker.Namers$Namer$MonoTypeCompleter.completeImpl(Namers.scala:874)
	scala.tools.nsc.typechecker.Namers$LockingTypeCompleter.complete(Namers.scala:2123)
	scala.tools.nsc.typechecker.Namers$LockingTypeCompleter.complete$(Namers.scala:2121)
	scala.tools.nsc.typechecker.Namers$TypeCompleterBase.complete(Namers.scala:2116)
	scala.reflect.internal.Symbols$Symbol.completeInfo(Symbols.scala:1565)
	scala.reflect.internal.Symbols$Symbol.info(Symbols.scala:1537)
	scala.reflect.internal.Symbols$Symbol.initialize(Symbols.scala:1726)
	scala.tools.nsc.typechecker.Typers$Typer.typed1(Typers.scala:5734)
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