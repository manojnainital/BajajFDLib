package com.nivesh.production.bajajfd.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.nivesh.production.bajajfd.`interface`.BajajFDInterface
import com.nivesh.production.bajajfd.databinding.FragmentStepOneBinding
import com.nivesh.production.bajajfd.viewModel.StepOneViewModel

class StepOneFragment : Fragment() {
    private lateinit var stepOneViewModel: StepOneViewModel
    private var _binding: FragmentStepOneBinding? = null
    private val binding get() = _binding!!

    private lateinit var bajajFDInterface: BajajFDInterface

    companion object {
        fun getInstance(fdInterface: BajajFDInterface): StepOneFragment {
            val stepOneFragment = StepOneFragment()
            stepOneFragment.setApi(fdInterface)
            return stepOneFragment
        }
    }

    private fun setApi(bajajFDInterfaces: BajajFDInterface) {
        bajajFDInterface = bajajFDInterfaces
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        stepOneViewModel = ViewModelProvider(this)[StepOneViewModel::class.java].apply {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentStepOneBinding.inflate(inflater,container,false)
        val root = binding.root

        stepOneViewModel.text.observe(viewLifecycleOwner) {
        }

        binding.tvPersonalDetails.setOnClickListener {
            stepOneViewModel.setUpVisibility(binding.llPersonalDetail)
        }

        binding.tvNomineeDetails.setOnClickListener {
            stepOneViewModel.setUpVisibility(binding.llNomineeDetail)
        }

        binding.tvBankDetails.setOnClickListener {
            stepOneViewModel.setUpVisibility(binding.llBankDetails)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}