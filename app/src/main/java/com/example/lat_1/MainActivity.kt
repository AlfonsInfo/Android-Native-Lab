package com.example.lat_1

import android.content.Intent
import android.os.Bundle
//import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lat_1.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText

//Next Bundle dan kawan-kawan
//Move for result

class MainActivity : AppCompatActivity() {

    //deklarasikan variable bersifat lateinit best practice
    private lateinit var binding: ActivityMainBinding
    private lateinit var btnACC : Button
    private lateinit var tieNama : TextInputEditText
    private lateinit var tieEmail : TextInputEditText
    private lateinit var nama : String
    private lateinit var email : String
    private lateinit var btnMove : Button
    //Function


    fun initComponent()
    {
        //init component input
        tieNama = binding.namaTie
        tieEmail = binding.emailTie
        nama = tieNama.text.toString()
        email = tieEmail.text.toString()
    }

    fun showButton()
    {
        //tampilkan tommbol untuk pindah halaman
        btnMove.visibility = View.VISIBLE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //debugging
        Log.d("ActivityLifecycle", "oncreate")


        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        //debugging
        Log.d("ActivityLifecycle", "oncreate")

    }

    override fun onStart() {
        super.onStart()
        Log.d("ActivityLifecycle", "onstart")
        //btn pindah akan digunakan, deklarasikan nilainya
        btnACC = binding.button
        Log.d("cek",btnACC.toString())
        btnACC.setOnClickListener {
            //inisialisasi variabel yang digunakan
            initComponent()
            //debugging variabel
            Log.d("input", nama)
            Log.d("input", email)
            showButton()
        }

        //Harus diinit dulu btnMove ini sebelum dibuat check listenernya
        btnMove = binding.button2
        Log.d("cekKondisi" , (btnMove.visibility == View.VISIBLE).toString()) // pada dasarnya ini ngga dibutuhkan karena
        //saat dia visible dia tidak dibaca oleh aplikasi.

            btnMove.setOnClickListener {
                //persiapan bundle
                val bundle = Bundle() // object bundle
                //Move Page
                intent = Intent(this, SecondActivity::class.java) // buat intent dengan bundle
                intent.putExtras(bundle)
                startActivity(intent) // jalankan activity tersebut
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