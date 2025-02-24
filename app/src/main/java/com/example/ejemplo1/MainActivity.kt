package com.example.ejemplo1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ejemplo1.ui.theme.Ejemplo1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

                GreetingPreview()

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Column {
        ImageWithBackgroundColor()

        var precio by remember { mutableStateOf(TextFieldValue("")) }
        var descuento by remember { mutableStateOf(TextFieldValue("")) }
        var resultado by remember { mutableStateOf("") }

        textFieldPrecio(precio) { precio = it }
        textFieldDescuento(descuento) { descuento = it }
        botonCalcular(precio, descuento) { resultado = it }
        etiquetaResultado(resultado)
    }
}

@Composable
fun ImageWithBackgroundColor()
{
    Image(
        painter = painterResource(id = R.drawable.tienda_online),
        contentDescription = "tienda",
        modifier = Modifier
            .size(300.dp)
            .background(Color.Green)
            .padding(5.dp)
    )
}

@Composable
fun textFieldPrecio(precio: TextFieldValue, onValueChange: (TextFieldValue) -> Unit)
{
    TextField(
        value = precio,
        onValueChange = onValueChange,
        label = { Text(text = "$ Precio") },
        placeholder = { Text(text = "Introduzca el precio de un producto") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
    )
}

@Composable
fun textFieldDescuento(descuento: TextFieldValue, onValueChange: (TextFieldValue) -> Unit)
{
    TextField(
        value = descuento,
        onValueChange = onValueChange,
        label = { Text(text = "Descuento %") },
        placeholder = { Text(text = "Introduzca el descuento del producto") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
    )
}

@Composable
fun botonCalcular(precio: TextFieldValue, descuento: TextFieldValue, onResult: (String) -> Unit)
{
    Button(onClick = {
        // Convertir los valores a Float y calcular el descuento
        val precioValue = precio.text.toFloatOrNull() ?: 0f
        val descuentoValue = descuento.text.toFloatOrNull() ?: 0f
        val precioConDescuento = precioValue - (precioValue * (descuentoValue / 100))
        val resultado = "%.2f".format(precioConDescuento) // Formatear a dos decimales
        onResult(resultado)
    }) {
        Text(text = "Calcular")
    }
}

@Composable
fun etiquetaResultado(resultado: String)
{
    Text(
        text = "El precio con descuento es: $resultado",
        fontSize = 20.sp,
        modifier = Modifier.padding(top = 16.dp)
    )
}

