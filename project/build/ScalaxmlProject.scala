import sbt._

class ScalaxmlProject(info: ProjectInfo) extends DefaultProject(info) {

	val tagsoup = "org.ccil.cowan.tagsoup" % "tagsoup" % "1.2" % "compile->default"

	val specs = "org.scala-tools.testing" % "specs" % "1.6.2.2" % "test->default"

}
