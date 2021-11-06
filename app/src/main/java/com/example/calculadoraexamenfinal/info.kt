package com.example.calculadoraexamenfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class info : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        var btnRegresar=findViewById<Button>(R.id.btnRegresar)
        btnRegresar .setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }

    }

}