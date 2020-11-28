package edu.uoc.android.recyclerbinding


import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.uoc.android.recyclerbinding.databinding.ViewMediaItemBinding


class MediaAdapter(private val mediaList: List<Media>) : RecyclerView.Adapter<MediaAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.view_media_item)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mediaList[position])

    }

    override fun getItemCount(): Int = mediaList.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = ViewMediaItemBinding.bind(view)

        fun bind(media: Media) {
            binding.txtNombre.text = media.title
            binding.mediaThumb.loadUrl(media.url)

            // Toast sobre viewHolder en extensions.kt
            itemView.setOnClickListener {
                toast(binding.txtNombre.text.toString())
            }

            // When como expresión para mostrar la imagen mMediaVideoIndicator para videos
            binding.mediaVideoIndicator.visibility = when (media.mediaType) {
                Media.Type.VIDEO -> View.VISIBLE
                Media.Type.PHOTO -> View.GONE
            }

        }
    }

}
