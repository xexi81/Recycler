package edu.uoc.android.recyclerbinding

data class Media (val title: String, val url: String, val mediaType: Type) {
    enum class Type { PHOTO, VIDEO}
}