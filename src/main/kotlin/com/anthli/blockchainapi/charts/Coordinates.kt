/**
 * Copyright (c) 2020 Anthony Li
 *
 * This source code is licensed under the MIT license (see LICENSE for details)
 */

package com.anthli.blockchainapi.charts

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Coordinates of a data point in Blockchain's charts. The x-coordinate
 * represents a Unix timestamp and the y-coordinate represents a value with
 * respect to the chart.
 */
@Serializable
data class Coordinates(
  @SerialName("x")
  val x: Long,

  @SerialName("y")
  val y: Double
)