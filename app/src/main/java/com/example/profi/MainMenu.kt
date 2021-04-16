package com.example.profi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firestore.v1.StructuredQuery
import kotlinx.android.synthetic.main.activity_main_menu.*
import kotlinx.android.synthetic.main.item_list.view.*
import java.lang.Exception

class MainMenu : AppCompatActivity() {
    var count = 1;
    var count_2 = 0;
    val myDB = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        Recycler.setHasFixedSize(true)
        Recycler.setItemViewCacheSize(20)
        Recycler.setDrawingCacheEnabled(true)
        Recycler.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH)
        Recycler.layoutManager = LinearLayoutManager(this)


        val menu = myDB.collection("orders")
        val asdasdasdad = myDB.collection("AllOrders")
            menu.get().addOnSuccessListener {
                it.forEach {
                    if (it.get("Name") != null) {
                        count_2++
                        asdasdasdad.document("AllOrders").set(
                            mapOf(
                                "AllOrders" to count_2
                            )
                        )
                    }
                }
            }

        MakeOrder.setOnClickListener{
            var intent = Intent(this,com.example.profi.MakeOrder::class.java)
            startActivity(intent)
        }

        try {
                var Orders = 0
                var zapros =
                    myDB.collection("AllOrders").document("AllOrders").get().addOnSuccessListener {
                        Orders = it.get("AllOrders").toString().toInt()
                        Recycler.adapter = ItemAdapter(this, Orders) {
                            LoadOrders(
                                it.findViewById(R.id.Name),
                                it.findViewById(R.id.Description),
                                it.findViewById(R.id.Type),
                                it.findViewById(R.id.Price)
                            )
                        }
                    }
        }
        catch(e: Exception){

        }
    }


    fun LoadOrders(Name: TextView, Description: TextView, Type: TextView, Price: TextView){
        var orders = myDB.collection("orders")
        orders.document("1").get().addOnSuccessListener {
            Name.text = "${it.get("Name")}"
            Description.text = "${it.get("Description")}"
            Type.text = "${it.get("Type")}"
            Price.text = "${it.get("Price")}"
        }
    }
}