package com.project.projectone

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class CreditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credit)

        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        //nombre del intent
        val username = intent.getStringExtra("NAME")
        //cadena del saludo
        tvWelcome.apply {
            text = getString(R.string.tvWelcome, username)
        }

        val btnContactUs = findViewById<Button>(R.id.btnWelcome)
        btnContactUs.setOnClickListener {
            contactUs()
        }
    }

    private fun contactUs() {
        val email = "rtomb@g.educaand.es"

        val appName = getString(R.string.app_name)
        val affair = "Contacted from $appName"

        val intentEmail = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:$email")
            putExtra(Intent.EXTRA_SUBJECT, affair)
        }

        if (intentEmail.resolveActivity(packageManager) != null) {
            startActivity(intentEmail)
        }
    }
}