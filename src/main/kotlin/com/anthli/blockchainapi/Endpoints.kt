/**
 * Copyright (c) 2020 Anthony Li
 *
 * This source code is licensed under the MIT license (see LICENSE for details)
 */

package com.anthli.blockchainapi

/**
 * The available endpoints in the Blockchain API.
 */
object Endpoints {
  /**
   * Charts endpoint for getting the data behind Blockchain's charts.
   */
  const val CHARTS = "charts"

  /**
   * Pools endpoint for getting the data behind Blockchain's pools information.
   */
  const val POOLS = "pools"

  /**
   * Statistics endpoint for getting the data behind Blockchain's stats.
   */
  const val STATS = "stats"

  /**
   * Ticker endpoint for getting the mapping of currency tickers to their market
   * prices.
   */
  const val TICKER = "ticker"

  /**
   * BTC conversion endpoint for converting a given currency and value to BTC.
   */
  const val TO_BTC = "tobtc"
}