package com.nepplus.secondhardpractice.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import kotlinx.android.parcel.Parcelize

//Retrofit에서 불러 오게 될 모델 클래스를 생성을 한다. (model)
//serialize 대신에 parcelize 사용할 것
@Parcelize
data class User(
    val avatar_url: String,
    val bio: String,
    val blog: String,
    val collaborators: Int,
    val company: String,
    val created_at: String,
    val disk_usage: Int,
    val email: String,
    val events_url: String,
    val followers: Int,
    val followers_url: String,
    val following: Int,
    val following_url: String,
    val gists_url: String,
    val gravatar_id: String,
    val hireable: Boolean,
    val html_url: String,
    val id: Int,
    val location: String,
    val login: String,
    val name: String,
    val node_id: String,
    val organizations_url: String,
    val owned_private_repos: Int,
    val private_gists: Int,
    val public_gists: Int,
    val public_repos: Int,
    val received_events_url: String,
    val repos_url: String,
    val site_admin: Boolean,
    val starred_url: String,
    val subscriptions_url: String,
    val total_private_repos: Int,
    val twitter_username: String,
    val two_factor_authentication: Boolean,
    val type: String,
    val updated_at: String,
    val url: String
) : Parcelable{

    //Recyclerview 구현시 각각의 데이터 비교를 한다.
    companion object{


        val DiffUtil = object : DiffUtil.ItemCallback<User>(){

            override fun areItemsTheSame(oldItem: User, newItem: User) = oldItem == newItem


            override fun areContentsTheSame(oldItem: User, newItem: User) = oldItem == newItem

        }
    }

}

//모델 클래스를 어떻게 데이터 반영할지 data class val item : List<User> = emptyList()
data class UserResponse(

    val item : List<User> = emptyList()
)