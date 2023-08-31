package com.example.wahyu_finalsubmission

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
	private lateinit var rvMotor: RecyclerView
	private val list = ArrayList<Motor>()
	private lateinit var bottomNavigationView: BottomNavigationView

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		rvMotor = findViewById(R.id.rv_motor)
		rvMotor.setHasFixedSize(true)

		list.addAll(getListMotor())
		showRecyclerList()

		bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
		val emptyItem = bottomNavigationView.menu.findItem(R.id.navigation_empty)
			emptyItem.isEnabled = false
			emptyItem.isVisible = false

		bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
			when (menuItem.itemId) {
				R.id.navigation_home -> {
					true
				}
				R.id.navigation_about -> {
					navigateToAbout()
					true
				}
				else -> false
			}
		}
	}

	@SuppressLint("Recycle")
	private fun getListMotor(): ArrayList<Motor> {
		val articleName = resources.getStringArray(R.array.article_name)
		val articleHarga = resources.getStringArray(R.array.article_harga)
		val articlePhoto = resources.obtainTypedArray(R.array.article_photo)
		val articleDescription = resources.getStringArray(R.array.article_description)
		val articleMesin = resources.getStringArray(R.array.article_mesin)
		val articleSilinder = resources.getStringArray(R.array.article_silinder)
		val articleKompresi = resources.getStringArray(R.array.article_kompresi)
		val articleCC = resources.getStringArray(R.array.article_cc)
		val articleBahanBakar = resources.getStringArray(R.array.article_bahanbakar)

		val listMotor = ArrayList<Motor>()
		for (i in articleName.indices) {
			val motor = Motor(articleName[i], articleHarga[i],  articlePhoto.getResourceId(i, -1),articleDescription[i], articleMesin[i], articleSilinder[i], articleKompresi[i], articleCC[i], articleBahanBakar[i])
			listMotor.add(motor)
		}
		return listMotor
	}

	private fun showRecyclerList() {
		rvMotor.layoutManager = LinearLayoutManager(this)
		val listMotorAdapter = ListMotorAdapter(list)
		rvMotor.adapter = listMotorAdapter

		listMotorAdapter.setOnItemClickCallback(object : ListMotorAdapter.OnItemClickCallback {
			override fun onItemClicked(data: Motor) {
				showSelectedMotor(data)
			}
		})
	}

	private fun showSelectedMotor(data: Motor) {
		val intent = Intent(this, DetailMotor::class.java)
		intent.putExtra("motor", data)
		startActivity(intent)
	}

	private fun navigateToAbout() {
		val intent = Intent(this, About::class.java)
		startActivity(intent)
	}
}