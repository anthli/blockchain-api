/**
 * Copyright (c) 2020 Anthony Li
 *
 * This source code is licensed under the MIT license (see LICENSE for details)
 */

package com.anthli.blockchainapi.charts

/**
 * The representation of different units of time for parameters that require
 * a time span in the Blockchain API.
 */
enum class TimeUnit {
  YEARS,
  MONTHS,
  WEEKS,
  DAYS,
  HOURS,
  MINUTES;

  override fun toString(): String {
    return super.toString().toLowerCase()
  }
}