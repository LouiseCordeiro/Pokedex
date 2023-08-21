package com.example.pokedex

import android.app.Application
import com.example.pokedex.di.inject

class Pokedex : Application() {

    override fun onCreate() {
        super.onCreate()
        inject()
    }
}