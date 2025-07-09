package com.kareemsobh.tripapp.Activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.kareemsobh.tripapp.Adapters.RecommendedAdapter
import com.kareemsobh.tripapp.Adapters.TripsAdapter
import com.kareemsobh.tripapp.ViewModel.MainViewModel
import com.kareemsobh.tripapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observeViewModel()
        setupCategoryListener()
    }

    private fun setupCategoryListener() {
        binding.cat1.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    SearchActivity::class.java
                ).putExtra("cat", "1")
            )
        }
        binding.cat2.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    SearchActivity::class.java
                ).putExtra("cat", "2")
            )
        }
        binding.cat3.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    SearchActivity::class.java
                ).putExtra("cat", "3")
            )
        }
        binding.cat4.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    SearchActivity::class.java
                ).putExtra("cat", "4")
            )
        }
    }


    private fun observeViewModel() {
        viewModel.upcomingTrips.observe(this) { list ->
            binding.progressBarUpComming.visibility = View.GONE
            binding.viewUpcoming.apply {
                layoutManager = LinearLayoutManager(
                    this@MainActivity,
                    LinearLayoutManager.HORIZONTAL, false
                )
                adapter = TripsAdapter(list)
            }
        }
        viewModel.recommededPlaces.observe(this) { list ->
            binding.progressBarRecommended.visibility = View.GONE

            binding.viewRecommended.apply {
                layoutManager = LinearLayoutManager(
                    this@MainActivity,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
                adapter = RecommendedAdapter(list)

            }
        }
    }
}

