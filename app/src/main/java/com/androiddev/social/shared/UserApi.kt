package com.androiddev.social.shared

import com.androiddev.social.timeline.data.Account
import com.androiddev.social.timeline.data.Status
import retrofit2.http.*


interface UserApi {
    @GET("api/v1/timelines/home")
    suspend fun getTimeline(
        @Header("Authorization") authHeader: String?,
        @Query("limit") limit: String = "40",
        @Query("max_id") since:String?
    ): List<Status>

    @GET("api/v1/accounts/verify_credentials")
    suspend fun accountVerifyCredentials(
        @Header("Authorization") authHeader: String?,
    ): Account

}
