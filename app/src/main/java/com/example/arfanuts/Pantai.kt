package com.example.arfanuts
import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pantai ( var name: String, var photo: Int, var desc: String, var tiket: String) : Parcelable

