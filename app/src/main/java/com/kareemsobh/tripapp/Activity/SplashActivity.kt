package com.kareemsobh.tripapp.Activity



import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.kareemsobh.tripapp.databinding.ActivitySplashBinding


class SplashActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            startBtn.setOnClickListener {
                startActivity(Intent(
                    this@SplashActivity,
                    MainActivity::class.java
                ))
            }
        }

    }
}