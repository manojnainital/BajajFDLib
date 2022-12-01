package com.nivesh.production.bajajfd.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nivesh.production.bajajfd.R
import com.nivesh.production.bajajfd.`interface`.BajajFDInterface
import com.nivesh.production.bajajfd.databinding.FragmentStepStartBinding
import com.nivesh.production.bajajfd.viewModel.StepStartViewModel

class StepStartFragment : Fragment() {

    private lateinit var viewModel: StepStartViewModel
    private lateinit var stepStartViewModel: StepStartViewModel
    private var _binding: FragmentStepStartBinding? = null
    private val binding get() = _binding!!

    private lateinit var bajajFDInterface: BajajFDInterface

    companion object {
        fun getInstance(fdInterface: BajajFDInterface): StepStartFragment{
            val stepStartFragment = StepStartFragment()
            stepStartFragment.setApi(fdInterface)
            return stepStartFragment
        }
    }

    private fun setApi(bajajFDInterfaces: BajajFDInterface) {
        bajajFDInterface = bajajFDInterfaces
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        stepStartViewModel = ViewModelProvider(this)[StepStartViewModel::class.java].apply {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStepStartBinding.inflate(inflater,container,false)
        val root = binding.root

        binding.txtInterestTenure.setOnClickListener {

        }

        binding.btnNext.setOnClickListener {
            bajajFDInterface.stepOneApi("stepOneResponse")
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}