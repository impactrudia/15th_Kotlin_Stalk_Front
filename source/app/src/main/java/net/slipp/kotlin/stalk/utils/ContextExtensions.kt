package net.slipp.kotlin.stalk.utils

import android.content.Context
import android.widget.Toast

open class ContextExtensions {

    open fun Context.toast(message: CharSequence) =
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

