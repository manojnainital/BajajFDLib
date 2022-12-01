package com.nivesh.production.bajajfd.ui.activity

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.viewpager.widget.ViewPager
import com.nivesh.production.bajajfd.`interface`.BajajFDInterface
import com.nivesh.production.bajajfd.adapter.SectionsPagerAdapter
import com.nivesh.production.bajajfd.databinding.BajajFdMainActivityBinding
import com.nivesh.production.bajajfd.ui.fragment.*
import com.nivesh.production.bajajfd.util.Colors

class BajajFdMainActivity : AppCompatActivity(),BajajFDInterface {
    private lateinit var binding: BajajFdMainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init(){
        binding = BajajFdMainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgBack.setOnClickListener {
            finish()
        }

        // steps setting
        setBackground(selectedShape(), defaultShape(), defaultShape(), defaultShape())

        // set viewPager
        val sectionsPagerAdapter = SectionsPagerAdapter(this@BajajFdMainActivity, supportFragmentManager)
        val viewPager: ViewPager = binding.viewPager
        sectionsPagerAdapter.addFragment(StepStartFragment.getInstance(this@BajajFdMainActivity))
        sectionsPagerAdapter.addFragment(StepOneFragment.getInstance(this@BajajFdMainActivity))
        sectionsPagerAdapter.addFragment(StepTwoFragment.getInstance(this@BajajFdMainActivity))
        sectionsPagerAdapter.addFragment(StepThreeFragment.getInstance(this@BajajFdMainActivity))
        sectionsPagerAdapter.addFragment(StepFourFragment.getInstance(this@BajajFdMainActivity))
        viewPager.adapter = sectionsPagerAdapter

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                Log.e("onPageScrolled", "-->".plus(position))
            }

            override fun onPageSelected(position: Int) {
                Log.e("onPageSelected", "-->".plus(position))
                when (position) {
                    0 -> {
                        setBackground(
                            defaultShape(),
                            defaultShape(),
                            defaultShape(),
                            defaultShape()
                        )
                    }
                    1 -> {
                        setBackground(
                            selectedShape(),
                            defaultShape(),
                            defaultShape(),
                            defaultShape()
                        )
                    }
                    2 -> {
                        setBackground(
                            selectedShape(),
                            selectedShape(),
                            defaultShape(),
                            defaultShape()
                        )
                    }
                    3 -> {
                        setBackground(
                            selectedShape(),
                            selectedShape(),
                            selectedShape(),
                            defaultShape()
                        )
                    }
                    4 ->{
                        setBackground(
                            selectedShape(),
                            selectedShape(),
                            selectedShape(),
                            selectedShape()
                        )
                    }
                }
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })
    }

    // set Default Step
    private fun defaultShape(): GradientDrawable {
        val shape = GradientDrawable()
        shape.shape = GradientDrawable.OVAL
        shape.setColor(Color.WHITE)
        shape.setStroke(6, Color.parseColor(Colors.colorDefault))
        return shape
    }

    // set Selected Step
    private fun selectedShape(): GradientDrawable {
        val shape = GradientDrawable()
        shape.shape = GradientDrawable.OVAL
        shape.setColor(Color.parseColor(Colors.colorDefault))
        shape.setStroke(6, Color.parseColor(Colors.colorDefault))
        return shape
    }

    // set background for selected/ default step
    private fun setBackground(
        drawable: Drawable?,
        drawable1: Drawable?,
        drawable2: Drawable?,
        drawable3: Drawable?
    ) {
        binding.step1.background = drawable
        binding.step2.background = drawable1
        binding.step3.background = drawable2
        binding.step4.background = drawable3
    }

    // step 1 response
    override fun stepOneApi(data: String?) {
        Log.e("stepOneApi", " response ---> $data")
    }

    // step 2 response
    override fun stepTwoApi(data: String?) {
        Log.e("stepTwoApi", " response ---> $data")
    }

    // step 3 response
    override fun stepThreeApi(data: String?) {
        Log.e("stepThreeApi", " response ---> $data")
    }

    // step 4 response
    override fun stepFourApi(data: String?) {
        Log.e("stepFourApi", " response ---> $data")
    }
}