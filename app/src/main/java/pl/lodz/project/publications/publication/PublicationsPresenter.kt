package pl.lodz.project.publications.publication

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pl.lodz.project.utils.remote.RetrofitClient
import pl.lodz.project.utils.remote.authors.AuthorsService
import pl.lodz.project.utils.remote.publications.Publication
import pl.lodz.project.utils.remote.publications.PublicationsService
import kotlin.coroutines.CoroutineContext

class PublicationsPresenter(private val view: Publications.View) : CoroutineScope,
    Publications.Presenter {

    override val coroutineContext: CoroutineContext = Dispatchers.IO
    private val service by lazy {
        RetrofitClient.getClient().create(AuthorsService::class.java)
    }

    override fun onViewCreated(publication: Publication) {
        view.setISBN(publication.ISBN)
        view.setDate(publication.date)
        view.setPlace(publication.place)
        view.setTitle(publication.title)
        getAuthors(publication.idAuthors)
    }

    private fun getAuthors(idAuthors: Int) {
        launch {
            try {
                val response = service.getProfile(idAuthors)
                withContext(Dispatchers.Main) {
                    view.setAuthors(response.toString())
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    view.setAuthors("empty")
                }
            }
        }
    }
}