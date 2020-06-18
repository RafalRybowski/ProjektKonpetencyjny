package pl.lodz.project.publications.publication

import pl.lodz.project.utils.remote.publications.Publication

interface Publications {
    interface View {
        fun setTitle(title: String)
        fun setPlace(place: String)
        fun setDate(date: String)
        fun setISBN(isbn: String)
        fun setAuthors(authors: String)

    }
    interface Presenter {
        fun onViewCreated(publication: Publication)
    }
}