package com.example.lat_2_fragment_recycleview.screen.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.lat_2_fragment_recycleview.R
import com.example.lat_2_fragment_recycleview.screen.auth.LoginFragment
import com.google.android.material.bottomnavigation.BottomNavigationView



class SecondActivity : AppCompatActivity() {

    private lateinit var navmenu : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        setFragment(HomeFragment())
        navmenu = findViewById(R.id.bottomNav)  // as BottomNavigationView
        navmenu.setOnItemSelectedListener{
            when(it.itemId){
                R.id.menu_home -> {
                    setFragment(HomeFragment())
                    true
                }
                R.id.menu_classroom -> {
                    setFragment(ClassFragment())
                    true
                }
                R.id.menu_gym ->{
                    setFragment(GymFragment())
                    true
                }
                else -> false
            }
        }



    }

    fun setFragment(fragment: Fragment)
    {
        getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.layout_fragment , fragment )
            .setCustomAnimations(com.google.android.material.R.anim.abc_fade_out,
                androidx.appcompat.R.anim.abc_fade_in)
            .commit()
    }
}