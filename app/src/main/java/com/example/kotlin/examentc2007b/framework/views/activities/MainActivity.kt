package com.example.kotlin.examentc2007b.framework.views.activities

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.examentc2007b.data.network.model.MovieBase
import com.example.kotlin.examentc2007b.databinding.ActivityMainBinding
import com.example.kotlin.examentc2007b.framework.adapters.MovieAdapter

class MainActivity: Activity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter : MovieAdapter = MovieAdapter()
    private lateinit var data:ArrayList<MovieBase>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
        setUpRecyclerView(testData())
    }

    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setUpRecyclerView(dataForList:ArrayList<MovieBase>){
        binding.RVMovie.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false)
        binding.RVMovie.layoutManager = linearLayoutManager
        adapter.CommonsAdapter(dataForList)
        binding.RVMovie.adapter = adapter
    }

    private fun testData():ArrayList<MovieBase>{
        var result = ArrayList<MovieBase>()

        result.add(MovieBase("PELI 1",""))
        result.add(MovieBase("PELI 2",""))
        result.add(MovieBase("PELI 3",""))

        return result
    }

}