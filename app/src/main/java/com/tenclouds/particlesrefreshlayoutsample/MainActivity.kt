package com.tenclouds.particlesrefreshlayoutsample

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.tenclouds.particlesrefreshlayout.listener.OnParticleRefreshListener
import com.tenclouds.particlesrefreshlayoutsample.adapter.PlantsAdapter
import com.tenclouds.particlesrefreshlayoutsample.adapter.item.Plant
import com.tenclouds.particlesrefreshlayoutsample.databinding.ActivityMainBinding

//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity :
        AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val plantsAdapter = PlantsAdapter()
    private val plantsList
        get() =
            listOf(
                    Plant(
                            "Abies Alba",
                            "grown in light shade but develop...",
                            12.50f,
                            R.drawable.plant1),
                    Plant(
                            "Eremurus himaluicus",
                            "outstading plant for warm...",
                            2.80f,
                            R.drawable.plant2),
                    Plant(
                            "Diascia barberae",
                            "tall, dramatic perennials..",
                            4.60f,
                            R.drawable.plant3),
                    Plant(
                            "Abies Alba",
                            "grown in light shade but develop...",
                            4.60f,
                            R.drawable.plant4),
                    Plant(
                            "Eremurus himaluicus",
                            "outstading plant for warm...",
                            21.00f,
                            R.drawable.plant1))
                    .shuffled()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding.recyclerView) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = plantsAdapter
            plantsAdapter.plantsList = plantsList
        }

        binding.particlesSwipeRefresh.onParticleRefreshListener = object : OnParticleRefreshListener {
            override fun onRefresh() {
                Handler(Looper.getMainLooper())
                        .postDelayed(
                                {
                                    binding.particlesSwipeRefresh.stopRefreshing()
                                    plantsAdapter.plantsList = plantsList
                                },
                                3000)
            }
        }
    }
}