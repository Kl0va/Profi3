package com.example.profi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance()
        Register.setOnClickListener{
           var intent = Intent(this,Registration::class.java)
            startActivity(intent)
        }

        LogIn.setOnClickListener{
            try {
                if (Email.text == null || Email.text.toString() == "") {
                    Toast.makeText(baseContext, "Пустой E-mail", Toast.LENGTH_LONG).show()
                } else {
                    auth.signInWithEmailAndPassword(Email.text.toString(), Password.text.toString()).addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            val intent = Intent(this, MainMenu::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(baseContext, "Ошибка авторизации", Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }
            catch(e: Exception){
                Toast.makeText(baseContext,"Ошибка", Toast.LENGTH_LONG).show()
            }
        }

        auth.sendPasswordResetEmail("nets228322@gmail.com").addOnCompleteListener(this) {
            
        }
    }
}