package com.example.utsppapb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.utsppapb.databinding.DetailPageInsideOutBinding
import com.example.utsppapb.HomePageActivity.Companion.EXTRA_IMG
import com.example.utsppapb.HomePageActivity.Companion.EXTRA_TITLE
import com.example.utsppapb.LoginPageActivity.Companion.EXTRA_NAME

class DetailPageInsideOutActivity : AppCompatActivity() {
    private lateinit var binding: DetailPageInsideOutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailPageInsideOutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val title = intent.getStringExtra(EXTRA_TITLE)
        val img = intent.getIntExtra(EXTRA_IMG, 0)
        val name = intent.getStringExtra(EXTRA_NAME)

        with(binding){
            backButton.setOnClickListener{
                val intDetailPageInsideOutActivity =
                    Intent(this@DetailPageInsideOutActivity, com.example.utsppapb.HomePageActivity::class.java)
                intDetailPageInsideOutActivity.putExtra(EXTRA_NAME, name)
                startActivity(intDetailPageInsideOutActivity)
            }
            getTicketInsideOut.setOnClickListener {
                val intDetailPageInsideOutActivity =
                    Intent(this@DetailPageInsideOutActivity, com.example.utsppapb.PaymentPageActivity::class.java)
                intDetailPageInsideOutActivity.putExtra(EXTRA_TITLE, title)
                intDetailPageInsideOutActivity.putExtra(EXTRA_IMG, img)
                intDetailPageInsideOutActivity.putExtra(EXTRA_NAME, name)
                startActivity(intDetailPageInsideOutActivity)
            }
        }
    }
}