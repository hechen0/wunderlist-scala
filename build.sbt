lazy val root = (project in file(".")).
    settings(
        name := "hello world",
        version := "0.0.1",
        scalaVersion := "2.11.8",
        libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.0",
        libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0" % "test",
        libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.4.12",
        libraryDependencies +=  "org.scalaj" %% "scalaj-http" % "2.3.0",
        libraryDependencies += "com.typesafe.play" %% "play-json" % "2.5.10"
      )
