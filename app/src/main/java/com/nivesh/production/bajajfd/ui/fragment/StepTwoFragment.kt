package com.nivesh.production.bajajfd.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.nivesh.production.bajajfd.`interface`.BajajFDInterface
import com.nivesh.production.bajajfd.databinding.FragmentStepTwoBinding
import com.nivesh.production.bajajfd.viewModel.StepTwoViewModel

class StepTwoFragment : Fragment() {

    private lateinit var stepTwoFragment: StepTwoViewModel
    private var _binding: FragmentStepTwoBinding? = null
    private val binding get() = _binding!!

    private lateinit var bajajFDInterface: BajajFDInterface
    companion object {
        fun getInstance(fdInterface: BajajFDInterface): StepTwoFragment {
            val stepTwoFragment = StepTwoFragment()
            stepTwoFragment.setApi(fdInterface)
            return stepTwoFragment
        }
    }
    private fun setApi(bajajFDInterfaces: BajajFDInterface) {
        bajajFDInterface = bajajFDInterfaces
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        stepTwoFragment = ViewModelProvider(this)[StepTwoViewModel::class.java].apply {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentStepTwoBinding.inflate(inflater, container, false)
        val root = binding.root

//        val textView: TextView = binding.sectionLabel
//        stepTwoFragment.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
//
//        binding.btnClick.setOnClickListener {
//            bajajFDInterface.stepTwoApi("stepTwoResponse")
//        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}