package org.fungorn.gatewayapp.common

interface ViewState {
    val isLoading: Boolean
    val error: Throwable?
}