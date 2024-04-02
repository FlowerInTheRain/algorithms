import Dependencies._

ThisBuild / scalaVersion     := "2.13.12"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "al.gro"
ThisBuild / organizationName := "test"
// Scalafmt
ThisBuild / scalafmtOnCompile := true

run / fork := true
run / connectInput := true
Compile / mainClass := Some("al.gro.Main")

lazy val root = (project in file("."))
  .settings(
    name := "scalgorithms",
    scalacOptions ++= compilerOptions,
    libraryDependencies ++= Seq(
      betterFiles,
      typesafeConfig,
      playJson,
      scalatic,
      scalaTest  % Test
    ),
    // Wartremover
    wartremoverWarnings ++= Warts.unsafe,
    wartremoverErrors ++= Warts.unsafe
  )
  

val compilerOptions = Seq(
  // Common settings
  //
  "-deprecation", // Emit warning and location for usages of deprecated APIs.
  "-encoding",
  "utf-8", // Specify character encoding used by source files.
  "-explaintypes", // Explain type errors in more detail.
  "-feature", // Emit warning and location for usages of features that should be imported explicitly.
  "-unchecked", // Enable additional warnings where generated code depends on assumptions.
  "-Xcheckinit", // Wrap field accessors to throw an exception on uninitialized access.
  "-Werror", // Fail the compilation if there are any warnings.
  "-Ymacro-annotations",
  // Warning settings
  //
  // "-Wself-implicit",
  // "-Wdead-code",
  "-Wextra-implicit",
  "-Wnumeric-widen",
  "-Wvalue-discard",
  "-Wunused:imports,patvars,privates,locals,explicits,implicits,params,linted",
  // Linting
  //
  "-Xlint:adapted-args",
  "-Xlint:inaccessible", // Warn about inaccessible types in method signatures.
  "-Xlint:infer-any", // Warn when a type argument is inferred to be `Any`.
  "-Xlint:missing-interpolator",
  "-Xlint:doc-detached",
  "-Xlint:private-shadow",
  "-Xlint:type-parameter-shadow",
  "-Xlint:poly-implicit-overload",
  "-Xlint:option-implicit",
  "-Xlint:package-object-classes",
  "-Xlint:stars-align",
  "-Xlint:constant",
  "-Xlint:valpattern",
  "-Xlint:eta-zero,eta-sam",
  "-Xlint:deprecation",
  "-Xlint:nullary-unit", // Warn when nullary methods return Unit.
  "-Ywarn-value-discard", // Warn when non-Unit expression results are unused.
  "-Xfatal-warnings"
)

val consoleOptions = Seq()
