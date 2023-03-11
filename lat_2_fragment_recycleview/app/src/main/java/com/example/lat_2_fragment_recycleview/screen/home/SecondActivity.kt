package com.example.lat_2_fragment_recycleview.screen.home

import android.app.Activity
import android.app.FragmentManager
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.lat_2_fragment_recycleview.R
import com.example.lat_2_fragment_recycleview.screen.auth.LoginFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class SecondActivity : AppCompatActivity() {

     lateinit var navmenu : BottomNavigationView

     //Agar tidak terjadi penumpukan fragment yang sama ? solusi lain singleton ?
     companion object{
        val HomeFragment : HomeFragment = HomeFragment()
        val ClassFragment : ClassFragment = ClassFragment()
        val GymFragment : GymFragment = GymFragment()
     }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        initFragment(HomeFragment())
        navmenu = findViewById(R.id.bottomNav)  // as BottomNavigationView
        navigasi()



    }

    fun navigasi()
    {

        navmenu.setOnItemSelectedListener(){
            when(it.itemId){
                R.id.menu_home -> {
                    setFragment(HomeFragment)
                    true
                }
                R.id.menu_classroom -> {
                    //cara ini tidak bekerja
//                    if(ClassFragment == null)
//                    {
//                        ClassFragment = ClassFragment()
//                    }
                    setFragment(ClassFragment)
                    true
                }
                R.id.menu_gym ->{
                    setFragment(GymFragment)
                    true
                }
                else -> false
            }
        }
    }

    fun initFragment(fragment: Fragment)
    {
        getSupportFragmentManager()
            .beginTransaction()
//            .addToBackStack(null)
            .replace(R.id.layout_fragment , fragment )
            .setCustomAnimations(com.google.android.material.R.anim.abc_fade_out,
                androidx.appcompat.R.anim.abc_fade_in)
            .commit()
    }

    fun setFragment(fragment: Fragment)
    {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.layout_fragment)
        Log.d("currentfragment", (currentFragment==fragment).toString())
        if(currentFragment == fragment)
        {

        }else{
            getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.layout_fragment , fragment )
                .setCustomAnimations(com.google.android.material.R.anim.abc_fade_out,
                    androidx.appcompat.R.anim.abc_fade_in)
                .commit()
        }

        //ini alternatif untuk tombol back ?
//        getSupportFragmentManager()
//            .addOnBackStackChangedListener {  }

    }

//    override fun onBackPressed() {
//        val fm
//    }
//    Not Working ? apa di fragment pertama ? bekerja saat addTobackStack dipasang juga
    override fun onBackPressed() {
        val fm: FragmentManager = fragmentManager
        if (fm.getBackStackEntryCount() > 0) {
            Log.i("MainActivity", "popping backstack")
            fm.popBackStack()
        } else {
            Log.i("MainActivity", "nothing on backstack, calling super")
            super.onBackPressed()
        }
        if(HomeFragment().isVisible)
        {

        }

    }

}