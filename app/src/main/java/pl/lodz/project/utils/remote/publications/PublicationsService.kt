package pl.lodz.project.utils.remote.publications

import retrofit2.http.GET
import retrofit2.http.Path

interface PublicationsService {
    @GET("/publications/{search}")
    suspend fun getPublications(@Path("search") search: String): List<Publication>
}