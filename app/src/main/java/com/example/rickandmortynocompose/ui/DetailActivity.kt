package com.example.rickandmortynocompose.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.rickandmortynocompose.databinding.ActivityDetailBinding
import com.example.rickandmortynocompose.domain.DoListRikyListUseCase
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class DetailActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_ID= "extra_id"
    }

    private val viewModel: RikyViewModel by viewModels()

    private lateinit var binding: ActivityDetailBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id: Int = intent.extras?.getInt(EXTRA_ID) ?:1
        initUI(id)
    }




    private fun initUI(id: Int){
       // binding.tvDetail =
       // val characterList = viewModel.callList()
        Picasso.get().load(viewModel.callList()[id].rikiImage).into(binding.ivDetail)
        binding.tvDetail.text=  viewModel.callList()[id].rikiName

    }
}




