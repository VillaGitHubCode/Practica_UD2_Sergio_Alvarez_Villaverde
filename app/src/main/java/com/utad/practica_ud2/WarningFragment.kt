package com.utad.practica_ud2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.utad.practica_ud2.databinding.FragmentWarningBinding


class WarningFragment : Fragment() {

    private lateinit var _binding: FragmentWarningBinding
    private val binding: FragmentWarningBinding get() = _binding

    private var nombre : String? = null
    private var categoria : String? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWarningBinding.inflate(inflater)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if ( requireArguments().containsKey("nombre")){
            nombre = requireArguments().getString("nombre")
        }
        if ( requireArguments().containsKey("categoria")){
            categoria = requireArguments().getString("categoria")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvWarningContent.text = "Saludos $nombre, te informamos que puede haber noticias con contenido sensible, por lo que necesitamos que confirmes que eres mayor de edad"
        binding.switchEdad.setOnCheckedChangeListener { _ , isChecked ->
            activacionBotonAvanzar()
        }
        binding.btnContinuarActivityHome.setOnClickListener {
            navigateToHomeActivity()
        }

    }

    private fun activacionBotonAvanzar() {
        binding.btnContinuarActivityHome.isEnabled = false
        if (binding.switchEdad.isChecked) {
            binding.btnContinuarActivityHome.isEnabled = true
        }
    }

    private fun navigateToHomeActivity (){
        val intent = Intent(activity, HomeActivity::class.java)
        intent.putExtra("categoria", categoria)
        intent.putExtra("nombre", nombre)
        startActivity(intent)
    }

}