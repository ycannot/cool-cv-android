package com.github.ycannot.data.di

import com.github.ycannot.core.managers.interfaces.RawResourceManager
import com.github.ycannot.data.repositories.local.CvRepository
import com.github.ycannot.data.services.CvServiceLocal
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideCvRepositoryLocal(rawResourceManager: RawResourceManager): CvServiceLocal =
        CvRepository(rawResourceManager)
}