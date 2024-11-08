package com.plcoding.cryptotracker.core.presentation.utils

import android.content.Context
import com.plcoding.cryptotracker.R
import com.plcoding.cryptotracker.core.domain.utils.NetworkError

fun NetworkError.toString(context: Context):String{
    val resId= when(this){
        NetworkError.NO_INTERNET -> R.string.no_internet
        NetworkError.PARSING_ERROR ->R.string.pasing_error
        NetworkError.BAD_REQUEST -> R.string.bad_request
        NetworkError.UNAUTHORIZED -> R.string.unauthorized
        NetworkError.FORBIDDEN -> R.string.forbidden
        NetworkError.NOT_FOUND -> R.string.not_found
        NetworkError.REQUEST_TIMEOUT -> R.string.rquest_timeout
        NetworkError.TOO_MANY_REQUESTS -> R.string.too_may_requests
        NetworkError.SERVER_ERROR -> R.string.server_error
        NetworkError.SERIALIZATION -> R.string.serialization
        NetworkError.UNKNOWN -> R.string.unknown
    }
    return context.getString(resId);
}