package edu.uoc.android.recyclerbinding

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MediaAdapter(private val mediaList: List<Media>) : RecyclerView.Adapter<MediaAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        /*val binding = ViewMediaItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding) */


        val view = parent.inflate(R.layout.view_media_item)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.render(mediaList[position])
    }

    override fun getItemCount(): Int = mediaList.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val mTxtName: TextView = view.findViewById(R.id.txtNombre)
        private val mIvMediaThumb: ImageView = view.findViewById(R.id.mediaThumb)

        fun render(media: Media) {
            mTxtName.text = media.title
            mIvMediaThumb.loadUrl(media.url)

            // Toast sobre viewHolder en extensions.kt
            itemView.setOnClickListener {
                toast(mTxtName.text.toString())
            }
        }
    }

}
