package org.ntic.flights

import org.ntic.flights.data.{Flight, FlightsFileReport, Row}

import scala.util.Try

object FlightsLoaderApp extends App {

  val fileLines: Seq[String] = FileUtils.getLinesFromFile(FlightsLoaderConfig.filePath)
  val rows: Seq[Try[Row]] = FileUtils.loadFromFileLines(fileLines)
  val flightReport: FlightsFileReport = FlightsFileReport.fromRows(rows)
  val flights: Seq[Flight] = flightReport.flights

  for (originAirport <- FlightsLoaderConfig.filteredOrigin) {

    val filteredFlights: Seq[Flight] = flights.filter(flight => originAirport.contains(flight.origin.code))
    val delayedFlights: Seq[Flight] = filteredFlights.filter(_.isDelayed).sorted
    val notDelayedFlights: Seq[Flight] = filteredFlights.filter(_.isDelayed == false).sorted

    val delayedFlightsObj: String = FlightsLoaderConfig.outputDir + originAirport + "_delayed.obj"
    val flightsObj: String = FlightsLoaderConfig.outputDir + originAirport + ".obj"
    FileUtils.writeFile(delayedFlights, delayedFlightsObj)
    FileUtils.writeFile(notDelayedFlights, flightsObj)
  }

  println(flightReport)
}
