package org.fungorn.gatewayapp.data.repositories

import org.fungorn.gatewayapp.data.api.GatewayService

class MainRepository(
    private val gatewayService: GatewayService
) {
    fun getGateway() = gatewayService.getGateway()
}