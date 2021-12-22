package com.example.daftarbukuproject

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import org.w3c.dom.Text

class Detaill : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detaill)
        val judul = intent.getStringExtra("judul");
        val judulView = findViewById<TextView>(R.id.item_judul).apply {
            text = judul.toString()
        }
        val deskripsi = intent.getStringExtra("desk");
        val deskView = findViewById<TextView>(R.id.item_desk).apply {
            text = deskripsi.toString()
        }
        val poto = intent.getStringExtra("gambar");
        val  ImageView = findViewById<ImageView>(R.id.item_poto)
//        ImageView.setImageURI(Uri.parse("@"+poto))
        Glide.with(this)
            .load(poto)
            .apply(RequestOptions().override(55,55))
            .into(ImageView)
    }
}