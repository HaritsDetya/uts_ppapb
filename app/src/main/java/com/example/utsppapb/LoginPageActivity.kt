package com.example.utsppapb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.example.utsppapb.databinding.LoginPageBinding
import com.google.android.material.textfield.TextInputEditText

class LoginPageActivity : AppCompatActivity() {
    private lateinit var binding: LoginPageBinding

    companion object{
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_PASS = "extra_pass"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val usernameInput = findViewById<TextInputEditText>(R.id.username_input)
        val passwordInput = findViewById<TextInputEditText>(R.id.password_input)
        val login = findViewById<AppCompatButton>(R.id.login)

        val user = arrayOf("Adi", "Budi", "Andi", "Supomo")
        val pass = mapOf(
            user[0] to "1234",
            user[1] to "2341",
            user[2] to "3412",
            user[3] to "4123")
        fun isLoginValid(username: String, password: String): Boolean {
            val storedPassword = pass[username]
            return storedPassword != null && storedPassword == password
        }

        with(binding) {
            login.setOnClickListener {
                val username = usernameInput.text.toString()
                val password = passwordInput.text.toString()

                if (isLoginValid(username, password)) {
                    val intentToLoginPageActivity =
                        Intent(this@LoginPageActivity, HomePageActivity::class.java)
                    intentToLoginPageActivity.putExtra(EXTRA_NAME, username)
                    intentToLoginPageActivity.putExtra(EXTRA_PASS, password)
                    startActivity(intentToLoginPageActivity)
                } else {
                    Toast.makeText(this@LoginPageActivity, "Username atau Password tidak sesuai", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}