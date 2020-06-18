package pl.lodz.project.utils.remote.profile

import retrofit2.http.GET
import retrofit2.http.Path

interface ProfileService {
    @GET("/profile/{id}")
    suspend fun getProfile(@Path("id") id: Int): ProfileResponse
}