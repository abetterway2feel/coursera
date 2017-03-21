name := "scala-spark-big-data"
organization := "com.abetterway2feel"
version := "0.1-SNAPSHOT"
scalaVersion := "2.11.8"

val sparkversion = "2.1.0"

libraryDependencies ++= Seq(
  // spark core
  "org.apache.spark" %% "spark-core" % sparkversion,
  "org.apache.spark" %% "spark-sql" % sparkversion,
  "org.apache.spark" %% "spark-hive" % sparkversion % "provided",

  "org.scalatest"   %% "scalatest"    % "3.0.1"   % "test"
)

mainClass in (Compile, packageBin) := Some("com.abetterway2feel.scala-spark-big-data.ExampleClass")
scalacOptions ++= List("-feature","-deprecation", "-unchecked", "-Xlint")
testOptions in Test += Tests.Argument(
  TestFrameworks.ScalaTest,
  "-l", "org.scalatest.tags.Slow",
  "-u","target/junit-xml-reports",
  "-oD",
  "-eS"
)
