package com.example.utsppapb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.utsppapb.databinding.DetailPageSoulBinding
import com.example.utsppapb.HomePageActivity.Companion.EXTRA_IMG
import com.example.utsppapb.HomePageActivity.Companion.EXTRA_TITLE
import com.example.utsppapb.LoginPageActivity.Companion.EXTRA_NAME

class DetailPageSoulActivity : AppCompatActivity() {
    private lateinit var binding: DetailPageSoulBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailPageSoulBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val title = intent.getStringExtra(EXTRA_TITLE)
        val img = intent.getIntExtra(EXTRA_IMG, 0)
        val name = intent.getStringExtra(EXTRA_NAME)

        with(binding){
            backButton.setOnClickListener{
                val intDetailPageSoulActivity =
                    Intent(this@DetailPageSoulActivity, com.example.utsppapb.HomePageActivity::class.java)
                intDetailPageSoulActivity.putExtra(EXTRA_NAME, name)
                startActivity(intDetailPageSoulActivity)
            }
            getTicketSoul.setOnClickListener {
                val intDetailPageSoulActivity =
                    Intent(this@DetailPageSoulActivity, com.example.utsppapb.PaymentPageActivity::class.java)
                intDetailPageSoulActivity.putExtra(EXTRA_TITLE, title)
                intDetailPageSoulActivity.putExtra(EXTRA_IMG, img)
                intDetailPageSoulActivity.putExtra(EXTRA_NAME, name)
                startActivity(intDetailPageSoulActivity)
            }
        }
    }
}