package com.example.daftarbukuproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListBukuAdapter (val listBuku: ArrayList<Buku>) : RecyclerView.Adapter<ListBukuAdapter.ListViewHolder>() {

    var dengar: RecyclerViewClickListener? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_buku, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
       val buku = listBuku[position]
        Glide.with(holder.itemView.context)
            .load(buku.gambar)
            .apply(RequestOptions().override(55,55))
            .into(holder.itemPhoto)

        holder.itemJudul.text = buku.judul
        holder.itemDetail.text = buku.desk
        holder.itemView.setOnClickListener{
            dengar?.onItemClick(it, listBuku[position])
        }
    }

    override fun getItemCount(): Int {
         return listBuku.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemJudul: TextView = itemView.findViewById(R.id.item_judul)
        var  itemDetail: TextView = itemView.findViewById(R.id.item_desk)
        var itemPhoto: ImageView = itemView.findViewById(R.id.item_poto)
//        val itemView = itemView;
    }
}
