ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.15"

lazy val root = (project in file("."))
  .settings(
    name := "ScalaHttpServerTemplate",
    idePackagePrefix := Some("org.pvgus")
  )
  .settings(resolvers += "Akka library repository".at("https://repo.akka.io/maven"))
  .settings(
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http" % "10.7.0",
      "com.typesafe.akka" %% "akka-actor-typed" % "2.10.2",
      "com.typesafe.akka" %% "akka-http-spray-json" % "10.6.3"
    )
  )
