ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "3.3.4"

lazy val root = (project in file("."))
  .settings(
    name := "TareaScala",

    // Dependencias del proyecto
    libraryDependencies ++= Seq(
      "com.typesafe" % "config" % "1.4.3",
      "org.scalatest" %% "scalatest" % "3.2.19" % Test
    ),

    // Habilitar fork para ejecutar el código en un proceso separado
    fork := true,
    javaOptions ++= Seq(
      "-XX:+ShowCodeDetailsInExceptionMessages"               // Detalles completos de las excepciones
    ),

    // Configuraciones específicas para pruebas
    Test / fork := true,                                      // Fork separado para pruebas
    Test / javaOptions ++= Seq(
      "--add-exports",
      "java.desktop/com.sun.media.sound=ALL-UNNAMED"          // Exportación específica para pruebas
    )
  )
