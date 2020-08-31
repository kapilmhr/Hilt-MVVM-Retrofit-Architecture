package app.frantic.hilt.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.frantic.hilt.R
import app.frantic.hilt.network.API_URL.PHOTOS
import app.frantic.hilt.ui.model.Flower
import coil.load
import kotlinx.android.synthetic.main.item_layout.view.*

class MainAdapter(
    private val flowers: ArrayList<Flower>
) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(flower: Flower) {
            itemView.textViewUserName.text = flower.name
            itemView.textViewUserEmail.text = flower.category
            itemView.imageViewAvatar.load("$PHOTOS${flower.photo}"){
                crossfade(true)
                placeholder(R.drawable.ic_launcher_background)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout, parent,
                false
            )
        )

    override fun getItemCount(): Int = flowers.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(flowers[position])

    fun addData(list: List<Flower>) {
        flowers.addAll(list)
    }
}