package com.example.utsppapb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.utsppapb.databinding.AccountPageBinding

class AccountPageActivity : AppCompatActivity() {
    private lateinit var binding: AccountPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AccountPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val name = intent.getStringExtra(LoginPageActivity.EXTRA_NAME)
        with(binding){
            username.text = "$name"
            bottomNav.setOnItemSelectedListener{
                when(it.itemId) {
                    R.id.home -> {
                        val intentHomePageActivity =
                            Intent(this@AccountPageActivity, HomePageActivity::class.java)
                        intentHomePageActivity.putExtra(LoginPageActivity.EXTRA_NAME, name)
                        startActivity(intentHomePageActivity)
                    }
                    R.id.account -> {
                        val intentToAccountPageActivity =
                            Intent(this@AccountPageActivity, AccountPageActivity::class.java)
                        intentToAccountPageActivity.putExtra(LoginPageActivity.EXTRA_NAME, name)
                        startActivity(intentToAccountPageActivity)
                    }
                    R.id.logout -> {
                        startActivity(Intent(this@AccountPageActivity, LoginPageActivity::class.java))
                    }
                    else -> {
                    }
                }
                true
            }
        }
    }
}