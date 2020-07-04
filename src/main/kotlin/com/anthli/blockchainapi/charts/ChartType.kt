/**
 * Copyright (c) 2020 Anthony Li
 *
 * This source code is licensed under the MIT license (see LICENSE for details)
 */

package com.anthli.blockchainapi.charts

/**
 * The different chart types available in Blockchain's charts.
 */
enum class ChartType(val chartName: String) {
  // Currency Statistics

  /**
   * The total number of mined bitcoin that are currently circulating on the
   * network.
   */
  TOTAL_CIRCULATING_BITCOIN("total-bitcoins"),

  /**
   * The average USD market price across major bitcoin exchanges.
   */
  MARKET_PRICE("market-price"),

  /**
   * The total USD value of bitcoin in circulation.
   */
  MARKET_CAPITALIZATION("market-cap"),

  /**
   * The total USD value of trading volume on major bitcoin exchanges.
   */
  EXCHANGE_TRADE_VOLUME("trade-volume"),


  // Block Details

  /**
   * The total size of the blockchain minus database indexes in megabytes.
   */
  BLOCKCHAIN_SIZE("blocks-size"),

  /**
   * The total size of the blockchain minus database indexes in megabytes.
   */
  AVERAGE_BLOCK_SIZE("avg-block-size"),

  /**
   * The average block size over the past 24 hours in megabytes.
   */
  AVERAGE_TRANSACTIONS_PER_BLOCK("n-transactions-per-block"),

  /**
   * The total number of transactions on the blockchain.
   */
  TOTAL_NUMBER_OF_TRANSACTIONS("n-transactions-total"),

  /**
   * The median time for a transaction with miner fees to be included in a mined
   * block and added to the public ledger.
   */
  MEDIAN_CONFIRMATION_TIME("median-confirmation-time"),

  /**
   * The average time for a transaction with miner fees to be included in a
   * mined block and added to the public ledger.
   */
  AVERAGE_CONFIRMATION_TIME("avg-confirmation-time"),


  // Mining Information

  /**
   * The estimated number of terahashes per second the bitcoin network is
   * performing in the last 24 hours.
   */
  TOTAL_HASH_RATE("hash-rate"),

  /**
   * An estimation of hashrate distribution amongst the largest mining pools.
   */
  HASHRATE_DISTRIBUTION("pools"),

  /**
   * An estimation of hashrate distribution over time amongst the largest mining
   * pools.
   */
  HASHRATE_DISTRIBUTION_OVER_TIME("pools-timeseries"),

  /**
   * A relative measure of how difficult it is to mine a new block for the
   * blockchain.
   */
  NETWORK_DIFFICULTY("difficulty"),

  /**
   * Total value of coinbase block rewards and transaction fees paid to miners.
   */
  MINERS_REVENUE_USD("miners-revenue"),

  /**
   * The total BTC value of all transaction fees paid to miners. This does not
   * include coinbase block rewards.
   */
  TOTAL_TRANSACTION_FEES_BTC("transaction-fees"),

  /**
   * The total USD value of all transaction fees paid to miners. This does not
   * include coinbase block rewards.
   */
  TOTAL_TRANSACTION_FEES_USD("transaction-fees-usd"),

  /**
   * Average transaction fees in USD per transaction.
   */
  FEES_PER_TRANSACTION("fees-usd-per-transaction"),

  /**
   * A chart showing miners revenue as percentage of the transaction volume.
   */
  COST_PERCENTAGE_OF_TRANSACTION_VOLUME("cost-per-transaction-percent"),

  /**
   * A chart showing miners revenue divided by the number of transactions.
   */
  COST_PER_TRANSACTION("cost-per-transaction"),


  // Network Activity

  /**
   * The total number of unique addresses used on the blockchain.
   */
  UNIQUE_ADDRESSES_USED("n-unique-addresses"),

  /**
   * The total number of confirmed transactions per day.
   */
  CONFIRMED_TRANSACTIONS_PER_DAY("n-transactions"),

  /**
   * The number of transactions added to the mempool per second.
   */
  TRANSACTION_RATE_PER_SECOND("transactions-per-second"),

  /**
   * The total value of all transaction outputs per day. This includes coins
   * returned to the sender as change.
   */
  OUTPUT_VALUE_PER_DAY("output-volume"),

  /**
   * The total number of unconfirmed transactions in the mempool.
   */
  MEMPOOL_TRANSACTION_COUNT("mempool-count"),

  /**
   * The rate at which the mempool is growing in bytes per second.
   */
  MEMPOOL_SIZE_GROWTH("mempool-growth"),

  /**
   * The aggregate size in bytes of transactions waiting to be confirmed.
   */
  MEMPOOL_SIZE("mempool-size"),

  /**
   * The current state of the mempool organized by bytes per fee level.
   */
  MEMPOOL_BYTES_PER_FEE_LEVEL("mempool-state-by-fee-level"),

  /**
   * The total number of valid unspent transactions outputs. This excludes
   * invalid UTXOs with opcode OP_RETURN.
   */
  UNSPENT_TRANSACTION_OUTPUTS("utxo-count"),

  /**
   * The total number of transactions excluding those involving the network's
   * 100 most popular addresses.
   */
  TRANSACTIONS_EXCLUDING_POPULAR_ADDRESSES("n-transactions-excluding-popular"),

  /**
   * The total estimated value in BTC of transactions on the blockchain. This
   * does not include coins returned as change.
   */
  ESTIMATED_TRANSACTION_VALUE_BTC("estimated-transaction-volume"),

  /**
   * The total estimated value in USD of transactions on the blockchain. This
   * does not include coins returned as change.
   */
  ESTIMATED_TRANSACTION_VALUE_USD("estimated-transaction-volume-usd"),


  // Wallet Activity

  /**
   * The total number of unique Blockchain.com wallets created.
   */
  BLOCKCHAIN_COM_WALLETS("my-wallet-n-users"),


  // Market Signals

  /**
   * MVRV is calculated by dividing Market Value by Realised Value. In Realised
   * Value, BTC prices are taken at the time they last moved instead of the
   * current price like with Market Value.
   */
  MARKET_VALUE_TO_REALIZED_VALUE("mvrv"),

  /**
   * NVT is computed by dividing the Network Value (= Market Value) by the total
   * transactions volume in USD over the past 24 hours.
   */
  NETWORK_VALUE_TO_TRANSACTIONS("nvt"),

  /**
   * NVTS is a more stable measure of NVT with the denominator being the moving
   * average over the last 90 days of NVT's denominator.
   */
  NETWORK_VALUE_TO_TRANSACTIONS_SIGNAL("nvts")
}