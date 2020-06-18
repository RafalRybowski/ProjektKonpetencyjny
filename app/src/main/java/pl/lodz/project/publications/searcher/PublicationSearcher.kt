package pl.lodz.project.publications.searcher

import pl.lodz.project.utils.remote.publications.Publication

interface PublicationSearcher {
    interface View {
        fun setRecyclerView(publications: List<Publication>)
        fun showError(error: String)
    }
    interface Presenter {

        fun onButtonPressed(text: String)
    }
}