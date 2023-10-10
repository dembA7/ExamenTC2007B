package com.example.kotlin.examentc2007b.framework.views.activities

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.examentc2007b.data.repository.MovieRepository
import com.example.kotlin.examentc2007b.domain.model.MovieBase
import com.example.kotlin.examentc2007b.databinding.ActivityMainBinding
import com.example.kotlin.examentc2007b.framework.adapters.MovieAdapter
import com.example.kotlin.examentc2007b.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity: Activity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter : MovieAdapter = MovieAdapter(this)
    private lateinit var data:ArrayList<MovieBase>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
        setUpRecyclerView(testData())
        getMovieList()
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
        adapter.CommonsAdapter(dataForList, this)
        binding.RVMovie.adapter = adapter
    }

    private fun testData():ArrayList<MovieBase>{
        var result = ArrayList<MovieBase>()

        result.add(MovieBase(968051,"", "", ""))
        result.add(MovieBase(926393,"", "", ""))
        result.add(MovieBase(678512,"", "", ""))

        return result
    }

    private fun getMovieList(){
        CoroutineScope(Dispatchers.IO).launch {
            val movieRepository = MovieRepository()
            val result: List<MovieBase>? = movieRepository.getMovieList(Constants.API_KEY)
            Log.d("Salida", result.toString()?:"")
            CoroutineScope(Dispatchers.Main).launch {
                setUpRecyclerView(result?.toCollection(ArrayList())?:ArrayList())
            }
        }
    }

}