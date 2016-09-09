organization  := "net.tataryn"

name          := "slick3-problem"

version       := "1.0-SNAPSHOT"

scalaVersion in ThisBuild := "2.11.8"

scalacOptions := Seq(
    "-feature", 
    "-unchecked", 
    "-deprecation", 
//    "-Ywarn-unused-import",
    "-Ywarn-value-discard",
    "-encoding", "utf8")

parallelExecution in Test := false

libraryDependencies ++= Seq(
  "com.typesafe.slick"      %    "slick_2.11"                   %    "3.0.3",
  "commons-codec"           %    "commons-codec"                %    "1.8",
  "ch.qos.logback"          %    "logback-classic"              %    "1.1.7",
  "org.slf4j"               %    "jcl-over-slf4j"               %    "1.7.21",
  "org.slf4j"               %    "jul-to-slf4j"                 %    "1.7.21"
)

