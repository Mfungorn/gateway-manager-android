package org.fungorn.gatewayapp.data.actions

import org.fungorn.gatewayapp.common.Action

sealed class MainAction : Action {
    object GetGreetings : MainAction()
}