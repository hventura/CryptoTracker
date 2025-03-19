package pt.itbio.cryptotracker.di

import io.ktor.client.engine.cio.CIO
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module
import pt.itbio.cryptotracker.core.data.networking.HttpClientFactory
import pt.itbio.cryptotracker.crypto.data.networking.RemoteCoinDataSource
import pt.itbio.cryptotracker.crypto.domain.CoinDataSource
import pt.itbio.cryptotracker.crypto.presentation.coin_list.CoinListViewModel

val appModule = module {
    single { HttpClientFactory.create(CIO.create()) }
    singleOf(::RemoteCoinDataSource).bind<CoinDataSource>()

    viewModelOf(::CoinListViewModel)
}