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
 * Serializer for [Double] as [String].
 */
object DoubleAsStringSerializer : KSerializer<Double> {
  override val descriptor: SerialDescriptor =
    PrimitiveDescriptor("DoubleAsStringSerializer", PrimitiveKind.STRING)

  override fun serialize(encoder: Encoder, value: Double) {
    encoder.encodeString(value.toString())
  }

  override fun deserialize(decoder: Decoder): Double {
    return decoder.decodeString().toDouble()
  }
}