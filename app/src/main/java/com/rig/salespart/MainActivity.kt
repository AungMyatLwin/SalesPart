package com.rig.salespart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rig.salespart.databinding.ActivityMainBinding
import com.rig.salespart.recyclerview.SalesAdapter
import com.rig.salespart.repository.SalesRepository
import com.rig.salespart.room.SalesDatabase
import com.rig.salespart.room.SalesDatabase.Companion.getInstance
import com.rig.salespart.viewmodel.MyViewModel
import com.rig.salespart.viewmodel.MyViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var myviewmodel:MyViewModel
    private var layoutManager : RecyclerView.LayoutManager?=null
    private var adapter: RecyclerView.Adapter<SalesAdapter.MyViewHolder>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val daos =getInstance(this)!!.salesDao()
        val repository: SalesRepository=SalesRepository(daos)
        val factory = MyViewModelFactory(repository)
        myviewmodel=ViewModelProvider(this, factory = factory).get(MyViewModel::class.java)

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
        for( location in locations){
            myviewmodel.insertMap(location)
        }
        adapter = SalesAdapter(locations)
        layoutManager = GridLayoutManager(this,5)
        binding.locationRecycler.layoutManager = layoutManager
        binding.locationRecycler.adapter = adapter
    }
}