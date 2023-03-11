package com.example.lat_2_fragment_recycleview.screen.auth

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.lat_2_fragment_recycleview.R
import com.example.lat_2_fragment_recycleview.entity.User

//Next Navigasi (:)(:)
class MainActivity : AppCompatActivity() {

    var value : User? = null
    fun authNavigasi(fragment :Fragment)
    {
        this.getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.layout_fragment , fragment)
            .setCustomAnimations(com.google.android.material.R.anim.abc_fade_out,
                androidx.appcompat.R.anim.abc_fade_in)
            .commit()

    }

    //bagaimana cara akses fragment dari activity ?
    //bisakah passing data antar fragment menggunakan activity?
    fun passValue(user:User)
    {
        value = user
    }

    override fun onCreate( savedInstanceState: Bundle?) {
        //Menampilkan view
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        authNavigasi(LoginFragment(null))

//        if(value !=null)
//        {
//            (fragmentManager as RegisterFragment).apply {
//
//            }
//        }

    }

}