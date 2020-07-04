/**
 * Copyright (c) 2020 Anthony Li
 *
 * This source code is licensed under the MIT license (see LICENSE for details)
 */

@file:UseSerializers(DoubleAsStringSerializer::class, LongScientificNotationSerializer::class)

package com.anthli.blockchainapi.statistics

import com.anthli.blockchainapi.serializer.DoubleAsStringSerializer
import com.anthli.blockchainapi.serializer.LongScientificNotationSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

/**
 * Data container for Blockchain's statistics.
 */
@Serializable
data class Statistics(
  @SerialName("market_price_usd")
  val marketPriceUsd: Double,

  @SerialName("hash_rate")
  val hashRate: Double,

  @SerialName("total_fees_btc")
  val totalFeesBtc: Long,

  @SerialName("n_btc_mined")
  val numberOfBitcoinMined: Long,

  @SerialName("n_tx")
  val numberOfTransactions: Long,

  @SerialName("n_blocks_mined")
  val numberOfBlocksMined: Long,

  @SerialName("minutes_between_blocks")
  val minutesBetweenBlocks: Double,

  @SerialName("totalbc")
  val totalBitcoin: Long,

  @SerialName("n_blocks_total")
  val numberOfBlocksTotal: Long,

  @SerialName("estimated_transaction_volume_usd")
  val estimatedTransactionVolumeUsd: Double,

  @SerialName("blocks_size")
  val blocksSize: Long,

  @SerialName("miners_revenue_usd")
  val minersRevenueUsd: Double,

  @SerialName("nextretarget")
  val nextRetarget: Long,

  @SerialName("difficulty")
  val difficulty: Long,

  @SerialName("estimated_btc_sent")
  val estimatedBitcoinSent: Long,

  @SerialName("miners_revenue_btc")
  val minersRevenueBtc: Long,

  @SerialName("total_btc_sent")
  val totalBitcoinSent: Long,

  @SerialName("trade_volume_btc")
  val tradeVolumeBtc: Double,

  @SerialName("trade_volume_usd")
  val tradeVolumeUsd: Double,

  @SerialName("timestamp")
  val timestamp: Long
)