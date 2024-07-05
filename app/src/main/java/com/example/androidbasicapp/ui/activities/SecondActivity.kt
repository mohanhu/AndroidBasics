package com.example.androidbasicapp.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.example.androidbasicapp.R
import com.example.androidbasicapp.ui.theme.AndroidBasicAppTheme

class SecondActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidBasicAppTheme {
                Text(text = "Second", color = colorResource(id = R.color.black),
                    modifier = Modifier.fillMaxWidth())
            }
        }
    }
}