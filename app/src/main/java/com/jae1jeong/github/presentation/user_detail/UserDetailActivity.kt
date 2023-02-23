package com.jae1jeong.github.presentation.user_detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jae1jeong.github.databinding.ActivityUserDetailBinding

class UserDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }


}