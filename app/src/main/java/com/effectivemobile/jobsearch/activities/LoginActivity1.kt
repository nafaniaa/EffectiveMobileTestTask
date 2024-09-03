package com.effectivemobile.jobsearch.activities

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.effectivemobile.jobsearch.R
import com.effectivemobile.jobsearch.databinding.ActivityLogin1Binding

class LoginActivity1 : AppCompatActivity() {
    private lateinit var binding: ActivityLogin1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogin1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etEmail.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.btnContinue.isEnabled = !s.isNullOrEmpty()
                binding.tvEmailError.visibility = View.GONE
                binding.etEmail.setBackgroundColor(Color.TRANSPARENT)
                binding.ivClear.visibility = if(s.isNullOrEmpty()) View.GONE else View.VISIBLE
            }

            override fun afterTextChanged(s: Editable?) {
                TODO("Not yet implemented")
            }
        })

        binding.ivClear.setOnClickListener{
            binding.etEmail.text.clear()
        }

        binding.btnContinue.setOnClickListener{
            val email = binding.etEmail.text.toString()
            if (isValidEmail(email)){
                val intent = Intent(this, LoginActivity2::class.java).apply {
                    putExtra("email", email)
                }
                startActivity(intent)
            } else {
                binding.tvEmailError.visibility = View.GONE
            }
        }

        binding.btnLoginWithPassword.setOnClickListener {
            Toast.makeText(this, getString(R.string.logic), Toast.LENGTH_SHORT).show()
        }
    }

    private fun isValidEmail(email: String): Boolean{
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}