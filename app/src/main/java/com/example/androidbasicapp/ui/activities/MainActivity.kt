package com.example.androidbasicapp.ui.activities

import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidbasicapp.R
import com.example.androidbasicapp.ui.receiver.AirplaneModeReceiver
import com.example.androidbasicapp.ui.theme.AndroidBasicAppTheme
import java.util.Locale

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<SampleClassViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return SampleClassViewModel("Hello") as T
                }
            }
        }
    )

    private val airplaneModeReceiver by lazy { AirplaneModeReceiver() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        registerReceiver(airplaneModeReceiver, IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED))

        println("MainActivity >>> onCreate")

        val conf = resources.configuration
        val local = "ta"
        val locale = Locale(local)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            conf.setLocale(locale)
            conf.setLayoutDirection(locale)
            resources.updateConfiguration(conf, resources.displayMetrics)
            /**Deprecated**/
        } else {
            conf.setLocale(locale)
            conf.setLayoutDirection(locale)
            createConfigurationContext(conf)
        }

        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = colorResource(id = viewModel.color.value)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.res_hash), contentDescription = "",
                    modifier = Modifier.fillMaxWidth()
                )
                Button(
                    onClick = {
//                        viewModel.changeBackgroundColor(R.color.teal_200)
//                        Intent(this,SecondActivity::class.java).apply {
//                            startActivity(this)
//                        }


//                        Intent(Intent.ACTION_MAIN).also {
//                            it.`package` = "com.google.android.youtube"
//                            startActivity(it)
//                        }

                        val intent = Intent(Intent.ACTION_SEND).apply {
                            type = "text/plain"
                            putExtra(Intent.EXTRA_EMAIL, arrayOf("mohan@gmail.com"))
                            putExtra(Intent.EXTRA_SUBJECT,"mohan k")
                            putExtra(Intent.EXTRA_TEXT,"mohan rwhfurwgyu ")
                        }
                        startActivity(intent)

                    }, modifier = Modifier
                        .requiredHeight(120.dp)
                        .requiredWidth(120.dp)
                        .padding(2.dp)
                ) {
                    Text(
                        text = getString(R.string.hello),
                        color = Color.Blue,
                        maxLines = 1,
                        softWrap = true,
                        minLines = 1
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
        unregisterReceiver(airplaneModeReceiver)
        println("MainActivity >>> onDestroy")
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        val uri =if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            intent.getParcelableExtra(Intent.EXTRA_STREAM, Uri::class.java)
        }
        else{
            intent.getParcelableExtra(Intent.EXTRA_STREAM)
        }
        println("intent.getParcelableExtra(Intent.EXTRA_STREAM, Uri::class.java) >>>$uri")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        color = colorResource(id = R.color.black),
        modifier = modifier,
        textAlign = TextAlign.Left
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidBasicAppTheme {
        Greeting("Android")
    }
}