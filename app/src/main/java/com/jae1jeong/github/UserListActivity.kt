package com.jae1jeong.github

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.jae1jeong.github.databinding.ActivityMainBinding

class UserListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


}