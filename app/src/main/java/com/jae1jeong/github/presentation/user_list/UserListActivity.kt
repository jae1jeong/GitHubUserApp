package com.jae1jeong.github.presentation.user_list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jae1jeong.github.databinding.ActivityUserlistBinding

class UserListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserlistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserlistBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


}