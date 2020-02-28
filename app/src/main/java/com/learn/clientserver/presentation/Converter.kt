package com.learn.clientserver.presentation

import android.widget.EditText
import androidx.databinding.InverseMethod

object Converter {

    @JvmStatic fun stringToInt(value: String): Int {
        if(value != null && value.isNotEmpty()) {
            return Integer.parseInt(value)
        }
        return 0
    }

    @InverseMethod("stringToInt")
    @JvmStatic fun intToString(value: Int): String {
        return ""+value
    }
}