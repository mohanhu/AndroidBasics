package com.example.androidbasicapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidbasicapp.ui.theme.AndroidBasicAppTheme
import timber.log.Timber

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        println("MainActivity >>> onCreate")

        setContent {
            AndroidBasicAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        println("MainActivity >>> onStart")
    }

    override fun onResume() {
        super.onResume()
        println("MainActivity >>> onResume")
    }

    override fun onPause() {
        super.onPause()
        println("MainActivity >>> onPause")
    }

    override fun onStop() {
        super.onStop()
        println("MainActivity >>> onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("MainActivity >>> onDestroy")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidBasicAppTheme {
        Greeting("Android")
    }
}