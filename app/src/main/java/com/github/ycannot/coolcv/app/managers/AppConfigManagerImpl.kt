package com.github.ycannot.coolcv.app.managers

import com.github.ycannot.coolcv.app.managers.interfaces.AppConfigManager
import com.github.ycannot.core.managers.interfaces.PreferenceManager
import com.github.ycannot.data.models.Cv

class AppConfigManagerImpl(private val preferenceManager: PreferenceManager) : AppConfigManager {
    override var cv: Cv
        get() = preferenceManager.read(PREF_KEY_CV, Cv())
        set(value) {
            preferenceManager.write(PREF_KEY_CV, value)
        }

    companion object {
        private const val PREF_KEY_CV = "PREF_KEY_CV"
    }
}