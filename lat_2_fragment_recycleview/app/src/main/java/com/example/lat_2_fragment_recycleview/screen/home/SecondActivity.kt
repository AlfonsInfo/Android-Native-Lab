package com.example.lat_2_fragment_recycleview.screen.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lat_2_fragment_recycleview.R
import com.example.lat_2_fragment_recycleview.screen.auth.LoginFragment

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.layout_fragment , HomeFragment())
            .setCustomAnimations(com.google.android.material.R.anim.abc_fade_out,
                androidx.appcompat.R.anim.abc_fade_in)
            .commit()
    }
}