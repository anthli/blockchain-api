/**
 * Copyright (c) 2020 Anthony Li
 *
 * This source code is licensed under the MIT license (see LICENSE for details)
 */

package com.anthli.blockchainapi

import com.anthli.blockchainapi.charts.ChartType
import com.anthli.blockchainapi.charts.TimeSpan
import com.anthli.blockchainapi.charts.TimeUnit
import com.github.kittinunf.fuel.core.FuelError
import kotlinx.serialization.ImplicitReflectionSerializer
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.Instant

@ImplicitReflectionSerializer
class BlockchainApiTest {
  private val blockchainApi = BlockchainApi()

  @Test
  fun testGetChart() {
    val chart = blockchainApi.getChart(ChartType.TOTAL_CIRCULATING_BITCOIN)
    Assertions.assertNotNull(chart)
    Assertions.assertEquals("ok", chart.status)
    Assertions.assertEquals("Bitcoins in circulation", chart.name)
    Assertions.assertEquals("BTC", chart.unit)
    Assertions.assertTrue(chart.values.isNotEmpty())
  }

  @Test
  fun getGetChartTimeSpan1Hour() {
    val chart = blockchainApi.getChart(
      ChartType.TOTAL_CIRCULATING_BITCOIN,
      TimeSpan(1, TimeUnit.HOURS)
    )
    Assertions.assertNotNull(chart)
    Assertions.assertTrue(chart.values.isNotEmpty())
  }

  @Test
  fun testGetChartRollingAverage1Week() {
    val chart = blockchainApi.getChart(
      ChartType.TOTAL_CIRCULATING_BITCOIN,
      rollingAverage = TimeSpan(1, TimeUnit.WEEKS)
    )
    Assertions.assertNotNull(chart)
    Assertions.assertTrue(chart.values.isNotEmpty())
  }

  /**
   * 2009-01-03 is the first entry for total circulating bitcoins
   */
  @Test
  fun testGetChartStart20090103() {
    val chart = blockchainApi.getChart(
      ChartType.TOTAL_CIRCULATING_BITCOIN,
      start = Instant.ofEpochSecond(1231006505)
    )
    Assertions.assertNotNull(chart)
    Assertions.assertTrue(chart.values.isNotEmpty())
  }

  /**
   * Ensures that setting sampled = false returns more than the 1500 data point
   * limit.
   */
  @Test
  fun testGetChartSampledFalse() {
    val chart = blockchainApi.getChart(
      ChartType.TOTAL_CIRCULATING_BITCOIN,
      sampled = false
    )
    Assertions.assertNotNull(chart)
    Assertions.assertTrue(chart.values.isNotEmpty())
    Assertions.assertTrue(chart.values.size > 1500)
  }

  @Test
  fun testGetStatistics() {
    val statistics = blockchainApi.getStatistics()
    Assertions.assertNotNull(statistics)
    Assertions.assertNotNull(statistics.timestamp)
    Assertions.assertNotNull(statistics.marketPriceUsd)
    Assertions.assertNotNull(statistics.hashRate)
    Assertions.assertNotNull(statistics.totalFeesBtc)
    Assertions.assertNotNull(statistics.numberOfBitcoinMined)
    Assertions.assertNotNull(statistics.numberOfTransactions)
    Assertions.assertNotNull(statistics.numberOfBlocksMined)
    Assertions.assertNotNull(statistics.minutesBetweenBlocks)
    Assertions.assertNotNull(statistics.totalBitcoin)
    Assertions.assertNotNull(statistics.estimatedTransactionVolumeUsd)
    Assertions.assertNotNull(statistics.blocksSize)
    Assertions.assertNotNull(statistics.minersRevenueUsd)
    Assertions.assertNotNull(statistics.nextRetarget)
    Assertions.assertNotNull(statistics.difficulty)
    Assertions.assertNotNull(statistics.estimatedBitcoinSent)
    Assertions.assertNotNull(statistics.minersRevenueBtc)
    Assertions.assertNotNull(statistics.totalBitcoinSent)
    Assertions.assertNotNull(statistics.tradeVolumeBtc)
    Assertions.assertNotNull(statistics.tradeVolumeUsd)
  }

  @Test
  fun testGetPools() {
    val pools = blockchainApi.getPools()
    Assertions.assertNotNull(pools)
  }

  @Test
  fun testGetPoolsWithTimeSpan() {
    val pools = blockchainApi.getPools(TimeSpan(1, TimeUnit.DAYS))
    Assertions.assertNotNull(pools)
  }

  @Test
  fun testGetPoolsWithTimeSpanGreaterThanMaximumAllowed() {
    Assertions.assertThrows(FuelError::class.java) {
      blockchainApi.getPools(TimeSpan(2, TimeUnit.WEEKS))
    }
  }
}