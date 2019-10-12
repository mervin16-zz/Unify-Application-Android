package com.th3pl4gu3.unify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.th3pl4gu3.unify.databinding.ActivityMainBinding

class ActivityMain : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        _binding.materialButton.setOnClickListener{
            Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show()
        }
    }
}
