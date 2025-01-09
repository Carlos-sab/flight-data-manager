package org.ntic.flights

import com.typesafe.config.{Config, ConfigFactory}

import scala.jdk.CollectionConverters.*

object FlightsLoaderConfig {
  val config: Config = ConfigFactory.load()
  val filePath: String = config.getString("flightsLoader.filePath")
  val hasHeaders: Boolean = config.getBoolean("flightsLoader.hasHeaders")
  val headersLength: Int = config.getInt("flightsLoader.headersLength")
  val delimiter: String = config.getString("flightsLoader.delimiter")
  val outputDir: String = config.getString("flightsLoader.outputDir")
  val headers: List[String] = config.getStringList("flightsLoader.headers").asScala.toList
  val columnIndexMap: Map[String, Int] = headers.map(x => (x, headers.indexOf(x))).toMap
  val filteredOrigin: List[String] = config.getStringList("flightsLoader.filteredOrigin").asScala.toList
}
