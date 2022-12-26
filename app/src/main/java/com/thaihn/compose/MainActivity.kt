package com.thaihn.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thaihn.compose.ui.theme.MyApplicationTheme
import com.thaihn.compose.ui.theme.robotoFamily

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CustomText("Android")
                }
            }
        }
    }
}

@Composable
fun CustomText(name: String) {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .background(color = Color.Cyan)
    ) {
        Text(
            text = "Hi $name!",
            fontSize = 16.sp,
            color = Color.Blue,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(top = 10.dp),
            fontFamily = robotoFamily,
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Hoang Ngoc Thai",
            fontSize = 12.sp,
            fontFamily = robotoFamily,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(start = 16.dp, bottom = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        CustomText("Android")
    }
}