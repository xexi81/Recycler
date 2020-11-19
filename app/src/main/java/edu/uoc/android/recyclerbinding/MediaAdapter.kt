package edu.uoc.android.recyclerbinding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.uoc.android.recyclerbinding.databinding.ViewMediaItemBinding

class MediaAdapter (val mediaList: List<Media>): RecyclerView.Adapter<MediaAdapter.MediaHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MediaHolder {
        //val layoutInflater= LayoutInflater.from(parent.context)
        val binding = ViewMediaItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MediaHolder(binding)
    }

    override fun onBindViewHolder(holder: MediaHolder, position: Int) {
        holder.render(mediaList[position])
    }

    override fun getItemCount(): Int = mediaList.size

    class MediaHolder(private val binding: ViewMediaItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun render(media: Media) {
            with(binding) {
                txtNombre.text = media.name
            }
        }
    }
}