package com.example.leakexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class CounterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.counter_activity)

        supportFragmentManager.beginTransaction().add(R.id.counter_container, CounterFragment())
            .commit()
    }
}