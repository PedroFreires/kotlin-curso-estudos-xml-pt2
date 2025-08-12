package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.fragment.findNavController
import com.example.fragments.databinding.FragmentABinding

class FragmentA : Fragment() {

    private var _binding: FragmentABinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentABinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListener()

        listenerFragment()
    }
    private fun initListener() {
        val name = "Olá, Pedro"

        binding.btnNext.setOnClickListener {
            val action = FragmentADirections
                .actionFragmentAToFragmentB(name)
            findNavController().navigate(action)
        }
    }

    private fun listenerFragment() {
        //Observar todos os listener que tiver resultados dos fragments
        parentFragmentManager.setFragmentResultListener(
            "KEY",
            viewLifecycleOwner
        ) {
            key, bundle ->
            val name = bundle["KEY"].toString()
            Toast.makeText(requireContext(), name, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}