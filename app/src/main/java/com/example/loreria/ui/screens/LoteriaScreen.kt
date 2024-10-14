package com.example.loreria.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Preview(showBackground = true)
@Composable
fun LoteriaScreen(navComposable: NavController = NavController(context = LocalContext.current)) {
    val cartas = (1..54).toList()

    var randomizedCartas by remember { mutableStateOf(cartas.shuffled()) }
    var currentNumber by remember { mutableIntStateOf(randomizedCartas.first()) }
    val resourceName = "carta$currentNumber"
    var title by remember { mutableStateOf("Siguiente Carta") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = LocalContext.current.resources.getIdentifier(resourceName, "drawable", LocalContext.current.packageName)),
            contentDescription = "Loteria",
            modifier = Modifier.size(500.dp)
        )
        Spacer(modifier = Modifier.size(16.dp))
        Button(
            enabled = randomizedCartas.isNotEmpty(),
            onClick = {
            if (randomizedCartas.isNotEmpty()) {
                currentNumber = randomizedCartas.first()
                randomizedCartas = randomizedCartas.drop(1)
            } else {
                title = "Juego Terminado"
            }
        }) {
            Text(text = title)
        }
        Button(onClick = {
            navComposable.popBackStack()
        }) {
            Text(text = "Reiniciar Juego")
        }
    }

}