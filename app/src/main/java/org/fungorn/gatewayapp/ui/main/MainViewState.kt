package org.fungorn.gatewayapp.ui.main

import org.fungorn.gatewayapp.common.ViewState

data class MainViewState(
    val text: String = "",
    override val isLoading: Boolean = false,
    override val error: Throwable? = null
) : ViewState {
    constructor(initialText: String) : this(text = initialText)
    constructor(initialViewState: MainViewState) : this(
        text = initialViewState.text,
        isLoading = initialViewState.isLoading,
        error = initialViewState.error
    )
}