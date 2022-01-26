package com.sidney.task

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat.startActivity
import com.sidney.task.activity.TestActivity
import com.sidney.task.ui.theme.App20220104Theme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App20220104Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

val stringLengthFunc: (String) -> Int = { input ->
    input.length
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
    Button(onClick = {

        }) {

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    App20220104Theme {
        Greeting("Android")
    }
}