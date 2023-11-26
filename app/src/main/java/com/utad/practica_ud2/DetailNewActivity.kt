package com.utad.practica_ud2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.navArgs
import androidx.navigation.navArgs
import com.bumptech.glide.Glide
import com.utad.practica_ud2.databinding.ActivityDetailNewBinding

class DetailNewActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityDetailNewBinding
    private val binding: ActivityDetailNewBinding get() = _binding

    private val args: DetailNewActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailNewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val newSelected = args.selectedNew
        binding.tvTitleDetailNew.text = newSelected.title
        Glide.with(this)
            .load(newSelected.image)
            .into(binding.ivImageDetailNew)
        binding.tvAuthorDetailNew.text = newSelected.author
        binding.tvDescriptionDetailNew.text = newSelected.description
    }


}