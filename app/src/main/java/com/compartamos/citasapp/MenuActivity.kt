package com.compartamos.citasapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.aristidevs.androidmaster.R

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val btncita = findViewById<Button>(R.id.btncita)


        btncita.setOnClickListener { navigateToSuperheroApp() }
    }



    private fun navigateToSuperheroApp(){
        val intent = Intent(this, CitaListActivity::class.java)
        startActivity(intent)
    }
}