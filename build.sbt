
sbtPlugin := true

version := "5.5b2-SNAPSHOT"

organization := "me.browder"

name := "vijava"

libraryDependencies += "dom4j" % "dom4j" % "1.6.1"

credentials += Credentials(file("sonatype.credentials"))

pgpPublicRing := file("./pubring.gpg")

pgpSecretRing := file("./secring.gpg")

pgpPassphrase := sys.env.get("PGP_PASSPHRASE").map(_.toArray)

licenses := Seq("BSD-Style" -> url("http://opensource.org/licenses/BSD-3-Clause"))

homepage := Some(url("http://github.com/kbrowder/vijava"))

publishMavenStyle := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := (
  <scm>
    <url>git@github.com:kbrowder/jooq-sbt-plugin.git</url>
    <connection>scm:git:git@github.com:kbrowder/jooq-sbt-plugin.git</connection>
  </scm>
  <developers>
    <developer>
      <id>kbrowder</id>
      <name>Kevin Browder</name>
    </developer>
    <developer>
      <id>sean8223</id>
      <name>Sean Wellington</name>
    </developer>
  </developers>)
