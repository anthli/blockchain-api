/**
 * Copyright (c) 2020 Anthony Li
 *
 * This source code is licensed under the MIT license (see LICENSE for details)
 */

package com.anthli.blockchainapi.exchangerates

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data container for Blockchain's currency data.
 */
@Serializable
data class CurrencyData(
  @SerialName("buy")
  val buy: Double,

  @SerialName("sell")
  val sell: Double,

  @SerialName("last")
  val last: Double,

  @SerialName("15m")
  val delayedMarketPrice15m : Double,

  @SerialName("symbol")
  val symbol: String
)