package me.chernakov.playground.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import me.chernakov.playground.R

class ApplicationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}