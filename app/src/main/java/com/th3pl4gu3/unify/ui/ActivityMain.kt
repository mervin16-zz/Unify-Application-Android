package com.th3pl4gu3.unify.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import com.th3pl4gu3.unify.R
import com.th3pl4gu3.unify.databinding.ActivityMainBinding

class ActivityMain : AppCompatActivity(){

    private lateinit var _binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //Set the bottom bar as SupportActionBar
        setSupportActionBar(_binding.BottomAppBarFromMainActivityMain)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_bottomappbar_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                val bottomAppBarDialog = RoundedBottomDialogFragmentBottomAppBarDrawer()
                bottomAppBarDialog.show(supportFragmentManager, bottomAppBarDialog.tag)
                true
            }

            else -> false
        }
    }

}
