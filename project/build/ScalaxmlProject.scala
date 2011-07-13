import sbt._

class ScalaxmlProject(info: ProjectInfo) extends DefaultProject(info) {

	val tagsoup = "org.ccil.cowan.tagsoup" % "tagsoup" % "1.2" % "compile->default"

	val specs = "org.scala-tools.testing" %% "specs" % "1.6.8" % "test->default"
	val junit = "junit" % "junit" % "4.5" % "test->default"

	/**
   * Test if project is a SNAPSHOT build.
   */
  def isSnapshot = version.toString.endsWith("-SNAPSHOT")

  lazy val localRepo = Path.userHome / "projects" / "eltimn-mvn-repo"

	object PublishRepositories {
    lazy val snapshot = Resolver.file("eltimn Maven Repo for Snapshots", localRepo / "snapshots" asFile)
    lazy val release  = Resolver.file("eltimn Maven Repo for Releases", localRepo / "releases" asFile)
  }

  override def managedStyle = ManagedStyle.Maven

  lazy val publishTo =
    if (isSnapshot) PublishRepositories.snapshot
    else PublishRepositories.release
}
