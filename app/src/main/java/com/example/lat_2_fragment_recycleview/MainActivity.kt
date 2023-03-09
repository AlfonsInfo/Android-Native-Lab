package com.example.lat_2_fragment_recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lat_2_fragment_recycleview.entity.Mahasiswa

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //Menampilkan view
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Set layout manager ke konteks. Layout Manager : Mengatur bagaimana kita menampilkan data, secara vertikal ?
        //ada 2 kolomkah ? atau secara horizontal ?
        val layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        // variable konstan adapter, yang nilainya merupakan objek dari class RVMahasiswaAdapter, dengan parameter companion object dari Mahasiswa
        val adapter =  RVMahasiswaAdapter(Mahasiswa.listOfMahasiswa)


        // Menghubungkan penamoungnya di activity_main dengan RecycleView
        val rvMahasiswa : RecyclerView = findViewById(R.id.rv_mahasiswa)

        rvMahasiswa.layoutManager = layoutManager // setting layoutnya hori/verti/tabel?
        rvMahasiswa.setHasFixedSize(true)
        rvMahasiswa.adapter = adapter // menghubungkan dengan adapter(binding value)
    }
}