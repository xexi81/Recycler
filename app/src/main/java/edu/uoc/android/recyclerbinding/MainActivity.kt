package edu.uoc.android.recyclerbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import edu.uoc.android.recyclerbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val mediaList: List<Media> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        recyclerInit(binding)
    }


    fun recyclerInit(binding: ActivityMainBinding) {
        binding.rvMedia.layoutManager = LinearLayoutManager(this)
        val adapter = MediaAdapter(mediaList)
        binding.rvMedia.adapter = adapter
    }
}