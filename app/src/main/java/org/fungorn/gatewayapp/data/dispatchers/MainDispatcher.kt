package org.fungorn.gatewayapp.data.dispatchers

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import org.fungorn.gatewayapp.common.Dispatcher
import org.fungorn.gatewayapp.data.actions.MainAction
import org.fungorn.gatewayapp.data.repositories.MainRepository
import org.fungorn.gatewayapp.domain.Result
import org.fungorn.gatewayapp.ui.main.MainViewState

class MainDispatcher(
    private val mainRepository: MainRepository
) : Dispatcher<MainAction, MainViewState> {
    override fun dispatch(action: MainAction): LiveData<Result<MainViewState>> = liveData {
        when (action) {
            is MainAction.GetGreetings -> {
                emit(Result.Loading<MainViewState>())
                emit(getGateway())
            }
        }
    }

    private suspend fun getGateway(): Result<MainViewState> {
        try {
            val response = mainRepository.getGateway().await()
            if (response.isSuccessful) {
                return Result.Success(
                    MainViewState(response.body()?.title ?: "")
                )
            }
        } catch (t: Throwable) {
            return Result.Failure(t)
        }

        return Result.Failure(IllegalStateException("Failed to receive Greetings"))
    }
}