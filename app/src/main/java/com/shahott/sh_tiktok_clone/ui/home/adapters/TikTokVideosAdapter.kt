package com.shahott.sh_tiktok_clone.ui.home.adapters

import android.animation.ObjectAnimator
import android.graphics.Color
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.widget.ImageView
import android.widget.TextView
import android.widget.VideoView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import com.shahott.sh_tiktok_clone.R
import com.shahott.sh_tiktok_clone.models.Video
import com.shahott.sh_tiktok_clone.ui.component.VerticalViewPager

class TikTokVideosAdapter(private val videos: List<Video>) : PagerAdapter() {

    private val videoViews = mutableListOf<VideoView>()
    private var isSoundOn = true
    private var myMediaPlayer: MediaPlayer? = null

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        isSoundOn=true
        val itemView = LayoutInflater.from(container.context).inflate(
            R.layout.video_item, container, false
        )
        val video = videos[position]
        val videoView = itemView.findViewById<VideoView>(R.id.vid_view)
        val videoPath = "android.resource://" + "com.shahott.sh_tiktok_clone" + "/${video.video}"
        videoView.setVideoPath(videoPath)
        videoView.setBackgroundColor(Color.TRANSPARENT)

        bindView(itemView, video)
        videoViews.add(videoView)
        container.addView(itemView)
        return itemView
    }

    private fun bindView(itemView: View, video: Video) {
        val imgUser = itemView.findViewById<ImageView>(R.id.sh_user_image)
        imgUser.setImageResource(video.userImage)

        val reacts = itemView.findViewById<TextView>(R.id.txt_reacts)
        val comments = itemView.findViewById<TextView>(R.id.txt_comments)
        val shares = itemView.findViewById<TextView>(R.id.txt_shares)

        reacts.text = video.likes.toString()
        comments.text = video.comments.toString()
        shares.text = video.shares.toString()

        val musicName = itemView.findViewById<TextView>(R.id.txt_music_name)
        musicName.text = video.audio

        val title = itemView.findViewById<TextView>(R.id.txt_video_caption)
        title.text = video.caption

        val userName = itemView.findViewById<TextView>(R.id.txt_user_name)
        userName.text = "@${video.username.toLowerCase()}"


        val parent = itemView.findViewById<ConstraintLayout>(R.id.views_parent)
        val sound = itemView.findViewById<ImageView>(R.id.img_sound)
        val rotator = ObjectAnimator.ofFloat(sound, View.ROTATION, 0f, 360f)
        rotator.repeatCount = Animation.INFINITE
        rotator.duration = 1500
        rotator.start()


        parent.setOnClickListener {

            isSoundOn = !isSoundOn
            if (isSoundOn) {
                myMediaPlayer?.start()
                myMediaPlayer?.setVolume(1f, 1f)
                rotator.resume()
            } else {
                myMediaPlayer?.pause()
                myMediaPlayer?.setVolume(0f, 0f)
                rotator.pause()
            }
        }

    }


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return videos.size
    }

    override fun finishUpdate(container: ViewGroup) {
        super.finishUpdate(container)
        val currentItem = (container as VerticalViewPager).currentItem
        for (i in videoViews.indices) {
            val videoView = videoViews[i]
            if (i == currentItem) {
                if (!videoView.isPlaying) {
                    try {
                        val mediaPlayerField =
                            VideoView::class.java.getDeclaredField("mMediaPlayer")
                        mediaPlayerField.isAccessible = true
                        myMediaPlayer = mediaPlayerField.get(videoView) as MediaPlayer?
                        if (isSoundOn) {
                            myMediaPlayer?.setVolume(1f, 1f)
                        } else {
                            myMediaPlayer?.setVolume(0f, 0f)
                        }
                    } catch (_: Exception) {
                    }
                    videoView.seekTo(0)
                    videoView.start()
                }
            } else {
                videoView.pause()
            }
        }

        myMediaPlayer?.setOnCompletionListener {
            val nextPage = currentItem + 1
            if (nextPage < videos?.count() ?: 0) {
                currentItem + 1
                (container).setCurrentItem(nextPage, true)
            }
            isSoundOn = true
        }

    }


}