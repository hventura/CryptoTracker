package pt.itbio.cryptotracker.crypto.presentation.coin_list

import pt.itbio.cryptotracker.core.domain.util.NetworkError

sealed interface CoinListEvent {
    data class Error(val error: NetworkError) : CoinListEvent
}