package com.project.projectone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart = findViewById<Button>(R.id.btnStart)
        btnStart.setOnClickListener {
            val etUsername = this.findViewById<EditText>(R.id.etStart)
            val username = etUsername.text.toString()
            if (username.isNotEmpty()) {
                goToCredit(username)
            } else {
                Toast.makeText(this@MainActivity, "Username is empty", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun goToCredit(username:String) {
        //intent
        val intent = Intent(this@MainActivity, CreditActivity::class.java)
        //valor del cuadro de texto
        //val etNombre = this.findViewById<EditText>(R.id.etName)
        //añadimos informacion necesaria al intent
        //intent.putExtra("NAME", etNombre.text.toString())
        intent.putExtra("NAME", username)

        startActivity(intent)
    }
}