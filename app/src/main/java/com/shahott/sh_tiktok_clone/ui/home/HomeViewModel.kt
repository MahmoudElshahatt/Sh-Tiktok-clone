package com.shahott.sh_tiktok_clone.ui.home

import androidx.lifecycle.ViewModel
import com.shahott.sh_tiktok_clone.R
import com.shahott.sh_tiktok_clone.models.Video

class HomeViewModel : ViewModel() {

    //Here we add fake data
    fun getTikTokVideos(): List<Video> {

        val post1 = Video(
            id = 1,
            username = "Mahmoud Elshahatt",
            userImage = R.drawable.img_profile,
            caption = "Lol this is fun",
            audio = "audio1.mp3",
            likes = 10,
            comments = 5,
            shares = 2,
            isVideo = true,
            video = R.raw.vid1,
        )

        val post2 = Video(
            id = 2,
            username = "Ahmed Emad",
            userImage = R.drawable.user1,
            caption = "Second post",
            audio = "audio2.mp3",
            likes = 15,
            comments = 7,
            shares = 3,
            video = R.raw.vid2
        )

        val post3 = Video(
            id = 3,
            username = "Ibrahim",
            userImage = R.drawable.user2,
            caption = "Third post",
            audio = "audio3.mp3",
            likes = 20,
            comments = 3,
            shares = 1,
            video = R.raw.vid6
        )

        val post4 = Video(
            id = 4,
            username = "Mahmoud Elsayed",
            userImage = R.drawable.user2,
            caption = "Fourth post",
            audio = "audio4.mp3",
            likes = 8,
            comments = 2,
            shares = 0,
            video = R.raw.vid4
        )

        val post5 = Video(
            id = 5,
            username = "Yaya",
            userImage = R.drawable.user5,
            caption = "Fifth post",
            audio = "audio5.mp3",
            likes = 12,
            comments = 4,
            shares = 1,
            video = R.raw.vid5
        )

        val post6 = Video(
            id = 6,
            username = "momo02",
            userImage = R.drawable.user6,
            caption = "Sixth post",
            audio = "audio6.mp3",
            likes = 5,
            comments = 1,
            shares = 0,
            video = R.raw.vid1
        )

        val post7 = Video(
            id = 7,
            username = "kaka",
            userImage = R.drawable.user7,
            caption = "Seventh post",
            audio = "audio7.mp3",
            likes = 6,
            comments = 3,
            shares = 1,
            video = R.raw.vid2
        )

        val post8 = Video(
            id = 8,
            username = "Hulk",
            userImage = R.drawable.user5,
            caption = "Eighth post",
            audio = "audio8.mp3",
            likes = 9,
            comments = 2,
            shares = 0,
            video = R.raw.vid3
        )

        val post9 = Video(
            id = 9,
            username = "FatBoy00",
            userImage = R.drawable.user7,
            caption = "Ninth post",
            audio = "audio9.mp3",
            likes = 11,
            comments = 5,
            shares = 2,
            video = R.raw.vid4
        )

        val post10 = Video(
            id = 10,
            username = "L_O_L",
            userImage = R.drawable.user2,
            caption = "Tenth post",
            audio = "audio10.mp3",
            likes = 14,
            comments = 7,
            shares = 3,
            video = R.raw.vid5
        )
        val postsList = mutableListOf<Video>()
        postsList.add(post1)
        postsList.add(post2)
        postsList.add(post3)
        postsList.add(post4)
        postsList.add(post5)
        postsList.add(post6)
        postsList.add(post7)
        postsList.add(post8)
        postsList.add(post9)
        postsList.add(post10)

        postsList.shuffle()

        return postsList
    }

}