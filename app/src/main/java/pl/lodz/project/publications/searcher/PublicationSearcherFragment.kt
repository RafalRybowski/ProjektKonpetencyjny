package pl.lodz.project.publications.searcher

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.publication_searcher_fragment.*
import pl.lodz.project.R
import pl.lodz.project.navigation.getNavController
import pl.lodz.project.utils.adapters.PublicationsAdapter
import pl.lodz.project.utils.remote.publications.Publication

class PublicationSearcherFragment : Fragment(),
    PublicationSearcher.View {

    private val presenter by lazy {
        PublicationSearcherPresenter(this)
    }

    private val listAdapter: PublicationsAdapter by lazy {
        PublicationsAdapter(requireActivity().getNavController())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.publication_searcher_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        publicationRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = listAdapter
        }
        publicationSearchButton.setOnClickListener {
            presenter.onButtonPressed(publicationSearchEdit.text.toString())
        }
    }

    override fun setRecyclerView(publications: List<Publication>) {
        listAdapter.setData(publications)
        listAdapter.notifyDataSetChanged()
    }

    override fun showError(error: String) {
        Toast.makeText(requireContext(), error, Toast.LENGTH_LONG).show()
    }
}