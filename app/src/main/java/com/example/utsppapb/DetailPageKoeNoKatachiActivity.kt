package com.example.utsppapb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.utsppapb.databinding.DetailPageKoeNoKatachiBinding
import com.example.utsppapb.HomePageActivity.Companion.EXTRA_IMG
import com.example.utsppapb.HomePageActivity.Companion.EXTRA_TITLE
import com.example.utsppapb.LoginPageActivity.Companion.EXTRA_NAME

class DetailPageKoeNoKatachiActivity : AppCompatActivity() {
    private lateinit var binding: DetailPageKoeNoKatachiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailPageKoeNoKatachiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val title = intent.getStringExtra(EXTRA_TITLE)
        val img = intent.getIntExtra(EXTRA_IMG, 0)
        val name = intent.getStringExtra(EXTRA_NAME)

        with(binding){
            backButton.setOnClickListener{
                val intDetailPageKoeNoKatachiActivity =
                    Intent(this@DetailPageKoeNoKatachiActivity, com.example.utsppapb.HomePageActivity::class.java)
                intDetailPageKoeNoKatachiActivity.putExtra(EXTRA_NAME, name)
                startActivity(intDetailPageKoeNoKatachiActivity)
            }
            getTicketKoeNoKatachi.setOnClickListener {
                val intDetailPageKoeNoKatachiActivity =
                    Intent(this@DetailPageKoeNoKatachiActivity, com.example.utsppapb.PaymentPageActivity::class.java)
                intDetailPageKoeNoKatachiActivity.putExtra(EXTRA_TITLE, title)
                intDetailPageKoeNoKatachiActivity.putExtra(EXTRA_IMG, img)
                intDetailPageKoeNoKatachiActivity.putExtra(EXTRA_NAME, name)
                startActivity(intDetailPageKoeNoKatachiActivity)
            }
        }
    }
}