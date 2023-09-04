package com.example.rickandmortynocompose

import android.content.Intent
import android.nfc.NfcAdapter.EXTRA_ID
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
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
import com.example.rickandmortynocompose.ui.DetailActivity


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
        initUi()

    }
    fun initUi() {
        adapterList = AdapterList (viewModel.callList(), {navigateToDetailActivity(it)})
        binding.rvList.setHasFixedSize(true)
//el rvHero es el id
        binding.rvList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//listAdapter es los datos q le pasas
        binding.rvList.adapter = adapterList
    }


    private fun navigateToDetailActivity(id:Int) {
        val intent = Intent(this, DetailActivity::class.java)
       // intent.putExtra(EXTRA_ID, id)
        intent.putExtra(EXTRA_ID, id)

        startActivity(intent)
    }

}



