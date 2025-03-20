package pt.itbio.cryptotracker.crypto.data.networking.dto

import kotlinx.serialization.Serializable

@Serializable
data class CoinPriceResponseDto(
    val data: List<CoinPriceDto>
)
