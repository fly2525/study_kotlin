package com.example.model_common.common

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes


class ToastUtils {
    companion object {
        @JvmStatic
        fun showToast(context: Context, msg: String) {
            if (msg.isNullOrEmpty()) {
                return
            }
            Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
        }

        @JvmStatic
        fun showToast(context: Context, @StringRes resid: Int) {

            Toast.makeText(context, resid, Toast.LENGTH_LONG).show()
        }
    }
}