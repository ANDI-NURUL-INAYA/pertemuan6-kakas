package com.example.daftarbukuproject

object DataBuku {
    private val judulbuku = arrayOf(
        "Mariposa",
        "Geez and Ann",
        "Dilan",
        "Milea",
        "Koala Kumal",
        "Pulang",
        "Mantappu Jiwa",
        "Jingga dan Senja",
        "Sebuah Usaha Melupakan",
        "Sebuah Seni Untuk Bersikap Bodo Amat")

    private val bukuImages = intArrayOf(
        R.drawable.mariposa,
        R.drawable.geez_ann,
        R.drawable.dilan,
        R.drawable.milea,
        R.drawable.koala_kumal,
        R.drawable.pulang,
        R.drawable.mantappujiwa,
        R.drawable.jingga_senja,
        R.drawable.boy_candra,
        R.drawable.mark_manson)

    val listData:ArrayList<Buku>
    get() {
        val list = arrayListOf<Buku>()
        for (position in judulbuku.indices){
            val buku = Buku()
            buku.judul = judulbuku[position]
            buku.gambar = bukuImages[position]
            list.add(buku)

        }
           return list
    }
}