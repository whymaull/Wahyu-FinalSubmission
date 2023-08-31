package com.example.wahyu_finalsubmission

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListMotorAdapter(private val listMotor: ArrayList<Motor>) : RecyclerView.Adapter<ListMotorAdapter.ListViewHolder>() {

	private lateinit var onItemClickCallback: OnItemClickCallback

	fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
		this.onItemClickCallback = onItemClickCallback
	}

	class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
		val tvName: TextView = itemView.findViewById(R.id.tv_article_name)
		val tvHarga: TextView = itemView.findViewById(R.id.tv_article_harga)
		val imgPhoto: ImageView = itemView.findViewById(R.id.img_article_photo)
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
		val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false)
		return ListViewHolder(view)
	}

	override fun getItemCount(): Int = listMotor.size

	override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
		val (name, harga, photo) = listMotor[position]
		holder.imgPhoto.setImageResource(photo)
		holder.tvName.text = name
		holder.tvHarga.text = harga

		holder.itemView.setOnClickListener {
			onItemClickCallback.onItemClicked(listMotor[holder.adapterPosition])
		}
	}

	interface OnItemClickCallback{
		fun onItemClicked(data: Motor)
	}

}