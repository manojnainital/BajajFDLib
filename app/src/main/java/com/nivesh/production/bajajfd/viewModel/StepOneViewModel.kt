package com.nivesh.production.bajajfd.viewModel

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class StepOneViewModel : ViewModel() {

    private val _index = MutableLiveData<Int>()
    val text: LiveData<String> = Transformations.map(_index) {
        "Step : $it"
    }

    fun setIndex(index: Int) {
        _index.value = index
    }

    fun setUpVisibility(ll: LinearLayout) {
        if(ll.visibility== View.VISIBLE) ll.visibility = View.GONE
        else  ll.visibility = View.VISIBLE
    }
}