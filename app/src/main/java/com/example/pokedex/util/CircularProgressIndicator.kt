package com.example.pokedex.util

import com.google.android.material.progressindicator.CircularProgressIndicator

fun CircularProgressIndicator.showView() {
    visibility = CircularProgressIndicator.VISIBLE
}

fun CircularProgressIndicator.hideView() {
    visibility = CircularProgressIndicator.GONE
}