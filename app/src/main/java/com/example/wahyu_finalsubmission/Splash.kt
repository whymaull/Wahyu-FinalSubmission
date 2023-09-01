package com.example.wahyu_finalsubmission

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Splash : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_splash)

		val splashScreenDuration = 500
		val mainActivityIntent = Intent(this, MainActivity::class.java)

		Thread {
			Thread.sleep(splashScreenDuration.toLong())
			startActivity(mainActivityIntent)
			finish()
		}.start()
	}
}