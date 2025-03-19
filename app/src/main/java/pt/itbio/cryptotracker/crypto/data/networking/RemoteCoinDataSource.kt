package pt.itbio.cryptotracker.crypto.data.networking

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import pt.itbio.cryptotracker.core.data.networking.constructUrl
import pt.itbio.cryptotracker.core.data.networking.safeCall
import pt.itbio.cryptotracker.core.domain.util.NetworkError
import pt.itbio.cryptotracker.core.domain.util.Result
import pt.itbio.cryptotracker.core.domain.util.map
import pt.itbio.cryptotracker.crypto.data.mappers.toCoin
import pt.itbio.cryptotracker.crypto.data.networking.dto.CoinsResponseDto
import pt.itbio.cryptotracker.crypto.domain.Coin
import pt.itbio.cryptotracker.crypto.domain.CoinDataSource

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
}