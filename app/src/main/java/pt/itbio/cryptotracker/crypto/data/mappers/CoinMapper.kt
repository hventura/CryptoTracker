package pt.itbio.cryptotracker.crypto.data.mappers

import pt.itbio.cryptotracker.crypto.data.networking.dto.CoinDto
import pt.itbio.cryptotracker.crypto.domain.Coin

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        rank = rank,
        symbol = symbol,
        name = name,
        marketCapUsd = marketCapUsd,
        priceUsd = priceUsd,
        changePercent24Hr = changePercent24Hr
    )
}