package com.github.ycannot.core.managers

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.github.ycannot.core.extensions.cast
import com.github.ycannot.core.extensions.serialize
import com.github.ycannot.core.managers.interfaces.PreferenceManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.Exception

@Suppress("UNCHECKED_CAST")
class PreferenceManagerImpl(private val appContext: Context) : PreferenceManager {
    companion object {
        private const val SHARED_PREF_NAME = "COOL_CV_PREFS"
    }

    private val preferenceManager = getSecureSharedPref()
    private fun getSecureSharedPref(): SharedPreferences {
        val masterKey = MasterKey.Builder(appContext, MasterKey.DEFAULT_MASTER_KEY_ALIAS)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()

        return EncryptedSharedPreferences.create(
            appContext,
            SHARED_PREF_NAME,
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    override fun <T> read(name: String, defaultValue: T): T {
        return try {
            when (defaultValue) {
                is Int -> preferenceManager.getInt(name, defaultValue)
                is Long -> preferenceManager.getLong(name, defaultValue)
                is String -> preferenceManager.getString(name, defaultValue)
                is Boolean -> preferenceManager.getBoolean(name, defaultValue)
                else -> preferenceManager.getString(name, "").cast()
            } as T
        } catch (e: Exception) {
            defaultValue
        }

    }

    override fun <T> write(name: String, value: T) {
        preferenceManager.edit().also {
            when (value) {
                is Int -> it.putInt(name, value)
                is Long -> it.putLong(name, value)
                is String -> it.putString(name, value)
                is Boolean -> it.putBoolean(name, value)
                else -> it.putString(name, value.serialize())
            }
            it.apply()
        }

    }

    override fun remove(name: String, callBack: (() -> Unit)?) {
        preferenceManager.edit().also {
            it.remove(name)
            it.apply()
            callBack?.invoke()
        }
    }

    override fun clear(callBack: (() -> Unit)?) {
        preferenceManager.edit().clear().apply()
    }
}