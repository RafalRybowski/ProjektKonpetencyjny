package pl.lodz.project.publications.publication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.publications_fragment.*
import pl.lodz.project.R

class PublicationsFragment: Fragment(), Publications.View {

    private val presenter by lazy {
        PublicationsPresenter(this)
    }

    val args: PublicationsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.publications_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewCreated(args.publication)
    }

    override fun setTitle(title: String) {
        titleText.text = title
    }

    override fun setPlace(place: String) {
        placeText.text = place
    }

    override fun setDate(date: String) {
        dateText.text = date
    }

    override fun setISBN(isbn: String) {
        isbnText.text = isbn
    }

    override fun setAuthors(authors: String) {
        authorsText.text = authors
    }
}