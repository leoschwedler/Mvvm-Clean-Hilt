package com.example.projecthilt.di

import android.app.Application
import dagger.Provides
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApplication: Application() {


}