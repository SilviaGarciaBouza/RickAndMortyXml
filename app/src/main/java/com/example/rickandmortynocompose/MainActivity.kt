package com.example.rickandmortynocompose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortynocompose.databinding.ActivityMainBinding
import com.example.rickandmortynocompose.ui.AdapterList
import com.example.rickandmortynocompose.ui.ImagesUiStates
import com.example.rickandmortynocompose.ui.RikyViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import com.example.rickandmortynocompose.R
import com.google.android.material.internal.Experimental
import androidx.activity.ComponentActivity
import androidx.activity.viewModels


data class ItemList(val id: Int, val name: String, val Image: String)

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

   val viewModel: RikyViewModel by viewModels()



    private lateinit var rvList: RecyclerView
    private lateinit var adapterList: AdapterList



        override fun onCreate(savedInstanceState: Bundle?) {


            super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()

    }

    fun initRecyclerView() {
//el rvHero es el id
        binding.rvList.layoutManager = LinearLayoutManager(this)
//listAdapter es los datos q le pasas
        binding.rvList.adapter = AdapterList(viewModel.callList())
    }



}


/*
val lifecycle = LocalLifecycleOwner.current.lifecycle
val uiState by produceState<ImagesUiStates>(initialValue =ImagesUiStates.Loading , key1 = lifecycle, key2 = viewModel)
{
    lifecycle.repeatOnLifecycle(state = Lifecycle.State.STARTED) {
        viewModel.usiState.collect{value = it}
    }
}
when (uiState) {
    is ImagesUiStates.Error -> Toast.makeText(
    LocalContext.current,
    "Error, try again",
    Toast.LENGTH_SHORT
    ).show()

    is ImagesUiStates.Loading -> MyProgressBar()

    is ImagesUiStates.Success -> {

        //TODO mostrar lalista
    }
}
*/