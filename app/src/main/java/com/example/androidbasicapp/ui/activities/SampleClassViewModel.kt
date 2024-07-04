package com.example.androidbasicapp.ui.activities

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.androidbasicapp.R

class SampleClassViewModel(
    private val hello:String
) : ViewModel() {

    private val backgroundColor =  mutableStateOf(R.color.white)
    val color = backgroundColor

    fun changeBackgroundColor(color: Int) {
        backgroundColor.value = color
    }

}