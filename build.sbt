name := """blog-api"""
organization := "me.littlebit"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.6"

libraryDependencies ++= Seq(
  evolutions,
  jdbc,
  jdbc % Test,
  "mysql" % "mysql-connector-java" % "5.1.46",
  "com.github.nscala-time" %% "nscala-time" % "2.18.0",
  "com.typesafe.play" % "play-json-joda_2.12" % "2.6.0",
  "com.softwaremill.macwire" %% "macros" % "2.3.0" % "provided",
  "org.playframework.anorm" %% "anorm" % "2.6.2",
  "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test,
  "org.mockito" % "mockito-core" % "2.16.0" % Test,
  "com.h2database" % "h2" % "1.4.192" % Test
)


// Adds additional packages into Twirl
//TwirlKeys.templateImports += "me.littlebit.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "me.littlebit.binders._"
