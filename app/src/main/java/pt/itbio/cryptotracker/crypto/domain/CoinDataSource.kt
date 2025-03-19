package pt.itbio.cryptotracker.crypto.domain

import pt.itbio.cryptotracker.core.domain.util.NetworkError
import pt.itbio.cryptotracker.core.domain.util.Result

interface CoinDataSource {
    suspend fun getCoins(): Result<List<Coin>, NetworkError>
}