package pt.itbio.cryptotracker.crypto.domain

import pt.itbio.cryptotracker.core.domain.util.NetworkError
import pt.itbio.cryptotracker.core.domain.util.Result
import java.time.ZonedDateTime

interface CoinDataSource {
    suspend fun getCoins(): Result<List<Coin>, NetworkError>
    suspend fun getCoinHistory(coinId: String, start: ZonedDateTime, end: ZonedDateTime): Result<List<CoinPrice>, NetworkError>
}