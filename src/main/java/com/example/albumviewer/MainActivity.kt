package com.example.albumviewer

import android.os.Bundle
import android.text.style.BackgroundColorSpan
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.mutableStateOf
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.albumviewer.ui.theme.AlbumviewerTheme
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonColors
import androidx.compose.ui.res.stringResource
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AlbumviewerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }
    var imageResource = when(result) {
        1->R.drawable.lemon_tree
        2->R.drawable.lemon_squeeze
        3->R.drawable.lemon_restart
        4->R.drawable.lemon_drink
        else-> R.drawable.lemon_tree
    }
    var stringResources = when(result){
        1->"step1"
        2->"step2"
        3->"step3"
        4->"step4"
        else-> "step1"
    }

    Column(modifier = Modifier.fillMaxSize()){
        Text(
            text = "Lemon maker",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(color = Color.Yellow)
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 10.dp),
            style = TextStyle(
                color = Color.DarkGray,
                fontSize = 44.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Column( modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(), horizontalAlignment = Alignment.CenterHorizontally){
            Box() {
                Button(
                    onClick = {
                        result = result + 1
                        if (result > 4) {
                            result = 1
                        }
                    },
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan)
                ) {
                    Image(
                        painter = painterResource(imageResource),
                        contentDescription = null,
                        modifier = Modifier
                            .size(250.dp)
                            .padding(10.dp)
                    )
                }
            }

            Text(
                text = stringResources,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AlbumviewerTheme {
        Greeting()
    }
}