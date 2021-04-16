package com.example.profi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_registration.*
import java.lang.Exception

class Registration : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        auth = FirebaseAuth.getInstance()
        ConfirmRegistration.setOnClickListener{
            Register()
        }
        Executor.setOnClickListener{
            Client.isChecked = false
        }

        Client.setOnClickListener{
            Executor.isChecked = false
        }
    }

    fun Register(){
        try {
            auth.createUserWithEmailAndPassword(Email.text.toString(), Password.text.toString()).addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(baseContext, "Успешная регистрация", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(baseContext, "Ошибка", Toast.LENGTH_LONG).show()
                }
            }
            if(!Client.isChecked && !Executor.isChecked){
                Toast.makeText(baseContext,"Выберите кто вы", Toast.LENGTH_LONG).show()
            }
        }
        catch(e: Exception){
            Toast.makeText(baseContext,"Ошибка", Toast.LENGTH_LONG).show()
        }
    }
}