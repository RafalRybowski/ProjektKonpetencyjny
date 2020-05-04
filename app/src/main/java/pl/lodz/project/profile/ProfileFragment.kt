package pl.lodz.project.profile

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.profile_fragment.*
import pl.lodz.project.R
import pl.lodz.project.utils.adapters.PublicationsAdapter
import pl.lodz.project.utils.remote.publications.Publication

class ProfileFragment : Fragment(), Profile {

    private val presenter by lazy {
        ProfilePresenter(this)
    }
    val listAdapter: PublicationsAdapter = PublicationsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.profile_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerProfile.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = listAdapter

        }
        presenter.onCreate()
    }

    override fun setImage(url: Uri) {
        Glide.with(requireContext()).load(url).into(profileImage)
    }

    override fun setRecyclerView(publications: List<Publication>) {
        listAdapter.setData(publications)
        listAdapter.notifyDataSetChanged()
    }

    override fun setName(name: String) {
        nameProfile.text = name
    }

    override fun setSurname(surname: String) {
        surnameProfile.text = surname
    }

    override fun setDegree(degree: String) {
        degreeProfile.text = degree
    }

    override fun setPhone(phone: String) {
        phoneProfileInfo.text.clear()
        phoneProfileInfo.text.append(phone)
    }

    override fun setPosition(position: String) {
        positionProfileInfo.text = position
    }

    override fun setCounterPublication(counterPublications: Int) {
        counterPublicationsProfileInfo.text = counterPublications.toString()
    }
}