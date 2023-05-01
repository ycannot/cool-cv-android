package com.github.ycannot.core.di

import android.content.Context
import com.github.ycannot.core.managers.PreferenceManagerImpl
import com.github.ycannot.core.managers.RawResourceManagerImpl
import com.github.ycannot.core.managers.interfaces.PreferenceManager
import com.github.ycannot.core.managers.interfaces.RawResourceManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {

    @Provides
    fun providePreferenceManager(@ApplicationContext appContext: Context): PreferenceManager =
        PreferenceManagerImpl(appContext)

    @Provides
    fun provideRawResourceManager(@ApplicationContext appContext: Context): RawResourceManager =
        RawResourceManagerImpl(appContext)
}