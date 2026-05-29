package com.bv.practica3

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun App() {
    // Variables  para capturar los textos
    var textoNombre by remember { mutableStateOf("") }
    var textoMatricula by remember { mutableStateOf("") }
    var textoAsignatura by remember { mutableStateOf("") }
    var textoHora by remember { mutableStateOf("") }
    var textoFecha by remember { mutableStateOf("") }


    // Variables controlar lo que se ve en la pantalla
    var camposCompletos by remember { mutableStateOf(true) }
    var verTarjeta by remember { mutableStateOf(false) }


    // Variables para fijar los datos dentro del Card final
    var nombreImpreso by remember { mutableStateOf("") }
    var matriculaImpresa by remember { mutableStateOf("") }
    var asignaturaImpresa by remember { mutableStateOf("") }
    var horaImpresa by remember { mutableStateOf("") }
    var fechaImpresa by remember { mutableStateOf("") }


    // Columna principal con scroll para que la app sea responsiva
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Título de la pantalla con color personalizado
        Text(
            text = "Registro de Datos Escolares",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(16.dp))


        // Campo 1: Nombre
        TextField(
            value = textoNombre,
            onValueChange = { textoNombre = it },
            label = { Text("Escribe tu Nombre") }
        )
        Spacer(modifier = Modifier.height(8.dp))


        // Campo 2: Matrícula
        TextField(
            value = textoMatricula,
            onValueChange = { textoMatricula = it },
            label = { Text("Escribe tu Matrícula") }
        )
        Spacer(modifier = Modifier.height(8.dp))


        // Campo 3: Asignatura
        TextField(
            value = textoAsignatura,
            onValueChange = { textoAsignatura = it },
            label = { Text("Escribe la Asignatura") }
        )
        Spacer(modifier = Modifier.height(8.dp))


        // Campo 4: Hora
        TextField(
            value = textoHora,
            onValueChange = { textoHora = it },
            label = { Text("Escribe la Hora") }
        )
        Spacer(modifier = Modifier.height(8.dp))


        // Campo 5: Fecha
        TextField(
            value = textoFecha,
            onValueChange = { textoFecha = it },
            label = { Text("Fecha de entrega") }
        )
        Spacer(modifier = Modifier.height(16.dp))


        // Si falta algún campo por llenar, enseñamos este aviso en color de error (rojo)
        if (!camposCompletos) {
            Text(
                text = "Alerta: No dejes campos vacíos",
                color = MaterialTheme.colorScheme.error
            )
            Spacer(modifier = Modifier.height(8.dp))
        }


        // Botón de guardado con color de contenedor secundario
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
            onClick = {
                // Validación con lógica invertida: checamos si están vacíos
                if (textoNombre.isEmpty() || textoMatricula.isEmpty() || textoAsignatura.isEmpty() || textoHora.isEmpty() || textoFecha.isEmpty()) {
                    camposCompletos = false
                    verTarjeta = false
                } else {
                    camposCompletos = true


                    // Almacenamos los datos finales en las variables del Card
                    nombreImpreso = textoNombre
                    matriculaImpresa = textoMatricula
                    asignaturaImpresa = textoAsignatura
                    horaImpresa = textoHora
                    fechaImpresa = textoFecha


                    verTarjeta = true
                }
            }
        ) {
            Text("Guardar Formulario")
        }


        Spacer(modifier = Modifier.height(16.dp))


        // Tarjeta con los datos guardados temporalmente en memoria
        if (verTarjeta) {
            Card(
                modifier = Modifier.padding(12.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text ="Información Registrada:", color = MaterialTheme.colorScheme.secondary)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "Alumno: $nombreImpreso")
                    Text(text = "Matrícula: $matriculaImpresa")
                    Text(text = "Materia: $asignaturaImpresa")
                    Text(text = "Horario: $horaImpresa")
                    Text(text = "Fecha: $fechaImpresa")
                }
            }
        }
    }
}
