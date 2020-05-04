package pl.lodz.project.profile

import android.net.Uri
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pl.lodz.project.ProjectApplication.Companion.serverUrl
import pl.lodz.project.utils.CurrentUser
import pl.lodz.project.utils.remote.RetrofitClient
import pl.lodz.project.utils.remote.publications.PublicationsService
import kotlin.coroutines.CoroutineContext

class ProfilePresenter(private val view: Profile) : CoroutineScope {

    override val coroutineContext: CoroutineContext = Dispatchers.IO

    fun onCreate(){
        val user = CurrentUser.getUser()
        view.setImage(Uri.parse(serverUrl + user.image))
        view.setName(user.name)
        view.setSurname(user.surname)
        view.setDegree(user.degree)
        view.setPhone(user.phone)
        view.setPosition(user.position)
        launch {
            getPublicationsList(user.userId)
        }
    }

    suspend fun getPublicationsList(userId: Int) {
        val service = RetrofitClient.getClient().create(PublicationsService::class.java)
        try {
            val publications = service.getPublications(userId)
            withContext(Dispatchers.Main){
                view.setCounterPublication(publications.size)
                view.setRecyclerView(publications)
            }
        }catch (e: Exception) {
            Log.i("dupe", "$e")
        }
    }
}