package pl.lodz.project.utils.remote.authors

import retrofit2.http.GET
import retrofit2.http.Path

interface AuthorsService {
    @GET("/authors/{id}")
    suspend fun getProfile(@Path("id") id: Int): List<AuthorsResponse>
}