package com.promzmunac.viewmodelandlivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.promzmunac.viewmodelandlivedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var viewmodel: MyViewmodel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewmodel = ViewModelProvider(this).get(MyViewmodel::class.java)
        viewmodel.message.observe(this){
            binding.textmessage.text = it
        }
        viewmodel.data.observe(this) { binding.dataView.text = "$it Mb" }

        viewmodel.load.observe(this){
           // binding.dataView.text = "$it Mb"

            Toast.makeText(this,
            "you just subscribed $it Mb worth of data", Toast.LENGTH_SHORT).show()}

        binding.button.setOnClickListener { viewmodel.loadData(1) }
        binding.button2.setOnClickListener { viewmodel.loadData(2) }

    }
}