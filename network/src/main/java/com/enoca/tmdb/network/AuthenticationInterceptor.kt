package com.enoca.tmdb.network

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.net.HttpURLConnection
import javax.inject.Inject

class AuthenticationInterceptor @Inject constructor(
    private val sessionManager: SessionManager
): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        var accessToken = sessionManager.getAccessToken()
        val response = chain.proceed(newRequestWithAccessToken(accessToken, request))
        if (response.code() == HttpURLConnection.HTTP_UNAUTHORIZED) {
            return response
        }
        return chain.proceed(newRequestWithAccessToken(accessToken, request))
    }

    private fun newRequestWithAccessToken(accessToken: String?, request: Request): Request =
        request.newBuilder()
            .header("Authorization", "Bearer $accessToken")
            .build()
}