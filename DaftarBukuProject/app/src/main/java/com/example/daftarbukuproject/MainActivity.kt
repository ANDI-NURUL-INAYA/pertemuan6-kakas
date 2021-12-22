package com.example.daftarbukuproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), RecyclerViewClickListener {
    private lateinit var rvBuku : RecyclerView
    private var list: ArrayList<Buku> = arrayListOf()

//    final
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvBuku = findViewById(R.id.df_buku)
        rvBuku.setHasFixedSize(true)
        list.addAll(DataBuku.listData)
        showRecyclerList()
    }

    private fun showRecyclerList(){
        rvBuku.layoutManager = LinearLayoutManager(this)
        val listBukuAdapter = ListBukuAdapter(list)
        listBukuAdapter.dengar = this;
        rvBuku.adapter = listBukuAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    override fun onItemClick(view: View, list: Buku) {
//        Toast.makeText(this, list.judul, Toast.LENGTH_LONG).show()
//        startActivity(Intent(applicationContext, Detaill::class.java)).apply {
////            putExtra("com.example.myfirstapp.MESSAGE", )
//
//        }
        val intent = Intent(this, Detaill::class.java).apply {
            putExtra("judul", list.judul);
            putExtra("gambar", list.gambar);
            putExtra("desk", list.desk)
        }
        startActivity(intent)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode){
            R.id.action_bar->{
                startActivity(Intent(applicationContext, about::class.java))


            }
        }
    }
}

interface RecyclerViewClickListener {
    fun onItemClick(view: View, list: Buku);
//    fun putExtra()
}
