package com.example.business_card

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.Rgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.business_card.ui.theme.Business_cardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Business_cardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Preview
@Composable
fun BusinessCardApp() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(color = Color(210, 232, 212)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val image = painterResource(R.drawable.android_logo)
        Image(painter = image, contentDescription = null, modifier = Modifier
            .height(100.dp)
            .width(100.dp)
            .background(Color.DarkGray)
        )
        Text(
            text = stringResource(R.string.full_name),
            color = Color.Black,
            fontSize = 30.sp,
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            text = stringResource(R.string.title),
            color = Color(1, 109, 58),
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 600.dp)
            .width(150.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 85.dp)
        ) {
            val icon = painterResource(R.drawable.ic_baseline_local_phone_24)
            Icon(painter = icon, contentDescription = null, tint = Color(1, 109, 58))
            Text(
                text = stringResource(R.string.phone_number),
                color = Color.Black,
                fontSize = 15.sp,
                modifier = Modifier.padding(start = 15.dp)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 85.dp, top = 10.dp)
        ) {
            val icon = painterResource(R.drawable.ic_baseline_share_24)
            Icon(painter = icon, contentDescription = null, tint = Color(1, 109, 58))
            Text(
                text = stringResource(R.string.share_name),
                color = Color.Black,
                fontSize = 15.sp,
                modifier = Modifier.padding(start = 15.dp)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 85.dp, top = 10.dp)
        ) {
            val icon = painterResource(R.drawable.ic_baseline_email_24)
            Icon(painter = icon, contentDescription = null, tint = Color(1, 109, 58))
            Text(
                text = stringResource(R.string.email),
                color = Color.Black,
                fontSize = 15.sp,
                modifier = Modifier.padding(start = 15.dp)
            )
        }
    }
}