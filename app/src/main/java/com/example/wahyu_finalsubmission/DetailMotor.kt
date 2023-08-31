package com.example.wahyu_finalsubmission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailMotor : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_detail_motor)

		val motor = intent.getParcelableExtra<Motor>("motor")
		motor?.let {
			findViewById<TextView>(R.id.article_name).text = it.nama
			findViewById<TextView>(R.id.article_harga).text = it.harga
			findViewById<TextView>(R.id.article_description).text = it.deskripsi
			findViewById<TextView>(R.id.article_mesin).text = it.mesin
			findViewById<TextView>(R.id.article_silinder).text = it.silinder
			findViewById<TextView>(R.id.article_kompresi).text = it.kompresi
			findViewById<TextView>(R.id.article_cc).text = it.cc
			findViewById<TextView>(R.id.article_bahanbakar).text = it.bahanBakar
			findViewById<ImageView>(R.id.img_article_photo).setImageResource(it.photo)
		}
	}
}