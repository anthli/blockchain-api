/**
 * Copyright (c) 2020 Anthony Li
 *
 * This source code is licensed under the MIT license (see LICENSE for details)
 */

package com.anthli.blockchainapi.serializer

import io.mockk.every
import io.mockk.mockk
import kotlinx.serialization.Decoder
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

class LongScientificNotationSerializerTest {
  companion object {
    private val mockDecoder = mockk<Decoder>()

    @JvmStatic
    @BeforeAll
    fun setup() {
      every { mockDecoder.decodeString() } returns "12345E2"
    }
  }

  @Test
  fun testDeserialize() {
    val longValue = LongScientificNotationSerializer.deserialize(mockDecoder)
    Assertions.assertNotNull(longValue)
    Assertions.assertEquals(1234500, longValue)
  }
}