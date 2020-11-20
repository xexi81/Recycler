package edu.uoc.android.recyclerbinding

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

fun Context.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    makeText(this, message, length).show()
}


fun RecyclerView.ViewHolder.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    makeText(this.itemView.context, message, length).show()
}

// anotación para validación interna de que ese int es  un layout
fun ViewGroup.inflate(@LayoutRes layout: Int): View = LayoutInflater.from(this.context).inflate(layout, this, false)


fun ImageView.loadUrl(url: String) = Glide.with(context).load(url).into(this)


// Tipo reified porque puede llamarse desde cualquier clase que extienda de Activity
inline fun <reified T : Activity> Context.startActivity() {
    val intent = Intent(this, T::class.java)
    startActivity(intent)
}
