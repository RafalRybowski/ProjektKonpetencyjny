package pl.lodz.project.profile

import android.net.Uri
import pl.lodz.project.utils.remote.publications.Publication

interface Profile {
    fun setName(name: String)
    fun setSurname(surname: String)
    fun setDegree(degree: String)
    fun setPhone(phone: String)
    fun setPosition(position: String)
    fun setCounterPublication(counterPublications: Int)
    fun setImage(url: Uri)
    fun setRecyclerView(publications: List<Publication>)
}