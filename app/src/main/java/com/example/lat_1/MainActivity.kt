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
    private lateinit var tieNama : TextInputEditText
    private lateinit var  tieEmail : TextInputEditText
    private lateinit var btn : Button
    private lateinit var valueNama : String
    private lateinit var valueEmail : String

    override fun onCreate(savedInstanceState: Bundle?) {
        //debugging
        Log.d("ActivityLifecycle", "oncreate")
        super.onCreate(savedInstanceState)

        //XML - ActivityMainBinding.inflate - getroot - setContent
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        btn = binding.button
        btn.setOnClickListener {
            tieNama = binding.namaTie
            tieEmail = binding.emailTie
            valueNama = tieNama.text.toString()
            valueEmail = tieEmail.text.toString()

            val intent = Intent(this, SecondActivity::class.java)
            //Cara 1 : Intent.putExtra putString dll
            //intent.putExtra(KEY_NAMA, valueNama)
            //intent.putExtra(KEY_EMAIL, valueEmail)

            //Cara 2: Tampung ke bundle, dari bundle baru di passing ke ke intent menggunakan putExtras
            val bundle = Bundle()
            bundle.putString(KEY_NAMA,valueNama)
            bundle.putString(KEY_EMAIL,valueEmail)
            intent.putExtras(bundle)
            startActivity(intent)
        }









    }

    // Cara bikin key, ntar bisa diakses dari kelasnya di secondActivity
    companion object {
        const val KEY_NAMA = "NAMA"
        const val KEY_EMAIL = "EMAIL"
    }



}