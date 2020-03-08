package org.fungorn.gatewayapp.data.api

import kotlinx.coroutines.Deferred
import org.fungorn.gatewayapp.domain.models.Gateway
import retrofit2.Response
import retrofit2.http.GET

interface GatewayService {
    @GET("/gateway/1")
    fun getGateway(): Deferred<Response<Gateway>>
}