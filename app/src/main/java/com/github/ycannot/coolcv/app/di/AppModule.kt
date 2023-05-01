package com.github.ycannot.coolcv.app.di

import com.github.ycannot.coolcv.app.managers.AppConfigManagerImpl
import com.github.ycannot.coolcv.app.managers.interfaces.AppConfigManager
import com.github.ycannot.core.managers.interfaces.PreferenceManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideAppConfigManager(preferenceManager: PreferenceManager): AppConfigManager =
        AppConfigManagerImpl(preferenceManager)
}