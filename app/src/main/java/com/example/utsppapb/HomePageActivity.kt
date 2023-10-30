package com.example.utsppapb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.utsppapb.LoginPageActivity.Companion.EXTRA_NAME
import com.example.utsppapb.databinding.HomePageBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class HomePageActivity : AppCompatActivity() {
    private lateinit var binding: HomePageBinding
    companion object{
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_IMG = "extra_img"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val name = intent.getStringExtra(EXTRA_NAME)
        val bottomNav = binding.bottomNav
        bottomNav.selectedItemId = R.id.home


        with(binding){
            username.text = "$name"
            zootopia.setOnClickListener {
                val intentToHomePageActivity =
                    Intent(this@HomePageActivity, DetailPageZootopiaActivity::class.java)
                intentToHomePageActivity.putExtra(EXTRA_TITLE, titleZootopia.text.toString())
                intentToHomePageActivity.putExtra(EXTRA_IMG, R.drawable.zootopia)
                intentToHomePageActivity.putExtra(EXTRA_NAME, name)
                startActivity(intentToHomePageActivity)
            }
            zootopiaImg.setOnClickListener {
                val intentToHomePageActivity =
                    Intent(this@HomePageActivity, DetailPageZootopiaActivity::class.java)
                intentToHomePageActivity.putExtra(EXTRA_TITLE, titleZootopia.text.toString())
                intentToHomePageActivity.putExtra(EXTRA_IMG, R.drawable.zootopia)
                intentToHomePageActivity.putExtra(EXTRA_NAME, name)
                startActivity(intentToHomePageActivity)
            }
            insideOut.setOnClickListener {
                val intentToHomePageActivity =
                    Intent(this@HomePageActivity, DetailPageInsideOutActivity::class.java)
                intentToHomePageActivity.putExtra(EXTRA_TITLE, titleInsideOut.text.toString())
                intentToHomePageActivity.putExtra(EXTRA_IMG, R.drawable.inside_out)
                intentToHomePageActivity.putExtra(EXTRA_NAME, name)
                startActivity(intentToHomePageActivity)
            }
            insideOutImg.setOnClickListener {
                val intentToHomePageActivity =
                    Intent(this@HomePageActivity, DetailPageInsideOutActivity::class.java)
                intentToHomePageActivity.putExtra(EXTRA_TITLE, titleInsideOut.text.toString())
                intentToHomePageActivity.putExtra(EXTRA_IMG, R.drawable.inside_out)
                intentToHomePageActivity.putExtra(EXTRA_NAME, name)
                startActivity(intentToHomePageActivity)
            }
            soul.setOnClickListener {
                val intentToHomePageActivity =
                    Intent(this@HomePageActivity, DetailPageSoulActivity::class.java)
                intentToHomePageActivity.putExtra(EXTRA_TITLE, titleSoul.text.toString())
                intentToHomePageActivity.putExtra(EXTRA_IMG, R.drawable.soul)
                intentToHomePageActivity.putExtra(EXTRA_NAME, name)
                startActivity(intentToHomePageActivity)
            }
            soulImg.setOnClickListener {
                val intentToHomePageActivity =
                    Intent(this@HomePageActivity, DetailPageSoulActivity::class.java)
                intentToHomePageActivity.putExtra(EXTRA_TITLE, titleSoul.text.toString())
                intentToHomePageActivity.putExtra(EXTRA_IMG, R.drawable.soul)
                intentToHomePageActivity.putExtra(EXTRA_NAME, name)
                startActivity(intentToHomePageActivity)
            }
            koeNoKatachi.setOnClickListener {
                val intentToHomePageActivity =
                    Intent(this@HomePageActivity, DetailPageKoeNoKatachiActivity::class.java)
                intentToHomePageActivity.putExtra(EXTRA_TITLE, titleKoeNoKatachi.text.toString())
                intentToHomePageActivity.putExtra(EXTRA_IMG, R.drawable.koe_no_katachi)
                intentToHomePageActivity.putExtra(EXTRA_NAME, name)
                startActivity(intentToHomePageActivity)
            }
            koeNoKatachiImg.setOnClickListener {
                val intentToHomePageActivity =
                    Intent(this@HomePageActivity, DetailPageKoeNoKatachiActivity::class.java)
                intentToHomePageActivity.putExtra(EXTRA_TITLE, titleKoeNoKatachi.text.toString())
                intentToHomePageActivity.putExtra(EXTRA_IMG, R.drawable.koe_no_katachi)
                intentToHomePageActivity.putExtra(EXTRA_NAME, name)
                startActivity(intentToHomePageActivity)
            }

            bottomNav.setOnItemSelectedListener{
                    when(it.itemId) {
                        R.id.home -> {
                            val intentHomePageActivity =
                                Intent(this@HomePageActivity, HomePageActivity::class.java)
                            intentHomePageActivity.putExtra(EXTRA_NAME, name)
                            startActivity(intentHomePageActivity)
                        }
                        R.id.account -> {
                            val intentToAccountPageActivity =
                                Intent(this@HomePageActivity, AccountPageActivity::class.java)
                            intentToAccountPageActivity.putExtra(EXTRA_NAME, name)
                            startActivity(intentToAccountPageActivity)
                        }
                        R.id.logout -> {
                            startActivity(Intent(this@HomePageActivity, LoginPageActivity::class.java))
                        }
                        else -> {
                        }
                    }
                    true
                }
        }
    }
}