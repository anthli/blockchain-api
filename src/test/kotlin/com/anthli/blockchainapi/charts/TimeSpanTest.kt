/**
 * Copyright (c) 2020 Anthony Li
 *
 * This source code is licensed under the MIT license (see LICENSE for details)
 */

package com.anthli.blockchainapi.charts

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class TimeSpanTest {
  @Test
  fun testTimeUnitYears() {
    Assertions.assertEquals("1years", TimeSpan(1, TimeUnit.YEARS).toString())
  }

  @Test
  fun testTimeUnitMonths() {
    Assertions.assertEquals("2months", TimeSpan(2, TimeUnit.MONTHS).toString())
  }

  @Test
  fun testTimeUnitDays() {
    Assertions.assertEquals("3days", TimeSpan(3, TimeUnit.DAYS).toString())
  }

  @Test
  fun testTimeUnitHours() {
    Assertions.assertEquals("10hours", TimeSpan(10, TimeUnit.HOURS).toString())
  }

  @Test
  fun testTimeUnitMinutes() {
    Assertions.assertEquals("100minutes", TimeSpan(100, TimeUnit.MINUTES).toString())
  }

  @Test
  fun testNegativeDurationThrowsIllegalArgumentException() {
    Assertions.assertThrows(IllegalArgumentException::class.java) {
      TimeSpan(-1, TimeUnit.YEARS)
    }
  }
}