name := "SparkFormationExample"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.11.8"

organization := "com.formationaloui.sfe"

val sparkVersion = "2.3.0"

mainClass in Compile := Some("com.formationaloui.sfe.Main")

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  "org.scalacheck" %% "scalacheck" % "1.14.0" % "test",
  "org.scalatest" %% "scalatest" % "3.0.5" % "test",
  "com.holdenkarau" %% "spark-testing-base" % "2.3.0_0.10.0" % "test",
  "org.apache.spark" %% "spark-hive" % "2.3.0"
)