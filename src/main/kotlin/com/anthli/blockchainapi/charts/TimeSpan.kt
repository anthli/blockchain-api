/**
 * Copyright (c) 2020 Anthony Li
 *
 * This source code is licensed under the MIT license (see LICENSE for details)
 */

package com.anthli.blockchainapi.charts

/**
 * Represents the time span used for retrieving data. A time span consists of a
 * positive duration of time to request for and a unit of time to request with.
 * For example, one day would have a duration of 1 and a unit of time as
 * [TimeUnit.DAYS].
 */
data class TimeSpan(private val duration: Int, private val timeUnit: TimeUnit) {
  init {
    require(duration >= 0) { "The duration of a time span cannot be negative" }
  }

  override fun toString(): String {
    return "$duration$timeUnit"
  }
}