package com.averoes.daff.footballclub

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_list.view.*
import java.util.ArrayList

/**
 * Created by daff on 26/03/19 at 7:04.
 */

//todo 8 membuat adapter untuk menampilkan data ke dalam list

class MyAdapter(private val context: Context, private val items: ArrayList<ListItem>)
    : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    //todo 9 memasukkan custom layout yang dibuat
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))

    //menampilkan view yang kita buat ke recycler view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    //untuk mengatur seberapa banyak data yang kita inginkan
    override fun getItemCount(): Int = items.size

    //untuk menampung view yang kita buat
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        val name = view.name
        private val image = view.image

        //untuk menagatur view yang akan kita tampilkan
        fun bindItem(items: ListItem) {

            //masukkan data clubName yang ada di ListItem kedalam TextView
            name.text = items.name

            //menampilkan gambar dengan library glide
            Glide.with(itemView.context).load(items.image).into(image)
        }
    }
}