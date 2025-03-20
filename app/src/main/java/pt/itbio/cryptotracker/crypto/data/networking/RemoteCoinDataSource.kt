package pt.itbio.cryptotracker.crypto.data.networking

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import pt.itbio.cryptotracker.core.data.networking.constructUrl
import pt.itbio.cryptotracker.core.data.networking.safeCall
import pt.itbio.cryptotracker.core.domain.util.NetworkError
import pt.itbio.cryptotracker.core.domain.util.Result
import pt.itbio.cryptotracker.core.domain.util.map
import pt.itbio.cryptotracker.crypto.data.mappers.toCoin
import pt.itbio.cryptotracker.crypto.data.mappers.toCoinPrice
import pt.itbio.cryptotracker.crypto.data.networking.dto.CoinPriceResponseDto
import pt.itbio.cryptotracker.crypto.data.networking.dto.CoinsResponseDto
import pt.itbio.cryptotracker.crypto.domain.Coin
import pt.itbio.cryptotracker.crypto.domain.CoinDataSource
import pt.itbio.cryptotracker.crypto.domain.CoinPrice
import java.time.ZoneId
import java.time.ZonedDateTime

class RemoteCoinDataSource(
    private val httpClient: HttpClient
): CoinDataSource {
    override suspend fun getCoins(): Result<List<Coin>, NetworkError> {
        return safeCall<CoinsResponseDto> {
            httpClient.get(
                urlString = constructUrl("/assets")
            )
        }.map { response ->
            response.data.map { it.toCoin() }
        }
    }

    override suspend fun getCoinHistory(
        coinId: String,
        start: ZonedDateTime,
        end: ZonedDateTime,
    ): Result<List<CoinPrice>, NetworkError> {
        val startMillis = start.withZoneSameInstant(ZoneId.of("UTC")).toInstant().toEpochMilli()
        val endMillis = end.withZoneSameInstant(ZoneId.of("UTC")).toInstant().toEpochMilli()

        return safeCall<CoinPriceResponseDto> {
            httpClient.get(
                urlString = constructUrl("/assets/$coinId/history")
            ) {
                parameter("interval", "h6")
                parameter("start", startMillis)
                parameter("end", endMillis)
            }
        }.map { response ->
            response.data.map {
                it.toCoinPrice()
            }
        }
    }
}