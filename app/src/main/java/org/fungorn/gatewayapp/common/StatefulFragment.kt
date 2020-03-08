package org.fungorn.gatewayapp.common

import androidx.fragment.app.Fragment

abstract class StatefulFragment<State : ViewState> : Fragment() {
    abstract fun render(state: State)
}