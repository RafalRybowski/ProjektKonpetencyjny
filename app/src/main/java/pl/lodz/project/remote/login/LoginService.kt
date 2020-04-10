package pl.lodz.project.remote.login

import retrofit2.http.Field
import retrofit2.http.POST

interface LoginService {

    @POST("/login")
    suspend fun login(
        @Field("login") login: String,
        @Field("password") password: String
    ): LoginResponse
}