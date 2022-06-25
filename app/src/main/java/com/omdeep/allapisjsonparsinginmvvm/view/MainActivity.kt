package com.omdeep.allapisjsonparsinginmvvm.view
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.omdeep.allapisjsonparsinginmvvm.adapter.MainAdapter
import com.omdeep.allapisjsonparsinginmvvm.databinding.ActivityMainBinding
import com.omdeep.allapisjsonparsinginmvvm.factory.MyViewModelFactory
import com.omdeep.allapisjsonparsinginmvvm.repository.MovieRepository
import com.omdeep.allapisjsonparsinginmvvm.retrofitService.RetrofitService
import com.omdeep.allapisjsonparsinginmvvm.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel : MainViewModel
    //TODO: Getting the instance of retrofit service
    private val retrofitService = RetrofitService.getInstance()
    val adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //TODO: Get VieModel instance using ViewModelProvider.Factory
        viewModel = ViewModelProvider(this, MyViewModelFactory(MovieRepository(retrofitService))).get(
            MainViewModel::class.java
        )

        //TODO: SetAdapter in Recycler View
        binding.recyclerView.adapter = adapter

        //TODO: The observer will only receive events if the owner(activity) is in active state
        //TODO: invoked when movieList data changes
        viewModel.movieList.observe(this, Observer {
            adapter.setMoviesList(it)
        })

        //TODO: Invoked when a network exception occurred
        viewModel.errorMessage.observe(this, Observer {
            Toast.makeText(this, "Error Message: $it", Toast.LENGTH_SHORT).show()
        })

        //TODO: Calling function to get all the movies from JSONArray using retrofit
        viewModel.getAllMovies()
    }
}