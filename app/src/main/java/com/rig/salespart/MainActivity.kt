package com.rig.salespart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rig.salespart.databinding.ActivityMainBinding
import com.rig.salespart.recyclerview.SalesAdapter
import com.rig.salespart.viewmodel.MyViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var myviewmodel:MyViewModel
    private var layoutManager : RecyclerView.LayoutManager?=null
    private var adapter: RecyclerView.Adapter<SalesAdapter.MyViewHolder>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myviewmodel=ViewModelProvider(this).get(MyViewModel::class.java)

        var locations = arrayListOf<String>(
            "MaYanGone",
            "Insein",
            "ShwePyiTar",
            "Hlaing",
            "KaMaYout",
            "SanChaung",
            "KyiMyintNaing",
            "Ahlone",
            "North Dagon",
            "South Dagon",
            "ThinGanGyun",
            "YanKin",
            "Tamwe",
            "ThaKeTa"
        )
        adapter = SalesAdapter(locations)
        layoutManager = GridLayoutManager(this,5)
        binding.locationRecycler.layoutManager = layoutManager
        binding.locationRecycler.adapter = adapter
    }
}