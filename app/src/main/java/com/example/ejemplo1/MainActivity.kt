package com.example.ejemplo1

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.ejemplo1.ui.theme.Ejemplo1Theme

import androidx. compose. ui. res. painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

import androidx. compose. ui. unit. sp
import org.w3c.dom.Text
import java.lang.reflect.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejemplo1Theme {
                GreetingPreview()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview()
{
    Column {
        Content1()
    }

}


@Composable
fun Content1()
{
    Text("Jesus miguel ramos hernandez",
        Modifier
            .padding(32.dp)
            .background( color =  Color.Green)

    )
}


@Composable
fun Content2()
{
    Text("JESUS MIGUEL RAMOS HERNANDEZ",
        color = Color.Red,
        modifier =  Modifier
            .padding(32.dp)
            .background(Color.Yellow)

    )
}


@Composable
fun Content3(){
    Text(
        text =  "tamaño de texto",
        color = Color.White,
        modifier =  Modifier
            .padding(32.dp)
            .background(Color.Cyan)
            .size(width = 250.dp, height = 100.dp)
    )
}

@Composable
fun Content4(){
    Text(
        text = "Texto con parent",
        color = Color.White,
        modifier = Modifier
            .background(Color.Gray)
            .padding(Dp(40f))
            .fillMaxWidth(1f)
    )
}



@Composable
fun Content5(){
    Text(
        text = "Text con 75% Height",
        color = Color.White,
        modifier = Modifier
            .padding(32.dp)
            .background(Color.Green)
            .fillMaxHeight(0.75f)//75%
    )
}





@Composable
fun FillWidthModifier() {
    Text(
        text = "Text Width Match Parent",
        color = Color.White,
        modifier = Modifier
            .background(Color.Gray)
            .padding(Dp(10f))
            .fillMaxWidth(1f))
}


@Composable
fun AlphaModifier() {
    Box(
        Modifier
            .size(250.dp)
            .alpha(0.5f)//50% opacity
            .background(Color.Red)
    )
}


@Composable
fun RotateModifier() {
    Box(
        Modifier
            .rotate(45f)
            .size(250.dp)
            .background(Color.Red)
    )
}


@Composable
fun ScaleModifier() {
    Box(
        Modifier
            .scale(scaleX = 2f, scaleY = 3f)
            .size(200.dp, 200.dp)
    )
}


@Composable
fun WeightModifier(){
    Row() {
        Column(
            Modifier.weight(1f).background(Color.Red)){
            Text(text = "Weight = 1", color = Color.White)
        }
        Column(
            Modifier.weight(1f).background(Color.Blue)){
            Text(text = "Weight = 1", color = Color.White)
        }
        Column(
            Modifier.weight(2f).background(Color.Green)
        ) {
            Text(text = "Weight = 2")
        }

    }
}


@Composable
fun BorderModifier() {
    Text(
        text = "Text with Red Border",
        modifier = Modifier
            .padding(10.dp)
            .background(Color.Yellow)
            .border(2.dp,Color.Red)
            .padding(10.dp)
    )
}


@Composable
fun ClipModifier() {
    Text(
        text = "Text with Clipped background",
        color = Color.White,
        modifier = Modifier
            .padding(Dp(10f))
            .clip(RoundedCornerShape(25.dp))
            .background(Color.Blue)
            .padding(Dp(15f))
    )
}
