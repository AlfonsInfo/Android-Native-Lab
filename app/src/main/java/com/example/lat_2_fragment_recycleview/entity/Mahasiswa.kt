package com.example.lat_2_fragment_recycleview.entity

class Mahasiswa (var nama: String, var IPK: Double, var tahunMasuk : Int){

    companion object{
        var listOfMahasiswa = arrayOf(
            Mahasiswa("Alfonsus Setiawan Jacub", 3.9 , 2020 ),
            Mahasiswa("Eras Timothy", 3.7, 2019),
            Mahasiswa("Ucup Surucup", 4.0 , 2020),
            Mahasiswa("Santo Sutanto", 3.9, 2020),
            Mahasiswa( "Mamang", 3.2 , 2019)
        )
    }

}