file://<WORKSPACE>/src/main/scala/example/RankingWord.scala
### java.lang.IndexOutOfBoundsException: -1 is out of bounds (min 0, max 2)

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 2.13.12
Classpath:
<WORKSPACE>/.bloop/root/bloop-bsp-clients-classes/classes-Metals-_6G4WNtmSbegInopcvC5BA== [exists ], <HOME>/.cache/bloop/semanticdb/com.sourcegraph.semanticdb-javac.0.9.9/semanticdb-javac-0.9.9.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12.jar [exists ]
Options:
-Yrangepos -Xplugin-require:semanticdb


action parameters:
offset: 699
uri: file://<WORKSPACE>/src/main/scala/example/RankingWord.scala
text:
```scala
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
    words.map(w@@)
  }
}

object Application extends App {
  println(Ranking.score("hello world"))
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
	scala.tools.nsc.typechecker.Infer$Inferencer.$anonfun$overloadsToConsiderBySpecificity$4(Infer.scala:1489)
	scala.tools.nsc.typechecker.Infer$Inferencer.scala$tools$nsc$typechecker$Infer$Inferencer$$overloadsToConsiderBySpecificity(Infer.scala:1489)
	scala.tools.nsc.typechecker.Infer$Inferencer$InferMethodAlternativeTwice$1.bestForExpectedType(Infer.scala:1527)
	scala.tools.nsc.typechecker.Infer$Inferencer$InferMethodAlternativeTwice$1.tryOnce(Infer.scala:1542)
	scala.tools.nsc.typechecker.Contexts$Context$TryTwice.$anonfun$apply$1(Contexts.scala:587)
	scala.tools.nsc.typechecker.Contexts$Context$TryTwice.apply(Contexts.scala:655)
	scala.tools.nsc.typechecker.Infer$Inferencer.inferMethodAlternative(Infer.scala:1546)
	scala.tools.nsc.typechecker.Typers$Typer.handleOverloaded$1(Typers.scala:3639)
	scala.tools.nsc.typechecker.Typers$Typer.doTypedApply(Typers.scala:3643)
	scala.tools.nsc.typechecker.Typers$Typer.$anonfun$typed1$28(Typers.scala:5093)
	scala.tools.nsc.typechecker.Typers$Typer.silent(Typers.scala:712)
	scala.tools.nsc.typechecker.Typers$Typer.tryTypedApply$1(Typers.scala:5093)
	scala.tools.nsc.typechecker.Typers$Typer.normalTypedApply$1(Typers.scala:5181)
	scala.tools.nsc.typechecker.Typers$Typer.typedApply$1(Typers.scala:5194)
	scala.tools.nsc.typechecker.Typers$Typer.typed1(Typers.scala:6097)
	scala.tools.nsc.typechecker.Typers$Typer.typed(Typers.scala:6153)
	scala.tools.nsc.typechecker.Typers$Typer.doTypedFunction(Typers.scala:6242)
	scala.tools.nsc.typechecker.Typers$Typer.typedFunction(Typers.scala:3139)
	scala.tools.nsc.typechecker.Typers$Typer.$anonfun$typed1$108(Typers.scala:6035)
	scala.tools.nsc.typechecker.Typers$Typer.typedFunction$1(Typers.scala:497)
	scala.tools.nsc.typechecker.Typers$Typer.typedOutsidePatternMode$1(Typers.scala:6075)
	scala.tools.nsc.typechecker.Typers$Typer.typed1(Typers.scala:6107)
	scala.tools.nsc.typechecker.Typers$Typer.typed(Typers.scala:6153)
	scala.tools.nsc.typechecker.Typers$Typer.typedArg(Typers.scala:3488)
	scala.tools.nsc.typechecker.PatternTypers$PatternTyper.typedArgWithFormal$1(PatternTypers.scala:136)
	scala.tools.nsc.typechecker.PatternTypers$PatternTyper.$anonfun$typedArgsForFormals$4(PatternTypers.scala:150)
	scala.tools.nsc.typechecker.PatternTypers$PatternTyper.typedArgsForFormals(PatternTypers.scala:150)
	scala.tools.nsc.typechecker.PatternTypers$PatternTyper.typedArgsForFormals$(PatternTypers.scala:131)
	scala.tools.nsc.typechecker.Typers$Typer.typedArgsForFormals(Typers.scala:203)
	scala.tools.nsc.typechecker.Typers$Typer.handleMonomorphicCall$1(Typers.scala:3823)
	scala.tools.nsc.typechecker.Typers$Typer.doTypedApply(Typers.scala:3874)
	scala.tools.nsc.typechecker.Typers$Typer.$anonfun$typed1$28(Typers.scala:5093)
	scala.tools.nsc.typechecker.Typers$Typer.silent(Typers.scala:698)
	scala.tools.nsc.typechecker.Typers$Typer.tryTypedApply$1(Typers.scala:5093)
	scala.tools.nsc.typechecker.Typers$Typer.normalTypedApply$1(Typers.scala:5181)
	scala.tools.nsc.typechecker.Typers$Typer.typedApply$1(Typers.scala:5194)
	scala.tools.nsc.typechecker.Typers$Typer.typed1(Typers.scala:6097)
	scala.tools.nsc.typechecker.Typers$Typer.typed(Typers.scala:6153)
	scala.tools.nsc.typechecker.Typers$Typer.doTypedFunction(Typers.scala:6242)
	scala.tools.nsc.typechecker.Typers$Typer.typedFunction(Typers.scala:3139)
	scala.tools.nsc.typechecker.Typers$Typer.$anonfun$typed1$108(Typers.scala:6035)
	scala.tools.nsc.typechecker.Typers$Typer.typedFunction$1(Typers.scala:497)
	scala.tools.nsc.typechecker.Typers$Typer.typedOutsidePatternMode$1(Typers.scala:6075)
	scala.tools.nsc.typechecker.Typers$Typer.typed1(Typers.scala:6107)
	scala.tools.nsc.typechecker.Typers$Typer.typed(Typers.scala:6153)
	scala.tools.nsc.typechecker.Typers$Typer.doTypedFunction(Typers.scala:6242)
	scala.tools.nsc.typechecker.Typers$Typer.typedFunction(Typers.scala:3139)
	scala.tools.nsc.typechecker.Typers$Typer.$anonfun$typed1$108(Typers.scala:6035)
	scala.tools.nsc.typechecker.Typers$Typer.typedFunction$1(Typers.scala:497)
	scala.tools.nsc.typechecker.Typers$Typer.typedOutsidePatternMode$1(Typers.scala:6075)
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