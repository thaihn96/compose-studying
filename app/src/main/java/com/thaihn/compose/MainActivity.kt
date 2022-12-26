package com.thaihn.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
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
                    Contact(name = "Ngọc Thái", position = "Android developer")
                }
            }
        }
    }
}

data class Contact(
    val name: String? = null,

    val position: String? = null,

    val image: String? = null
)

@Composable
fun ItemContact(contact: Contact) {
    Row(modifier = Modifier.padding(10.dp)) {
        if (contact.image != null) {
            AsyncImage(
                model = contact.image,
                contentDescription = stringResource(id = R.string.contentDescriptionAvatar)
            )
        } else {
            Image(
                painter = painterResource(id = R.drawable.tree),
                contentDescription = stringResource(id = R.string.contentDescriptionAvatar),
                modifier = Modifier.size(50.dp),
                contentScale = ContentScale.Crop
            )
        }
        Column(
            modifier = Modifier
                .padding(start = 10.dp)
                .fillMaxWidth()
                .wrapContentHeight()
                .align(Alignment.CenterVertically),
        ) {
            Text(
                text = contact.name ?: "",
                fontSize = 16.sp,
                color = Color.Blue,
                fontWeight = FontWeight.Bold,
                fontFamily = robotoFamily,
            )
            Text(
                text = contact.position ?: "",
                fontSize = 12.sp,
                fontFamily = robotoFamily,
                fontWeight = FontWeight.Medium,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        ItemContact(Contact(name = "Ngoc Thai", position = "Android developer"))
    }
}
