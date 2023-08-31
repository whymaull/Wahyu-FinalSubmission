package com.example.wahyu_finalsubmission

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailMotor : AppCompatActivity(), View.OnClickListener {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_detail_motor)

		val selectedMotor = intent.getParcelableExtra<Motor>("motor")
		selectedMotor?.let { motor ->
			supportActionBar?.title = motor.nama
			val imgDetailPhoto: ImageView = findViewById(R.id.img_detail_photo)
			val tvArticleName: TextView = findViewById(R.id.tv_article_name)
			val tvArticleHarga: TextView = findViewById(R.id.tv_article_harga)
			val tvArticleDescription: TextView = findViewById(R.id.tv_article_description)
			val tvArticleMesin: TextView = findViewById(R.id.tv_article_mesin)
			val tvArticleSilinder: TextView = findViewById(R.id.tv_article_silinder)
			val tvArticleKompresi: TextView = findViewById(R.id.tv_article_kompresi)
			val tvArticleCC: TextView = findViewById(R.id.tv_article_cc)
			val tvArticleBahanBakar: TextView = findViewById(R.id.tv_article_bahanbakar)

			imgDetailPhoto.setImageResource(motor.photo)
			tvArticleName.text = motor.nama
			tvArticleHarga.text = motor.harga
			tvArticleDescription.text = motor.deskripsi
			tvArticleMesin.text = motor.mesin
			tvArticleSilinder.text = motor.silinder
			tvArticleKompresi.text = motor.kompresi
			tvArticleCC.text = motor.cc
			tvArticleBahanBakar.text = motor.bahanBakar

		}

		val btnDialPhone: Button = findViewById(R.id.dialnumber)
		btnDialPhone.setOnClickListener(this)
	}

	override fun onClick(v: View?) {
		when (v?.id) {
			R.id.dialnumber -> {
				val phoneNumber = "0895384154732"
				val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
				startActivity(dialPhoneIntent)
			}
		}
	}
}