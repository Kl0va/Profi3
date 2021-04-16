package com.example.profi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner;
import kotlinx.android.synthetic.main.activity_make_order.*
import kotlinx.android.synthetic.main.item_list.*

class MakeOrder : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_make_order)
    }
}