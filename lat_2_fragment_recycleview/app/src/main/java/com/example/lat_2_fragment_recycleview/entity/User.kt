package com.example.lat_2_fragment_recycleview.entity

class User (var username: String, var password: String, var tanggalLahir : String, var Role : String ){
    companion object{
        var listOfUser =  arrayOf(
            User("alfons", "21.05.2002." , "21-05-2002", "Member"),
            User("lukas", "password","22-02-2003", "Member"),
            User("Toni" ,"password", "20-02-2001", "Instruktur")
        )
    }

}