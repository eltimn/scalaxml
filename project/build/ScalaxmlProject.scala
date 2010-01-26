import sbt._

class ScalaxmlProject(info: ProjectInfo) extends DefaultProject(info) {
	override def useMavenConfigurations = true
	
	//override def compileOptions = super.compileOptions ++ Seq(Unchecked)
	
	val tagsoup = "org.ccil.cowan.tagsoup" % "tagsoup" % "1.2" % "compile->default"
	
}
