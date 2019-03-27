package com.averoes.daff.footballclub

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //todo 10 tampung data di ListItem ke dalam ArrayList
    private val listItem: ArrayList<ListItem> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //todo 11 memanggil data ke MainActivity , disimpan dalam variable

        val nameClub = resources.getStringArray(R.array.club_name)
        val imageClub = resources.obtainTypedArray(R.array.club_image)

        for(item in nameClub.indices){
            listItem.add(ListItem(nameClub[item], imageClub.getResourceId(item, 0)))
        }

        imageClub.recycle()

        //atur layout manager untuk recycler view
        club_list.layoutManager = LinearLayoutManager(this)

        //atur adapter nya dengan adapter yang kita buat
        club_list.adapter = MyAdapter(this, listItem)
    }
}