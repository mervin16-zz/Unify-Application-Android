package com.th3pl4gu3.unify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.th3pl4gu3.unify.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.backdrop_main.view.*

class ActivityMain : AppCompatActivity(), NavigationHost {

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

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.container, FragmentHome())
                .commit()
        }
    }

    override fun onStart() {
        super.onStart()

        _binding.root.Button_MainActivity_BackdropMenu_Leaves.setOnClickListener{
            this.navigateTo(FragmentLeaves(), false)
        }

        _binding.root.Button_MainActivity_BackdropMenu_Home.setOnClickListener{
            this.navigateTo(FragmentHome(), false)
        }

        _binding.root.Button_MainActivity_BackdropMenu_UC1.setOnClickListener{
            this.navigateTo(FragmentUnderConstruction(), false)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    /**
     * Navigate to the given fragment.
     *
     * @param fragment       Fragment to navigate to.
     * @param addToBackstack Whether or not the current fragment should be added to the backstack.
     */
    override fun navigateTo(fragment: Fragment, addToBackstack: Boolean) {
        val transaction = supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)

        if (addToBackstack) {
            transaction.addToBackStack(null)
        }

        transaction.commit()
    }
}
