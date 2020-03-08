package org.fungorn.gatewayapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import org.fungorn.gatewayapp.data.actions.MainAction
import org.fungorn.gatewayapp.data.dispatchers.MainDispatcher
import org.fungorn.gatewayapp.domain.Result

class MainViewModel(
    mainDispatcher: MainDispatcher
) : ViewModel() {
    private val mainViewState: MainViewState = MainViewState()

    val mainState: LiveData<MainViewState> =
        Transformations.map(mainDispatcher.dispatch(MainAction.GetGreetings)) {
            when (it) {
                is Result.Loading -> mainViewState.copy(isLoading = true)
                is Result.Success -> mainViewState.copy(text = it.data.text, isLoading = false)
                is Result.Failure -> mainViewState.copy(error = it.error, isLoading = false)
            }
        }
}
