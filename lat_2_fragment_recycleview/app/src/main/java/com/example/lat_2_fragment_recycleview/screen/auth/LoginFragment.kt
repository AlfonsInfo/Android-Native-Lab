package com.example.lat_2_fragment_recycleview.screen.auth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.lat_2_fragment_recycleview.R
import com.example.lat_2_fragment_recycleview.screen.home.SecondActivity

class LoginFragment(datanya:Bundle?): Fragment() {

    private lateinit var btn_login : Button
    private lateinit var btn_nav_register : Button

    //nampung data dari arguments
    private val data = datanya
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(arguments != null)
        {
        Log.d("passing via arguments", arguments.toString())
        }
        if(data!=null)
        {
            Log.d("hasil passing", data.toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_login = requireView().findViewById(R.id.btn_login)
        btn_nav_register = requireView().findViewById(R.id.btn_nav_regis)
        // Inflate the layout for this fragment

        btn_login.setOnClickListener {
            val intent = Intent(context,SecondActivity::class.java)
            startActivity(intent)
            requireActivity().overridePendingTransition(com.google.android.material.R.anim.abc_fade_in, com.google.android.material.R.anim.abc_fade_out)
        }

        btn_nav_register.setOnClickListener {

            //difragment butuh Activity
            requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.layout_fragment , RegisterFragment())
                .addToBackStack(null) // agar tombol back bisa kembali kefragment sebelumnya
                .setCustomAnimations(com.google.android.material.R.anim.abc_fade_out, // animasi
                    androidx.appcompat.R.anim.abc_fade_in)
                .commit()
        }

    }

}