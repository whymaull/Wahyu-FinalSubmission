package com.example.wahyu_finalsubmission

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Motor(
		val nama: String,
		val harga: String,
		val deskripsi: String,
		val mesin: String,
		val silinder: String,
		val kompresi: String,
		val cc: String,
		val bahanBakar: String,
		val photo: Int

) : Parcelable
