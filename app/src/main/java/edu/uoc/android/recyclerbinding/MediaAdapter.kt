package edu.uoc.android.recyclerbinding

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import edu.uoc.android.recyclerbinding.databinding.ViewMediaItemBinding

class MediaAdapter (private val mediaList: List<Media>): RecyclerView.Adapter<MediaAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ViewMediaItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.render(mediaList[position])
    }

    override fun getItemCount(): Int = mediaList.size

    class ViewHolder(private val binding: ViewMediaItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun render(media: Media) {
            with(binding) {
                txtNombre.text = media.title
                Glide.with(mediaThumb.context).load(media.url).into(mediaThumb)

                // Toast sobre viewHolder en extensions.kt
                itemView.setOnClickListener{
                    toast(txtNombre.text.toString(), Toast.LENGTH_LONG)
                }

            }
        }
    }
}