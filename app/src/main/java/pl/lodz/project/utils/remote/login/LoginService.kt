package pl.lodz.project.utils.remote.login

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginService {

    @FormUrlEncoded
    @POST("/login")
    suspend fun login(
        @Field("login") login: String,
        @Field("password") password: String
    ): LoginResponse
}