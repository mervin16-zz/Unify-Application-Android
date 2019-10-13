package com.th3pl4gu3.unify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.th3pl4gu3.unify.databinding.ActivityMainBinding

class ActivityMain : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setSupportActionBar(_binding.ToolBarMainActivityMain)

        _binding.ToolBarMainActivityMain.setNavigationOnClickListener(BackdropClickListener(
            this,
            _binding.ContainerMainContent,
            AccelerateDecelerateInterpolator(),
            ContextCompat.getDrawable(this, R.drawable.ic_menu_accent),
            ContextCompat.getDrawable(this, R.drawable.ic_close_accent)))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }
}
