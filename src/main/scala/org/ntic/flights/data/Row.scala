package org.ntic.flights.data

import scala.language.postfixOps
import scala.util.Try

/**
 * This class is used to represent a row of the flights data. It contains the following fields:
 * @param flDate: String
 * @param originAirportId: Long
 * @param origin: String
 * @param originCityName: String
 * @param originStateAbr: String
 * @param destAirportId: Long
 * @param dest: String
 * @param destCityName: String
 * @param destStateAbr: String
 * @param depTime: String
 * @param depDelay: Double
 * @param arrTime: String
 * @param arrDelay: Double
 */
case class Row (
                 flDate: String,
                 originAirportId: Long,
                 origin: String,
                 originCityName: String,
                 originStateAbr: String,
                 destAirportId: Long,
                 dest: String,
                 destCityName: String,
                 destStateAbr: String,
                 depTime: String,
                 depDelay: Double,
                 arrTime: String,
                 arrDelay: Double
               )

object Row {

  /**
   * This method is used to create a Row object from a list of tokens. It returns a Try[Row] object.
   * If the list of tokens is not valid or any of the token is invalid, it returns a Failure object. Otherwise, it returns a Success object.
   *
   * @param tokens: Seq[String]
   * @return Try[Row]
   */
  def fromStringList(tokens: Seq[String]): Try[Row] = for {
      flDate <- Try(tokens(0).trim)
      originAirportId <- Try(tokens(1).trim.toLong)
      origin <- Try(tokens(2).trim)
      originCityName <- Try(tokens(3).trim)
      originStateAbr <- Try(tokens(4).trim)
      destAirportId <- Try(tokens(5).trim.toLong)
      dest <- Try(tokens(6).trim)
      destCityName <- Try(tokens(7).trim)
      destStateAbr <- Try(tokens(8).trim)
      depTime <- Try(tokens(9).trim)
      depDelay <- Try(tokens(10).trim.toDouble)
      arrTime <- Try(tokens(11).trim)
      arrDelay <- Try(tokens(12).trim.toDouble)
    } yield Row(flDate, originAirportId, origin, originCityName, originStateAbr, destAirportId, dest, destCityName,
      destStateAbr, depTime, depDelay, arrTime, arrDelay)
}