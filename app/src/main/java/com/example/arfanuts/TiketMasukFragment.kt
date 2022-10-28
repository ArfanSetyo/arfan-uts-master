package com.example.arfanuts

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment


class TiketMasukFragment : DialogFragment() {

    private lateinit var myTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            val view: View = inflater.inflate(R.layout.fragment_tiket_masuk, container, false)
            myTextView = view.findViewById<View>(R.id.tvHargaTiketMasuk) as TextView
            val bundle = arguments
            val message = bundle!!.getString("mText")
            myTextView.text = message
            return view
    }
}