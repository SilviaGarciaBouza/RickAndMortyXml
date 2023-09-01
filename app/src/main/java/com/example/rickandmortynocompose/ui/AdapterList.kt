package com.example.rickandmortynocompose.ui



import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortynocompose.ItemList
import com.example.rickandmortynocompose.MainActivity
import com.example.rickandmortynocompose.R
import com.example.rickandmortynocompose.data.RikyItemResponse
import com.example.rickandmortynocompose.databinding.ActivityMainBinding
import com.example.rickandmortynocompose.databinding.ItemBinding
import com.squareup.picasso.Picasso

class AdapterList(
    val myList: List<RikyItemResponse>,
    private val onItemSelected: (Int) -> Unit
): RecyclerView.Adapter<AdapterList.ListHolder>(){


    class ListHolder(val view: View): RecyclerView.ViewHolder(view) {
        //usas bind(aqui dentro el view de arriba del val view) y el layoutItemBinding es por lo del onCreateViewHolder de abajo
        val binding = ItemBinding.bind(view)

        fun render(itemL: RikyItemResponse,onItemSelected: (Int) -> Unit) {
            // itemHEroM es lo que está en paréntesis en render
            binding.tvItem.text = itemL.rikiName
            Picasso.get().load(itemL.rikiImage).into(binding.ivItem)
            //load(la imagen q quieres cargar) into(dnd quieres cargar la imagen)
            binding.root.setOnClickListener{onItemSelected(itemL.rikiId)}


        }
    }

    override fun getItemCount(): Int = myList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        //(R.layout.layout_item_hero. Coges so paea definir el val binding de arriba
        return ListHolder(layoutInflater.inflate(R.layout.item, parent, false))

    }

    override fun onBindViewHolder(holder: ListHolder, position: Int) {
        holder.render(myList[position],onItemSelected)
    }

}


