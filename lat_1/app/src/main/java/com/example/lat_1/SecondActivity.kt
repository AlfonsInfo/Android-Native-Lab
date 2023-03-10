package com.example.lat_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.lat_1.MainActivity

class SecondActivity : AppCompatActivity() {
    private lateinit var btnKembali : Button
    private lateinit var viewOnClick :View.OnClickListener
    private lateinit var textContentt : TextView
    private lateinit var nama : String
    private lateinit var email : String

    fun initComponent()
    {
        textContentt = findViewById(R.id.textView2)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        nama = intent.getStringExtra(MainActivity.KEY_NAMA).toString()
        email = intent.getStringExtra(MainActivity.KEY_EMAIL).toString()
        initComponent()
        textContentt.text = nama + email

        btnKembali = findViewById(R.id.button)
        viewOnClick = View.OnClickListener {
            intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        btnKembali.setOnClickListener(viewOnClick)
    }
}