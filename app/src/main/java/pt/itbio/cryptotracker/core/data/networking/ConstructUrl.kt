package pt.itbio.cryptotracker.core.data.networking

import pt.itbio.cryptotracker.BuildConfig

fun constructUrl(url: String): String {
    return when {
        url.contains(BuildConfig.BASE_URL) -> url + "?apiKey=" + BuildConfig.COINCAP_API
        url.startsWith("/") -> BuildConfig.BASE_URL + url.drop(1) + "?apiKey=" + BuildConfig.COINCAP_API
        else -> BuildConfig.BASE_URL + url + "?apiKey=" + BuildConfig.COINCAP_API
    }
}