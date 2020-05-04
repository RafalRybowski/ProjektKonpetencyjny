package pl.lodz.project.utils.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.publication_list_layout.view.*
import pl.lodz.project.R
import pl.lodz.project.utils.remote.publications.Publication

class PublicationsAdapter : RecyclerView.Adapter<PublicationsAdapter.ViewHolder>() {

    private var publications: List<Publication>? = null

    fun setData(publications: List<Publication>) {
        this.publications = publications
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        val view = inflate.inflate(R.layout.publication_list_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = publications?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        publications?.get(position)?.let {
            holder.setPublication(it)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setPublication(publication: Publication) {
            itemView.publicationData.text = publication.tile
            itemView.publicationData.text = publication.date
        }
    }
}