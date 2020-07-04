/**
 * Copyright (c) 2020 Anthony Li
 *
 * This source code is licensed under the MIT license (see LICENSE for details)
 */

package com.anthli.blockchainapi.charts

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data container for Blockchain's charts.
 */
@Serializable
data class Chart(
  @SerialName("status")
  val status: String,

  @SerialName("name")
  val name: String,

  @SerialName("unit")
  val unit: String,

  @SerialName("period")
  val period: String,

  @SerialName("description")
  val description: String,

  @SerialName("values")
  val values: List<Coordinates>
)