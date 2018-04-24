name := """blog-api"""
organization := "me.littlebit"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  evolutions,
  jdbc,
  jdbc % Test,
  "com.softwaremill.macwire" %% "macros" % "2.3.0" % "provided",
  "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test,
  "org.mockito" % "mockito-core" % "2.16.0" % Test
)


// Adds additional packages into Twirl
//TwirlKeys.templateImports += "me.littlebit.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "me.littlebit.binders._"
