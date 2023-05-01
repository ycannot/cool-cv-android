package com.github.ycannot.core.managers.interfaces

import androidx.annotation.RawRes

interface RawResourceManager {
    fun getFileFromRaw(@RawRes resourceId: Int): String?
}