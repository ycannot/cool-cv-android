package com.github.ycannot.plugins

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

object AppConfig {
    const val ApplicationId = "com.github.ycannot.coolcv"
    const val CompileSdk = 33
    const val MinSdk = 24
    const val TargetSdk = 33
    const val TestInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    private const val VERSION_MAJOR = 1
    private const val VERSION_MINOR = 0
    private const val VERSION_PATCH = 0

    const val VERSION_CODE = VERSION_MAJOR * 1000000 + VERSION_MINOR * 10000 + VERSION_PATCH * 100
    const val VERSION_NAME = "$VERSION_MAJOR.$VERSION_MINOR.$VERSION_PATCH"

    fun getVersionCode(isRelease: Boolean): Int {
        if (isRelease) {
            return VERSION_CODE
        }
        val dateFormat = SimpleDateFormat("MMddHHmm", Locale.ROOT)
        dateFormat.timeZone = TimeZone.getTimeZone("Europe/Istanbul")
        return dateFormat.format(Date()).toInt()
    }
}