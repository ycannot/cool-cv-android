package com.github.ycannot.data.repositories.local

import com.github.ycannot.core.extensions.cast
import com.github.ycannot.core.managers.interfaces.RawResourceManager
import com.github.ycannot.data.R
import com.github.ycannot.data.models.Cv
import com.github.ycannot.data.services.CvServiceLocal

class CvRepository(
    private val rawResourceManager: RawResourceManager
) : CvServiceLocal {
    override fun getCvFromResources(): Cv? {
        return rawResourceManager.getFileFromRaw(R.raw.cv).cast()
    }
}