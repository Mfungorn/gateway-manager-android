package org.fungorn.gatewayapp.common

import androidx.lifecycle.LiveData
import org.fungorn.gatewayapp.domain.Result

interface Dispatcher<A : Action, S : ViewState> {
    fun dispatch(action: A): LiveData<Result<S>>
}