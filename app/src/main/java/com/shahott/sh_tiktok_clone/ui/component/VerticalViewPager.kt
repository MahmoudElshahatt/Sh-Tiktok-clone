package com.shahott.sh_tiktok_clone.ui.component

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.viewpager.widget.ViewPager

class VerticalViewPager(
    context: Context,
    attributeSet: AttributeSet?
) : ViewPager(context, attributeSet) {


    init {
        setPageTransformer(true, VerticalPageTransformer())
        overScrollMode = OVER_SCROLL_NEVER
    }

    private fun swapXY(event: MotionEvent): MotionEvent {
        val newX = event.y / height * width
        val newY = event.x / width * height
        event.setLocation(newX, newY)
        return event
    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        val intercepted = super.onInterceptTouchEvent(swapXY(ev))
        swapXY(ev)
        return intercepted
    }

    override fun onTouchEvent(ev: MotionEvent): Boolean {
        return super.onTouchEvent(swapXY(ev))
    }

    private inner class VerticalPageTransformer : PageTransformer {

        private val MIN_SCALE = 0.75f


        override fun transformPage(view: View, position: Float) {
            val pageWidth = view.width
            val pageHeight = view.height

            when {
                position < -1 -> {
                    view.alpha = 0f
                }
                position <= 1 -> {
                    view.alpha = 1f

                    view.translationX = pageWidth * -position
                    val yPosition = position * pageHeight
                    view.translationY = yPosition

                    val scaleFactor = MIN_SCALE + (1 - MIN_SCALE) * (1 - Math.abs(position))
                    view.scaleX = scaleFactor
                    view.scaleY = scaleFactor
                }
                else -> {
                    view.alpha = 0f
                }
            }
        }
    }
}