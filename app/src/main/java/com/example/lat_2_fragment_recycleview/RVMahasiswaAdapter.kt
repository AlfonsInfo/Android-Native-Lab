package com.example.lat_2_fragment_recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.lat_2_fragment_recycleview.databinding.RvMahasiswaBinding
import com.example.lat_2_fragment_recycleview.entity.Mahasiswa
import com.example.lat_2_fragment_recycleview.entity.Mahasiswa.Companion.listOfMahasiswa

//RVMahasiswaAdapter turunan dari RecyclerView.Adapter<
class RVMahasiswaAdapter(private val data : Array<Mahasiswa>) : RecyclerView.Adapter<RVMahasiswaAdapter.ViewHolder>() {
    //Atribut kelasnya data dengan tipe array dari mahasiswa
//    private lateinit var binding : RvMahasiswaBinding

    //menghubungkan layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //Parent ini refer to MainActivity / tempat penampung onCreateViewHolder
        val binding = RvMahasiswaBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    //menghubungkan nilai yang ingin ditanamkan pada layout
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = data[position]
        holder.binding.tvNama.text = currentItem.nama
        holder.binding.tvDetails.text = "${currentItem.tahunMasuk} - ${currentItem.IPK}"
    }

    //ukuran item
    override fun getItemCount(): Int {
        return listOfMahasiswa.size
    }
    // Menghubungkan ke xml recycleview(satu unitnya)
    class ViewHolder(val binding : RvMahasiswaBinding) : RecyclerView.ViewHolder(binding.root){
    }

}

