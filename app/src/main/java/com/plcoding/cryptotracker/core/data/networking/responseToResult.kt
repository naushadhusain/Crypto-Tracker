

import com.plcoding.cryptotracker.core.domain.utils.NetworkError
import io.ktor.client.call.NoTransformationFoundException
import io.ktor.client.call.body
import com.plcoding.cryptotracker.core.domain.utils.Result
import io.ktor.client.statement.HttpResponse

suspend inline fun <reified T> responseToResult(response: HttpResponse): Result<T, NetworkError> {
    return when (response.status.value) {
        // Successful responses (2xx)
        in 200..299 -> {
            try {
                Result.Success(response.body<T>())
            } catch (e: NoTransformationFoundException) {
                Result.Error(NetworkError.SERIALIZATION)
            } catch (e: Exception) { // Handle other possible exceptions during body parsing
                Result.Error(NetworkError.PARSING_ERROR)
            }
        }

        // Client errors
        400 -> Result.Error(NetworkError.BAD_REQUEST)
        401 -> Result.Error(NetworkError.UNAUTHORIZED)
        403 -> Result.Error(NetworkError.FORBIDDEN)
        404 -> Result.Error(NetworkError.NOT_FOUND)
        408 -> Result.Error(NetworkError.REQUEST_TIMEOUT)
        429 -> Result.Error(NetworkError.TOO_MANY_REQUESTS)

        // Server errors
        in 500..599 -> Result.Error(NetworkError.SERVER_ERROR)

        // Network issues or unknown status codes
        else -> Result.Error(NetworkError.UNKNOWN)
    }
}
