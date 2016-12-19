name := "akka-remote"

version := "1.0.0"

scalaVersion := "2.12.1"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.4.14",
  "com.typesafe.akka" %% "akka-remote" % "2.4.14",
  "com.github.romix.akka" %% "akka-kryo-serialization" % "0.5.1",
  "org.scalactic" %% "scalactic" % "3.0.0" % "test"
)

resolvers += Resolver.jcenterRepo

fork in run := true

connectInput in run := true

cancelable in Global := true