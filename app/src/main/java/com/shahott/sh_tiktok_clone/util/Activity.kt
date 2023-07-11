package com.shahott.sh_tiktok_clone.util

import android.app.Activity
import android.graphics.Color
import android.util.Log
import android.view.WindowManager
import androidx.core.content.ContextCompat

fun Activity.showContentAboveStatusBar(color: Int = -1) {
    try {
        window.apply {
            statusBarColor = if (color != -1) Color.TRANSPARENT else color
            setFlags(
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
            )
        }
    } catch (e: Exception) {
        Log.e("ActivityExtensions", "showContentAboveStatusBar: ${e.localizedMessage}")
    }
}

fun Activity.showContentNormallyUnderStatusBar(color: Int) {
    window.apply {
        statusBarColor = ContextCompat.getColor(this@showContentNormallyUnderStatusBar, color)
        clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
    }
}