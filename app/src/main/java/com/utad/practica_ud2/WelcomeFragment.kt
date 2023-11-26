package com.utad.practica_ud2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN
import com.utad.practica_ud2.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    private lateinit var _binding:FragmentWelcomeBinding
    private val binding : FragmentWelcomeBinding get() = _binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWelcomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        comprobacionCheckBox()
        binding.btnContinuarAWarning.setOnClickListener{
            comprobacionInformacion()
        }

    }

    private fun comprobacionCheckBox() {

        binding.cbGenerales.setOnCheckedChangeListener { _ , isChecked ->
            if (isChecked){
                binding.cbDeportes.isChecked = false
                binding.cbTecnologia.isChecked = false
                binding.btnContinuarAWarning.isEnabled = true

            }
            else{
                binding.btnContinuarAWarning.isEnabled = false
            }
        }
        binding.cbDeportes.setOnCheckedChangeListener { _ , isChecked ->
            if (isChecked){
                binding.cbGenerales.isChecked = false
                binding.cbTecnologia.isChecked = false
                binding.btnContinuarAWarning.isEnabled = true
            }
            else{
                binding.btnContinuarAWarning.isEnabled = false
            }
        }
        binding.cbTecnologia.setOnCheckedChangeListener { _ , isChecked ->
            if (isChecked){
                binding.cbDeportes.isChecked = false
                binding.cbGenerales.isChecked = false
                binding.btnContinuarAWarning.isEnabled = true
            }
            else{
                binding.btnContinuarAWarning.isEnabled = false
            }
        }

    }

    private fun comprobacionInformacion(){

        val nombre = binding.etNombre.text.toString()
        var categoria =""
        if(binding.cbGenerales.isChecked){
            categoria = "Generales"
        }
        else if(binding.cbDeportes.isChecked){
            categoria = "Deportes"
        }
        else{
            categoria = "Tecnologia"
        }
        if (nombre.isNotEmpty()){
            navigateToWarningFragment(nombre, categoria)
        }
        else{
            Toast.makeText(requireContext(), "Rellena todos los campos",Toast.LENGTH_SHORT).show()
        }
    }

    private fun navigateToWarningFragment(nombre: String, categoria: String) {

        val bundle = Bundle()
        bundle.putString("nombre", nombre)
        bundle.putString("categoria", categoria)

        val warningFragment = WarningFragment()
        warningFragment.arguments = bundle

        val transaction = parentFragmentManager.beginTransaction()
        transaction.setReorderingAllowed(true)
        transaction.replace(R.id.fcv_ActivityMain, warningFragment)
        transaction.setTransition(TRANSIT_FRAGMENT_OPEN)
        transaction.addToBackStack(null)
        transaction.commit()

    }


}