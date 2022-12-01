package com.nivesh.production.bajajfd.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.nivesh.production.bajajfd.`interface`.BajajFDInterface
import com.nivesh.production.bajajfd.databinding.FragmentStepFourBinding
import com.nivesh.production.bajajfd.viewModel.StepFourViewModel

class StepFourFragment : Fragment() {

    private lateinit var stepFourViewModel: StepFourViewModel
    private var _binding: FragmentStepFourBinding? = null
    private val binding get() = _binding!!

    private lateinit var bajajFDInterface: BajajFDInterface
    companion object {
        fun getInstance(fdInterface: BajajFDInterface): StepFourFragment {
            val stepFourFragment = StepFourFragment()
            stepFourFragment.setApi(fdInterface)
            return stepFourFragment
        }
    }
    private fun setApi(bajajFDInterfaces: BajajFDInterface) {
        bajajFDInterface = bajajFDInterfaces
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        stepFourViewModel = ViewModelProvider(this)[StepFourViewModel::class.java].apply {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentStepFourBinding.inflate(inflater, container, false)
        val root = binding.root

//        val textView: TextView = binding.sectionLabel
//        stepFourViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
//
//        binding.btnClick.setOnClickListener {
//            bajajFDInterface.stepFourApi("stepFourResponse")
//        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}