package com.saltwortdevs.socialdevs.view.auth.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.saltwortdevs.socialdevs.R

@Preview
@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel()) {
    /*var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }*/
    val ioState by loginViewModel.uiState.collectAsStateWithLifecycle()

    Scaffold { padding ->
        Column(Modifier
            .padding(padding)
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(24.dp)
            ,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Español (España)", color = MaterialTheme.colorScheme.onBackground, modifier = Modifier.padding(12.dp))
            Spacer(Modifier.weight(1f))
            Image(
                modifier = Modifier.size(72.dp),
                painter = painterResource(R.drawable.logo),
                contentDescription = "Social devs"
            )
            Spacer(Modifier.weight(1f))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(25),
                value = ioState.email,
                label = {Text("Usuario, correo electrónico o movil", color = MaterialTheme.colorScheme.onBackground)},
                onValueChange = { loginViewModel.onEmailChanged( it) }
                )
            Spacer(Modifier.height(12.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(25),
                label = {Text("Contraseña", color = MaterialTheme.colorScheme.onBackground)},
                value = ioState.password,
                onValueChange = { loginViewModel.onPasswordChanged( it) }
            )
            Spacer(Modifier.height(12.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
                onClick = {},
                enabled = ioState.isLoadingEnabled
                ) {
                Text("Iniciar sesión", color = MaterialTheme.colorScheme.primary, modifier = Modifier.padding(vertical = 4.dp))
            }
            TextButton({}) {Text("¿Has olvidado la contraseña?", color = MaterialTheme.colorScheme.onSurfaceVariant)}
            Spacer(Modifier.weight(1f))
            OutlinedButton(modifier = Modifier.fillMaxWidth(), onClick = {}, colors = ButtonDefaults.outlinedButtonColors(MaterialTheme.colorScheme.primary)) { Text("Crear cuenta nueva", color = MaterialTheme.colorScheme.onPrimary)}
            Icon(
                modifier = Modifier.width(120.dp).padding(vertical = 22.dp),
                painter = painterResource(R.drawable.ic_meta),
                contentDescription = "Icono meta",
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}