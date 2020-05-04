package pl.lodz.project.utils.remote.publications

import retrofit2.http.GET
import retrofit2.http.Path

interface PublicationsService {
    @GET("publications/{idAccount}")
    suspend fun getPublications(
        @Path("idAccount") idAccount: Int
    ): List<Publication>
}