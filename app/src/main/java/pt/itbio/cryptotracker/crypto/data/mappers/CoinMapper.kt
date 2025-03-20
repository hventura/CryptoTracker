package pt.itbio.cryptotracker.crypto.data.mappers

import pt.itbio.cryptotracker.crypto.data.networking.dto.CoinDto
import pt.itbio.cryptotracker.crypto.data.networking.dto.CoinPriceDto
import pt.itbio.cryptotracker.crypto.domain.Coin
import pt.itbio.cryptotracker.crypto.domain.CoinPrice
import java.time.Instant
import java.time.ZoneId

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        rank = rank,
        symbol = symbol,
        name = name,
        marketCapUsd = marketCapUsd,
        priceUsd = priceUsd,
        changePercent24Hr = changePercent24Hr ?: 0.0
    )
}

fun CoinPriceDto.toCoinPrice(): CoinPrice {
    return CoinPrice(
        priceUsd = priceUsd,
        dateTime = Instant
            .ofEpochMilli(time)
            .atZone(ZoneId.systemDefault())
    )
}