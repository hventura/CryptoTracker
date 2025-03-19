package pt.itbio.cryptotracker.core.data.networking

import io.ktor.client.statement.HttpResponse
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.coroutines.ensureActive
import kotlinx.serialization.SerializationException
import pt.itbio.cryptotracker.core.domain.util.NetworkError
import pt.itbio.cryptotracker.core.domain.util.Result
import kotlin.coroutines.coroutineContext

suspend inline fun <reified T> safeCall(call: () -> HttpResponse): Result<T, NetworkError> {
    val response = try {
        call()
    } catch (e: UnresolvedAddressException) {
        return Result.Error(NetworkError.NO_INTERNET)
    } catch (e: SerializationException) {
        return Result.Error(NetworkError.SERIALIZATION_ERROR)
    } catch (e: Exception) {
        coroutineContext.ensureActive()
        return Result.Error(NetworkError.UNKNOWN)
    }

    return responseRoResult(response)

}