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


    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        val interceptedTouch = super.onInterceptTouchEvent(ev)
        swapXY(ev)
        return interceptedTouch
    }


    override fun onTouchEvent(ev: MotionEvent): Boolean {
        return super.onTouchEvent(swapXY(ev))
    }

    private fun swapXY(ev: MotionEvent): MotionEvent {
        val width = width.toFloat()
        val height = height.toFloat()

        val newX = ev.y / height * width
        val newY = ev.x / width * height

        ev.setLocation(newX, newY)

        return ev
    }


    private inner class VerticalPageTransformer : PageTransformer {
        override fun transformPage(view: View, position: Float) {
            val pageWidth = view.width
            val pageHeight = view.height

            when {
                position < -1 -> view.alpha = 0f
                position <= 1 -> {
                    view.alpha = 1f

                    view.translationX = pageWidth * -position
                    view.translationY = pageHeight * position

                    view.scaleX = 1f
                    view.scaleY = 1f
                }
                else -> view.alpha = 0f
            }
        }
    }

}