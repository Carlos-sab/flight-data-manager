package org.ntic.flights.data

import com.sun.media.sound.InvalidFormatException

/**
 * This class is used to represent a date of a flight
 * @param day: Int
 * @param month: Int
 * @param year: Int
 */
case class FlightDate(day: Int,
                      month: Int,
                      year: Int) {
  override lazy val toString: String = f"$day%02d/$month%02d/$year"
}

object FlightDate {
  /**
   * This function is used to convert a string to a FlightDate
   * @param date: String
   * @return FlightDate
   */
  def fromString(date: String): FlightDate = {
    date.split(" ").head.split("/").map(x => x.toInt).toList match {
      case List(m, d, y) if d >= 1 && d <= 31 && m >= 1 && m <= 12 && y >= 1987 =>
        FlightDate(d, m, y)
      case _ => throw new InvalidFormatException(s"$date has an invalid format.")
    }
  }
}
