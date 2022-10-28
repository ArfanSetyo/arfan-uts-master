package com.example.arfanuts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvPantai: RecyclerView
    private val list = ArrayList<Pantai>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvPantai = findViewById(R.id.rv_pantai)
        rvPantai.setHasFixedSize(true)

        list.addAll(listPantais)
        showRecyclerList()
    }

    private val listPantais: ArrayList<Pantai>
        get(){
            val dataName = resources.getStringArray(R.array.data_name)
            val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
            val dataDesc = resources.getStringArray(R.array.data_description)
            val dataTiket = resources.getStringArray(R.array.data_tiket)
            val listPantai = ArrayList<Pantai>()
            for (i in dataName.indices) {
                val pantai = Pantai(dataName[i], dataPhoto.getResourceId(i, -1), dataDesc[i], dataTiket[i])
                listPantai.add(pantai)
            }
            return listPantai
        }

    private fun showRecyclerList() {
        rvPantai.layoutManager = LinearLayoutManager(this)
        val listPantaiAdapter = ListPantaiAdapter(list)
        rvPantai.adapter = listPantaiAdapter

        listPantaiAdapter.setOnItemClickCallback(object : ListPantaiAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Pantai) {
                showSelectedPantai(data)
                val intentToDetail = Intent(this@MainActivity, DetailActivity::class.java)
                intentToDetail.putExtra("DATA",data)
                startActivity(intentToDetail)
            }
        })
    }

    private fun showSelectedPantai(pantai: Pantai) {
        Toast.makeText(this, "Kamu memilih " + pantai.name, Toast.LENGTH_SHORT).show()
    }
}