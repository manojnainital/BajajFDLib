package com.nivesh.production.bajajfd.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.nivesh.production.bajajfd.`interface`.BajajFDInterface
import com.nivesh.production.bajajfd.databinding.FragmentStepThreeBinding
import com.nivesh.production.bajajfd.viewModel.StepThreeViewModel

class StepThreeFragment : Fragment() {

    private lateinit var stepThreeViewModel: StepThreeViewModel
    private var _binding: FragmentStepThreeBinding? = null
    private val binding get() = _binding!!

    private lateinit var bajajFDInterface: BajajFDInterface
    companion object {
        fun getInstance(fdInterface: BajajFDInterface): StepThreeFragment {
            val stepThreeFragment = StepThreeFragment()
            stepThreeFragment.setApi(fdInterface)
            return stepThreeFragment
        }
    }
    private fun setApi(bajajFDInterfaces: BajajFDInterface) {
        bajajFDInterface = bajajFDInterfaces
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        stepThreeViewModel = ViewModelProvider(this)[StepThreeViewModel::class.java].apply {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentStepThreeBinding.inflate(inflater, container, false)
        val root = binding.root

//        val textView: TextView = binding.sectionLabel
//        stepThreeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

//        binding.btnClick.setOnClickListener {
//            bajajFDInterface.stepThreeApi("stepThreeResponse")
//        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}