name := """phone-rest-api"""
organization := "com.scala"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.11"

libraryDependencies += filters
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "2.0.0" % Test
libraryDependencies += "org.reactivemongo" %% "play2-reactivemongo" % "0.11.14"


// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.scala.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.scala.binders._"
