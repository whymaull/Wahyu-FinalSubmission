package com.example.wahyu_finalsubmission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class About : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_about)

		val profileImageView = findViewById<ImageView>(R.id.profileImageView)
		val nameTextView = findViewById<TextView>(R.id.nameTextView)
		val emailTextView = findViewById<TextView>(R.id.emailTextView)

		val yourName = "Wahyu Maulana Aditya"
		val yourEmail = "first.wahyumaul21@gmail.com"
		val profileImage = resources.getDrawable(R.drawable.profile_picture, null)

		nameTextView.text = yourName
		emailTextView.text = yourEmail
		profileImageView.setImageDrawable(profileImage)
	}
}
