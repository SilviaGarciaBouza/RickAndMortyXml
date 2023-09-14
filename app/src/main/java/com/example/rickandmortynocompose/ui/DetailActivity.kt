package com.example.rickandmortynocompose.ui

import android.app.Activity
import android.content.Context
import android.nfc.NfcAdapter.EXTRA_ID
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.example.rickandmortynocompose.data.RetrofitCLient
import com.example.rickandmortynocompose.data.RetrofitResponse
import com.example.rickandmortynocompose.data.RikyItemResponse
import com.example.rickandmortynocompose.databinding.ActivityDetailBinding
import com.example.rickandmortynocompose.domain.DoListRikyListUseCase
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ActivityContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@AndroidEntryPoint

class DetailActivity : AppCompatActivity() {

    private val viewModel: RikyViewModel by viewModels()
    private lateinit var retrofit: Retrofit
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id: Int = intent.extras?.getInt(EXTRA_ID) ?: 1
        //val id: String = intent.getStringExtra(EXTRA_ID).orEmpty()
        retrofit = getRetrofitDetail()
        getCharacter(id)
    }

    private fun getCharacter(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse: Response<RikyItemResponse> =
                retrofit.create(RetrofitCLient::class.java).getCharacter(id)
            if (myResponse.isSuccessful) {
                val response: RikyItemResponse? = myResponse.body()
                if (response != null) {
                    //las viestas tienen q ir en hilo ppal y no en secundarios
                    runOnUiThread {
                        initUI(response)
                    }
                }
            } else {
                Log.i("SearchProblem", "No funciona")
                Toast.makeText(this@DetailActivity, "Vuelve a la página inicial", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun initUI(item:RikyItemResponse){
        // binding.tvDetail =
        // val characterList = viewModel.callList()
        Picasso.get().load(item.rikiImage).into(binding.ivDetail)
        binding.tvDetail.text=  item.rikiName

    }

    //RETROFIT: Crea el retrofut
    private fun getRetrofitDetail(): Retrofit {
            return Retrofit.Builder()
                //Primera parte de la url acabado en /
                .baseUrl("https://rickandmortyapi.com/")
                //para convertir el gson en la clase
                .addConverterFactory(GsonConverterFactory.create())
                //para construir el retrofit
                .build()
        }

    }




