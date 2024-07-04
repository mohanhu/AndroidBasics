package com.example.androidbasicapp

import android.os.Build
import android.os.Bundle
import android.os.LocaleList
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidbasicapp.ui.activities.SampleClassViewModel
import com.example.androidbasicapp.ui.theme.AndroidBasicAppTheme
import java.util.Locale

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<SampleClassViewModel>(
        factoryProducer = {
            object :ViewModelProvider.Factory{
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return SampleClassViewModel("Hello") as T
                }
            }
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        println("MainActivity >>> onCreate")

        val conf = resources.configuration
        val local = "ta"
        val locale = Locale(local)
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            conf.setLocale(locale)
            conf.setLayoutDirection(locale)
            resources.updateConfiguration(conf,resources.displayMetrics) /**Deprecated**/
        }
        else{
            conf.setLocale(locale)
            conf.setLayoutDirection(locale)
            createConfigurationContext(conf)
        }

        setContent {

                Surface(modifier = Modifier.fillMaxSize(),color = colorResource(id = viewModel.color.value)) {

                    Image(painter = painterResource(id = R.drawable.res_hash), contentDescription = "",
                        modifier = Modifier.fillMaxWidth())
                    Button(onClick = {
                        viewModel.changeBackgroundColor(R.color.teal_200)
                    },  modifier = Modifier
                        .requiredHeight(120.dp)
                        .requiredWidth(120.dp)
                        .padding(2.dp)
                    ) {
                        Text(text = getString(R.string.hello), color = Color.Blue, maxLines = 1, softWrap = true, minLines = 1)
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