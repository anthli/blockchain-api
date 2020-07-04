/**
 * Copyright (c) 2020 Anthony Li
 *
 * This source code is licensed under the MIT license (see LICENSE for details)
 */

package com.anthli.blockchainapi.exchangerates

import kotlinx.serialization.Serializable

/**
 * The different currency tickers available in Blockchain's exchange rates.
 */
@Serializable
enum class Currency() {
  /**
   * US Dollar.
   */
  USD,

  /**
   * Australian Dollar.
   */
  AUD,

  /**
   * Brazilian Real.
   */
  BRL,

  /**
   * Canadian Dollar.
   */
  CAD,

  /**
   * Swiss Franc.
   */
  CHF,

  /**
   * Chilean Peso.
   */
  CLP,

  /**
   * Chinese Yuan.
   */
  CNY,

  /**
   * Danish Krone.
   */
  DKK,

  /**
   * Euro.
   */
  EUR,

  /**
   * Pound Sterling.
   */
  GBP,

  /**
   * Hon Kong Dollar.
   */
  HKD,

  /**
   * Indian Rupee.
   */
  INR,

  /**
   * Icelandic Krona.
   */
  ISK,

  /**
   * Japanese Yen.
   */
  JPY,

  /**
   * South Korean Won.
   */
  KRW,

  /**
   * New Zealand Dollar.
   */
  NZD,

  /**
   * Polish Zloty.
   */
  PLN,

  /**
   * Russian Ruble.
   */
  RUB,

  /**
   * Swedish Krona.
   */
  SEK,

  /**
   * Singapore Dollar.
   */
  SGD,

  /**
   * Thai Baht.
   */
  THB,

  /**
   * Turkish Lira.
   */
  TRY,

  /**
   * New Taiwan Dollar.
   */
  TWD
}