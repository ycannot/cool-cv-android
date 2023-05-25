package com.github.ycannot.core.managers.interfaces

interface PreferenceManager {
    fun <T> read(name: String, defaultValue: T): T

    fun <T> write(name: String, value: T)

    fun remove(name: String, callBack: (() -> Unit)? = null)

    fun clear(callBack: (() -> Unit)? = null)
}