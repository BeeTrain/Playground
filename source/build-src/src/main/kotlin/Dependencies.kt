@file:Suppress("MemberVisibilityCanBePrivate")

object Plugins {
    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kotlinAndroid = "kotlin-android"
}

object AndroidDependencies {
    object Versions {
        const val appCompat = "1.4.1"
        const val core = "1.7.0"
        const val material = "1.5.0"
        const val constraintLayout = "2.1.3"
        const val lifecycle = "2.4.1"
        const val recyclerView = "1.2.1"
    }

    const val coreKtx = "androidx.core:core-ktx:${Versions.core}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    const val lifecycle = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
}