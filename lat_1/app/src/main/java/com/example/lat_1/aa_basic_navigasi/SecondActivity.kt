//package com.example.lat_1.aa_basic_navigasi
//
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.view.View
//import android.widget.Button
////kalo dimasukin dalam package, perlu diimport
//import com.example.lat_1.R
//
//class SecondActivity : AppCompatActivity() {
//    private lateinit var btnKembali : Button
//    private lateinit var viewOnClick :View.OnClickListener
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_second)
//        btnKembali = findViewById(R.id.button)
//        viewOnClick = View.OnClickListener {
//            intent = Intent(this,MainActivity::class.java)
//            startActivity(intent)
//        }
//        btnKembali.setOnClickListener(viewOnClick)
//    }
//}