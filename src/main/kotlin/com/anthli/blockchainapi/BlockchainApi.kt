/**
 * Copyright (c) 2020 Anthony Li
 *
 * This source code is licensed under the MIT license (see LICENSE for details)
 */

package com.anthli.blockchainapi

import com.anthli.blockchainapi.charts.Chart
import com.anthli.blockchainapi.charts.ChartType
import com.anthli.blockchainapi.charts.TimeSpan
import com.anthli.blockchainapi.statistics.Statistics
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

const val BASE_URL = "https://api.blockchain.info"

const val CHARTS_ENDPOINT = "charts"
const val STATS_ENDPOINT = "stats"
const val POOLS_ENDPOINT = "pools"

const val DATETIME_FORMAT = "yyyy-MM-dd"
const val TIMEZONE = "UTC"

const val TIME_SPAN = "timespan"
const val ROLLING_AVERAGE = "rollingAverage"
const val START = "start"
const val SAMPLED = "sampled"

class BlockchainApi {
  private val json = Json(JsonConfiguration.Stable.copy(isLenient = true))

  /**
   * Retrieves the data behind Blockchain's charts.
   *
   * @param chartType
   *   The type of chart to retrieve data from.
   * @param timeSpan
   *   The duration of the data in the chart. If unspecified, the API defaults
   *   to 1 year for most charts and 1 week for mempool charts.
   * @param rollingAverage
   *  The duration over which the data should be averaged.
   * @param start
   *   The datetime at which to start retrieving data.
   * @param sampled
   *   Determines whether to limit the number of data points returned from the
   *   API. If unspecified, the API defaults to true where the limit is
   *   approximately 1500 data points.
   * @return
   *   A [Chart] object containing the chart data behind Blockchain's charts for
   *   the requested [ChartType].
   */
  fun getChart(
    chartType: ChartType,
    timeSpan: TimeSpan? = null,
    rollingAverage: TimeSpan? = null,
    start: Instant? = null,
    sampled: Boolean? = null
  ): Chart {
    val params = mutableListOf<Pair<String, String>>()
    if (timeSpan != null) {
      params.add(TIME_SPAN to timeSpan.toString())
    }

    if (rollingAverage != null) {
      params.add(ROLLING_AVERAGE to rollingAverage.toString())
    }

    if (start != null) {
      val startString = DateTimeFormatter
        .ofPattern(DATETIME_FORMAT)
        .withZone(ZoneId.of(TIMEZONE))
        .format(start)
      params.add(START to startString)
    }

    if (sampled != null) {
      params.add(SAMPLED to sampled.toString())
    }

    val url = listOf(BASE_URL, CHARTS_ENDPOINT, chartType.chartName).joinToString("/")
    val chart = getData(Chart.serializer(), url, params)
    return chart
  }

  /**
   * Retrieves the data behind Blockchain's stats.
   *
   * @return
   *   A [Statistics] object containing the statistics data behind Blockchain's
   *   stats.
   */
  fun getStatistics(): Statistics {
    val url = listOf(BASE_URL, STATS_ENDPOINT).joinToString("/")
    val statistics = getData(Statistics.serializer(), url)
    return statistics
  }

  /**
   * Retrieves the data behind Blockchain's pools information.
   *
   * @param timeSpan
   *   The time span over which the data will be computed. The maximum allowed
   *   by the API is 10 days. If unspecified, the API defaults to 4 days.
   * @return
   *   A mapping of miners/pools to the number of blocks mined.
   */
  fun getPools(timeSpan: TimeSpan? = null): Map<String, Int> {
    val params = mutableListOf<Pair<String, String>>()
    if (timeSpan != null) {
      params.add(TIME_SPAN to timeSpan.toString())
    }

    val url = listOf(BASE_URL, POOLS_ENDPOINT).joinToString("/")
    val pool = getData(MapSerializer(String.serializer(), Int.serializer()), url, params)
    return pool
  }

  /**
   * Performs a GET request on the URL with the given parameters and returns the
   * response parsed into an object T.
   *
   * @param deserializationStrategy
   *   The deserialization strategy used to deserialize the response into an
   *   object T.
   * @param url
   *   The URL to perform a GET request on.
   * @param params
   *   The parameters to pass along in the GET request.
   * @return
   *   The parsed response into an object T.
   */
  private inline fun <reified T> getData(
    deserializationStrategy: DeserializationStrategy<T>,
    url: String,
    params: List<Pair<String, String>> = listOf()
  ): T {
    val (_, _, result) = url.httpGet(params).responseString()
    return when (result) {
      is Result.Success -> {
        val resultString = result.get()
        json.parse(deserializationStrategy, resultString)
      }
      is Result.Failure -> throw result.getException()
    }
  }
}