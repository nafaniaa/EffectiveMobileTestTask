package com.effectivemobile.jobsearch.activities

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.effectivemobile.jobsearch.MainActivity
import com.effectivemobile.jobsearch.R
import com.effectivemobile.jobsearch.databinding.ActivityLogin2Binding

class LoginActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityLogin2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogin2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val email = intent.getStringExtra("email")
        binding.tvCodeSent.text = getString(R.string.sendCodeToEmail, email)

        val codeWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                checkIfAllFieldsFilled()
            }

            override fun afterTextChanged(s: Editable?) {}
        }

        binding.etCode1.addTextChangedListener(codeWatcher)
        binding.etCode2.addTextChangedListener(codeWatcher)
        binding.etCode3.addTextChangedListener(codeWatcher)
        binding.etCode4.addTextChangedListener(codeWatcher)


        binding.btnConfirm.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    private fun checkIfAllFieldsFilled() {
        val code1 = binding.etCode1.text.toString()
        val code2 = binding.etCode2.text.toString()
        val code3 = binding.etCode3.text.toString()
        val code4 = binding.etCode4.text.toString()
        val allFilled = code1.isNotEmpty() && code2.isNotEmpty() && code3.isNotEmpty() && code4.isNotEmpty()
        binding.btnConfirm.isEnabled = allFilled
    }
}