package com.example.wahyu_finalsubmission

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView

class About : AppCompatActivity() {
	private lateinit var bottomNavigationView: BottomNavigationView
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

		bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
		val emptyItem = bottomNavigationView.menu.findItem(R.id.navigation_empty)
		emptyItem.isEnabled = false
		emptyItem.isVisible = false

		bottomNavigationView.selectedItemId = R.id.navigation_about

		bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
			when (menuItem.itemId) {
				R.id.navigation_home -> {
					startActivity(Intent(this, MainActivity::class.java))
					true
				}
				else -> false
			}
		}

	}
}
