package com.example.lat_2_fragment_recycleview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lat_2_fragment_recycleview.entity.Mahasiswa


class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Set layout manager ke konteks. Layout Manager : Mengatur bagaimana kita menampilkan data, secara vertikal ?
        //ada 2 kolomkah ? atau secara horizontal ?
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)

        // variable konstan adapter, yang nilainya merupakan objek dari class RVMahasiswaAdapter, dengan parameter companion object dari Mahasiswa
        val adapter =  RVMahasiswaAdapter(Mahasiswa.listOfMahasiswa)


        // Menghubungkan penamoungnya di activity_main dengan RecycleView
        val rvMahasiswa : RecyclerView = view.findViewById(R.id.rv_mahasiswa)

        rvMahasiswa.layoutManager = layoutManager // setting layoutnya hori/verti/tabel?
        rvMahasiswa.setHasFixedSize(true)
        rvMahasiswa.adapter = adapter // menghubungkan dengan adapter(binding value)

    }

}