ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.10"

libraryDependencies += "org.apache.httpcomponents" % "httpclient" % "4.5.14"

lazy val root = (project in file("."))
  .settings(
    name := "untitled1"
  )
