package com.example.lat_1

import android.content.Intent
import android.os.Bundle
//import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lat_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //deklarasikan variable bersifat lateinit best practice
    private lateinit var binding: ActivityMainBinding
    private lateinit var btnPindah : Button
    //val btnPindah = binding.button

    //override function yang menyatakan state dari aplikasi, persistentState tidak bisa diterapin di sini
    override fun onCreate(savedInstanceState: Bundle?) {
        //Menyimpan state, persisten state
        super.onCreate(savedInstanceState)
//        super.onCreate(savedInstanceState, persistentState)
        //debugging
        Log.d("ActivityLifecycle", "oncreate")


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //val btnPindah = binding.button
        //setContentView(R.layout.activity_main)


        //debugging
        Log.d("ActivityLifecycle", "oncreate")



    }

    override fun onStart() {
        super.onStart()
        Log.d("ActivityLifecycle", "onstart")
        //btn pindah akan digunakan, deklarasikan nilainya
        btnPindah = binding.button
        Log.d("cek",btnPindah.toString())
        btnPindah.setOnClickListener {
            //debugging
            Log.d("Pencet","btnPindah di pencet")
            //toast
            Toast.makeText(this,"You Click Me !!!", Toast.LENGTH_SHORT).show()
            //intent
            //::class.java -> delcared SecondActivity as Java Object
            intent = Intent(this,SecondActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("ActivityLifecycle", "onrestart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("ActivityLifecycle", "onresume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("ActivityLifecycle", "onpause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("ActivityLifecycle", "onstop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("ActivityLifecycle", "ondestroy")
    }

}