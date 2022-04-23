package com.example.learntoplay

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.learntoplay.databinding.ActivityMainBinding
import com.example.learntoplay.ui.main.MainFragment

class MainActivity : AppCompatActivity() {
    // set up the instance of binding on activity
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // viewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // fragmentTransaction
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment()) // removed companion object
                .commit() // commitNow() has no addToBackStack() internally
        }
    }

}