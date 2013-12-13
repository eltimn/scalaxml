name := "scalaxml"

scalaVersion := "2.10.3"

version := "0.6"

organization := "com.eltimn"

scalacOptions := Seq("-deprecation", "-unchecked", "-feature", "-language:postfixOps", "-language:implicitConversions")

libraryDependencies ++= Seq(
  "org.ccil.cowan.tagsoup" % "tagsoup" % "1.2" % "compile",
  "org.scalatest" %% "scalatest" % "1.9.2" % "test"
)
