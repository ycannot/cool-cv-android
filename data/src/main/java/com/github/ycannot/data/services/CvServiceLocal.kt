package com.github.ycannot.data.services

import com.github.ycannot.data.models.Cv

interface CvServiceLocal {
    fun getCvFromResources(): Cv?
}