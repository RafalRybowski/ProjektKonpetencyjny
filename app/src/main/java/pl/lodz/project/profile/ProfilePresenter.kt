package pl.lodz.project.profile

import android.net.Uri
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pl.lodz.project.ProjectApplication.Companion.serverUrl
import pl.lodz.project.utils.CurrentUser
import pl.lodz.project.utils.remote.RetrofitClient
import pl.lodz.project.utils.remote.profile.ProfilePublication
import pl.lodz.project.utils.remote.profile.ProfileService
import pl.lodz.project.utils.remote.profile.ProfileUserInfo
import retrofit2.HttpException
import kotlin.coroutines.CoroutineContext

class ProfilePresenter(private val view: Profile.View) : CoroutineScope, Profile.Presenter {

    override val coroutineContext: CoroutineContext = Dispatchers.IO
    private val service by lazy {
        RetrofitClient.getClient().create(ProfileService::class.java)
    }

    override fun onCreate() {
        launch {
            try {
                val response = service.getProfile(CurrentUser.getUser())
                val user = response.rowProfile
                setUserProfile(user)
                response.rowsPub?.let {
                    setPublicationList(it)
                }
            } catch (e: HttpException) {
                withContext(Dispatchers.Main) {
                    view.onFailure("Cannot get profile information")
                }
            }
        }
    }

    private suspend fun setUserProfile(user: ProfileUserInfo) {
        withContext(Dispatchers.Main) {
            view.setName(user.IMIE)
            view.setSurname(user.NAZWISKO)
            user.NUMER_TELEFONU?.let {
                view.setPhone(it)
            }
            view.setPosition(user.NAZWA_TYPU_KONTA)
            view.setDegree(user.TYTUL)
            user.IMAGE?.let {
                view.setImage(Uri.parse("$serverUrl/$it"))
            }
        }
    }

    private suspend fun setPublicationList(publications: List<ProfilePublication>) {
        withContext(Dispatchers.Main) {
            view.setCounterPublication(publications.size)
            view.setRecyclerView(publications)
        }

    }
}