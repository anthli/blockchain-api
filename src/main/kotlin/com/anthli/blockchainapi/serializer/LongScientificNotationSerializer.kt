/**
 * Copyright (c) 2020 Anthony Li
 *
 * This source code is licensed under the MIT license (see LICENSE for details)
 */

package com.anthli.blockchainapi.serializer

import kotlinx.serialization.Decoder
import kotlinx.serialization.Encoder
import kotlinx.serialization.KSerializer
import kotlinx.serialization.PrimitiveDescriptor
import kotlinx.serialization.PrimitiveKind
import kotlinx.serialization.SerialDescriptor

/**
 * Serializer for [Long] as [String] represented in scientific notation.
 *
 * Under the hood, strings are converted to doubles before being converted to
 * longs. This is to properly handle any possible longs being represented in
 * scientific notation.
 */
object LongScientificNotationSerializer : KSerializer<Long> {
  override val descriptor: SerialDescriptor =
    PrimitiveDescriptor("LongScientificNotationSerializer", PrimitiveKind.STRING)

  override fun serialize(encoder: Encoder, value: Long) {
    // No-op; one-way deserialization from scientific notation to long
  }

  override fun deserialize(decoder: Decoder): Long {
    return decoder.decodeString().toDouble().toLong()
  }
}