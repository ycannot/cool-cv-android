package com.github.ycannot.core.managers

import android.content.Context
import androidx.annotation.RawRes
import com.github.ycannot.core.managers.interfaces.RawResourceManager

class RawResourceManagerImpl(
    private val appContext: Context
) : RawResourceManager {
    override fun getFileFromRaw(@RawRes resourceId: Int): String =
        appContext.resources.openRawResource(resourceId)
            .bufferedReader()
            .use { it.readText() }

}