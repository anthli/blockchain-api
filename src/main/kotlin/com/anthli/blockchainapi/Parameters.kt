/**
 * Copyright (c) 2020 Anthony Li
 *
 * This source code is licensed under the MIT license (see LICENSE for details)
 */

package com.anthli.blockchainapi

/**
 * The available parameters in the Blockchain API.
 */
object Parameters {
  /**
   * The currency to convert to BTC.
   */
  const val CURRENCY = "currency"

  /**
   * The duration over which data should be averaged for charts.
   */
  const val ROLLING_AVERAGE = "rollingAverage"

  /**
   * Determines if the number of chart data points return should be limited.
   */
  const val SAMPLED = "sampled"

  /**
   * The starting datetime of a chart.
   */
  const val START = "start"

  /**
   * The duration of data to retrieve for charts and pools.
   */
  const val TIME_SPAN = "timespan"

  /**
   * The value of the currency to convert to BTC.
   */
  const val VALUE = "value"
}