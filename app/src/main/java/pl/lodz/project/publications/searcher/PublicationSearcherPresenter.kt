package pl.lodz.project.publications.searcher

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pl.lodz.project.utils.remote.RetrofitClient
import pl.lodz.project.utils.remote.publications.PublicationsService
import retrofit2.HttpException
import kotlin.coroutines.CoroutineContext

class PublicationSearcherPresenter(
    private val view: PublicationSearcher.View
) : CoroutineScope, PublicationSearcher.Presenter {

    override val coroutineContext: CoroutineContext = Dispatchers.IO
    private val service by lazy {
        RetrofitClient.getClient().create(PublicationsService::class.java)
    }

   override fun onButtonPressed(text: String) {
        launch {
            try {
                val pub = service.getPublications(text)
                withContext(Dispatchers.Main) {
                    view.setRecyclerView(pub)
                }
            } catch (exception: HttpException) {
                withContext(Dispatchers.Main) {
                    view.showError(exception.message())
                }
            }
        }
    }
}