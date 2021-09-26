package com.nepplus.secondhardpractice.remotedatasource

import com.nepplus.secondhardpractice.model.UserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubAPI {
    //api.github.com/search/users/q?=blah

    //get방식으로 어느 사이트에 접근할지 결정하며
    //return값 userresponse로 한다.
    //suspend fun couroutine용 함수 생성
    @GET("search/users")
    suspend fun couroutineGetUsers(
        @Query("q") q: String?
    ) : UserResponse

}