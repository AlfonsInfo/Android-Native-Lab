package com.example.lat_2_fragment_recycleview.screen.auth

import android.app.DatePickerDialog
//import android.content.Intent
import android.os.Bundle
import android.util.Log
//import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
//import androidx.fragment.app.FragmentTransaction
//import com.example.lat_2_fragment_recycleview.R
import com.example.lat_2_fragment_recycleview.databinding.FragmentRegisterBinding
import com.example.lat_2_fragment_recycleview.entity.User
//import com.example.lat_2_fragment_recycleview.entity.User.Companion.listOfUser
//import com.example.lat_2_fragment_recycleview.entity.User.Companion.printlist
import com.google.android.material.textfield.TextInputEditText
import java.text.SimpleDateFormat
import java.util.*
//import com.example.lat_2_fragment_recycleview.screen.auth.MainActivity


class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    private lateinit var usernameTiet : TextInputEditText
    private lateinit var passwordTiet : TextInputEditText
    private lateinit var buttonRegis : Button
    private lateinit var birthdateTiet : TextInputEditText

    private val calendar = Calendar.getInstance()
    //date picker
    private val dateSetListener =
        DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, monthOfYear)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateDateEditText()
        }

    private fun showDatePickerDialog() {
        DatePickerDialog(
            requireContext(), dateSetListener,
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    private fun updateDateEditText() {
        val dateFormat = "dd/MM/yyyy"
        val simpleDateFormat = SimpleDateFormat(dateFormat, Locale.US)
        birthdateTiet.setText(simpleDateFormat.format(calendar.time))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentRegisterBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        birthdateTiet = binding.birthdateTiet
        birthdateTiet.setOnClickListener {
            showDatePickerDialog()
        }
        buttonRegis = binding.btnRegister
        buttonRegis.setOnClickListener{
            usernameTiet = binding.usernameTiet
            passwordTiet = binding.passwordTiet
            val username = usernameTiet.text.toString()
            val password = passwordTiet.text.toString()
            val birthdate = birthdateTiet.text.toString()
            var statusInput = true
            if(username == "" ){
                usernameTiet.setError("Usernamenya Ga boleh kosong Pak !!")
                statusInput = false
            }
            if(password == "")
            {
                passwordTiet.setError("Passwornya diisi dong bujang")
                statusInput = false
            }
            if(birthdate == "")
            {
                birthdateTiet.setError("Kapan lahir woyy ")
                statusInput = false
            }
            if (statusInput){

                //Save Data
                val user = User(username,password,birthdate,"Member")
                val bundle = Bundle()
                bundle.apply {
                    putString("username",username)
                    putString("password",password)
                }
                //Pindah Ke Login Form
                //Passing data ke login form

                //Cara akses activity dari fragment
                var LoginFragment : LoginFragment
                LoginFragment = LoginFragment(bundle)
                LoginFragment.apply {
                    arguments = bundle
                }
                //contoh mengakses fungsi acitivity dari fragment ?
                (activity as MainActivity).authNavigasi(LoginFragment)

            }

        }

    }


}