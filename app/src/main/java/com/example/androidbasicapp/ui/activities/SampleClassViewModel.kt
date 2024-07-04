package com.example.androidbasicapp.ui.activities

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class SampleClassViewModel(
    private val hello:String
) : ViewModel() {

    private val backgroundColor =  mutableStateOf(Color.White)
    val color = backgroundColor

    fun changeBackgroundColor(color: Color) {
        backgroundColor.value = color
    }

}