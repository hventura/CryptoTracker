package pt.itbio.cryptotracker.crypto.presentation.coin_list

import pt.itbio.cryptotracker.crypto.presentation.models.CoinUi

sealed interface CoinListAction {
    data class OnCoinClick(val coinUi: CoinUi): CoinListAction
    data object OnRefresh: CoinListAction
}