package com.example.searchfilm010822_19_9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_menu.setOnClickListener {
            Toast.makeText(this, "МЕНЮ", Toast.LENGTH_SHORT).show()
        }
        button_fav.setOnClickListener {
            Toast.makeText(this, "ИЗБРАННОЕ", Toast.LENGTH_SHORT).show()
        }
        button_watch_later.setOnClickListener {
            Toast.makeText(this, "ПОСМОТРЕТЬ ПОЗЖЕ", Toast.LENGTH_SHORT).show()
        }
        button_selections.setOnClickListener {
            Toast.makeText(this, "ПОДБОРКИ", Toast.LENGTH_SHORT).show()
        }
        button_settings.setOnClickListener {
            Toast.makeText(this, "НАСТРОЙКИ", Toast.LENGTH_SHORT).show()
        }
    }
}