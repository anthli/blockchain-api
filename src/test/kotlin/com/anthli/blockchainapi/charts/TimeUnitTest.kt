/**
 * Copyright (c) 2020 Anthony Li
 *
 * This source code is licensed under the MIT license (see LICENSE for details)
 */

package com.anthli.blockchainapi.charts

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class TimeUnitTest {
  @Test
  fun testTimeUnitToStringIsLowerCase() {
    Assertions.assertEquals("years", TimeUnit.YEARS.toString())
    Assertions.assertEquals("months", TimeUnit.MONTHS.toString())
    Assertions.assertEquals("weeks", TimeUnit.WEEKS.toString())
    Assertions.assertEquals("days", TimeUnit.DAYS.toString())
    Assertions.assertEquals("hours", TimeUnit.HOURS.toString())
    Assertions.assertEquals("minutes", TimeUnit.MINUTES.toString())
  }
}