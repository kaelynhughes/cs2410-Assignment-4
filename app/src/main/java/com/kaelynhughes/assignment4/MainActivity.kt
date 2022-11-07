package com.kaelynhughes.assignment4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("app started")
        setContentView(R.layout.activity_main)
    }
}