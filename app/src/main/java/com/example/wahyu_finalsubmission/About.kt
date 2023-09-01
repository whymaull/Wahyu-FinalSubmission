package com.example.wahyu_finalsubmission

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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

	fun shareApp(view: View) {
		val appPackageName = packageName
		val playStoreLink = "https://play.google.com/store/apps/details?id=$appPackageName"

		val shareIntent = Intent(Intent.ACTION_SEND)
		shareIntent.type = "text/plain"
		shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Bagikan Aplikasi")
		shareIntent.putExtra(Intent.EXTRA_TEXT, "Coba aplikasi ini: $playStoreLink")

		startActivity(Intent.createChooser(shareIntent, "Bagikan Aplikasi"))
	}

}
