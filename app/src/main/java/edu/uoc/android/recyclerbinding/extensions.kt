package edu.uoc.android.recyclerbinding

import android.content.Context
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.recyclerview.widget.RecyclerView

fun Context.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    makeText(this, message, length).show()
}


fun RecyclerView.ViewHolder.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    makeText(this.itemView.context, message, length).show()
}