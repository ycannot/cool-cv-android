package com.github.ycannot.core.extensions

import com.google.gson.Gson

inline fun <reified T> String?.cast(): T? {
    return try {
        Gson().fromJson(this, T::class.java)
    } catch (e: Exception) {
        null
    }
}

fun <T> T?.serialize(): String? {
    return try {
        Gson().toJson(this)
    } catch (e: Exception) {
        null
    }
}
