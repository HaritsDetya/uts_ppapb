package com.example.utsppapb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.utsppapb.HomePageActivity.Companion.EXTRA_IMG
import com.example.utsppapb.HomePageActivity.Companion.EXTRA_TITLE
import com.example.utsppapb.LoginPageActivity.Companion.EXTRA_NAME
import com.example.utsppapb.databinding.DetailPageZootopiaBinding

class DetailPageZootopiaActivity : AppCompatActivity() {
    private lateinit var binding: DetailPageZootopiaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailPageZootopiaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val title = intent.getStringExtra(EXTRA_TITLE)
        val img = intent.getIntExtra(EXTRA_IMG, 0)
        val name = intent.getStringExtra(EXTRA_NAME)

        with(binding){
            backButton.setOnClickListener{
                val intDetailPageZootopiaActivity =
                    Intent(this@DetailPageZootopiaActivity, HomePageActivity::class.java)
                intDetailPageZootopiaActivity.putExtra(EXTRA_NAME, name)
                startActivity(intDetailPageZootopiaActivity)
            }
            getTicketZootopia.setOnClickListener {
                val intentDetailPageZootopiaActivity =
                    Intent(this@DetailPageZootopiaActivity, PaymentPageActivity::class.java)
                intentDetailPageZootopiaActivity.putExtra(EXTRA_TITLE, title)
                intentDetailPageZootopiaActivity.putExtra(EXTRA_IMG, img)
                intentDetailPageZootopiaActivity.putExtra(EXTRA_NAME, name)
                startActivity(intentDetailPageZootopiaActivity)
            }
        }
    }

}