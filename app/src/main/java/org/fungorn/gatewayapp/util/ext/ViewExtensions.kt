package org.fungorn.gatewayapp.util.ext

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

fun View.clicks(): Flow<View> = callbackFlow {
    val listener = View.OnClickListener { offer(this@clicks) }
    setOnClickListener(listener)
    awaitClose {
        setOnClickListener(null)
    }
}

fun EditText.textChanges(): Flow<String> = callbackFlow {
    val listener = object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) = Unit

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            offer(p0.toString())
        }
    }
    addTextChangedListener(listener)
    awaitClose {
        removeTextChangedListener(listener)
    }
}