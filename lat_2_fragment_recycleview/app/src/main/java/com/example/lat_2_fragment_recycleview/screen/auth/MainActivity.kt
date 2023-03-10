package com.example.lat_2_fragment_recycleview.screen.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentTransaction
import com.example.lat_2_fragment_recycleview.R

//Next Navigasi (:)(:)
class MainActivity : AppCompatActivity() {


    override fun onCreate( savedInstanceState: Bundle?) {
        //Menampilkan view
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.layout_fragment , LoginFragment())
            .setCustomAnimations(com.google.android.material.R.anim.abc_fade_out,
                androidx.appcompat.R.anim.abc_fade_in)
            .commit()



    }

}