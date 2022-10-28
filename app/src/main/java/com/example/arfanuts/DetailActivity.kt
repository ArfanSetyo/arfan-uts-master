package com.example.arfanuts

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val data = intent.getParcelableExtra<Pantai>("DATA")
        Log.d("Detail Data", data.toString())

        val ivGambarPantai : ImageView = findViewById(R.id.iv_detail_pantai)
        ivGambarPantai.setImageResource(data?.photo!!.toInt())

        val tvNamaPantai : TextView = findViewById(R.id.tv_nama_pantai)
        tvNamaPantai.text = data?.name

        val tvDescPantai : TextView = findViewById(R.id.tv_desc_pantai)
        tvDescPantai.text = data?.desc

        val mFragment = TiketMasukFragment()

        val btnBtnTiket : Button = findViewById(R.id.btn_kritik_saran)
        btnBtnTiket.setOnClickListener {
            val mBundle = Bundle()
            mBundle.putString("mText", data.tiket)
            mFragment.arguments = mBundle
            mFragment.show(supportFragmentManager, "tiket parkir fragment")
        }
    }
}