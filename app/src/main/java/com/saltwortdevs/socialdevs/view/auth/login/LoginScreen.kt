package com.saltwortdevs.socialdevs.view.auth.login

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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.saltwortdevs.socialdevs.R
import com.saltwortdevs.socialdevs.view.core.components.InstaButton
import com.saltwortdevs.socialdevs.view.core.components.InstaText

@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel(), navigateToRegister : () -> Unit) {
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
            InstaText(modifier = Modifier.padding(12.dp), stringResource(R.string.login_screen_header_text_lang_spanish),color = MaterialTheme.colorScheme.onBackground,)
            Spacer(Modifier.weight(1f))
            Image(
                modifier = Modifier.size(72.dp),
                painter = painterResource(R.drawable.logo),
                contentDescription = stringResource(R.string.app_name)
            )
            Spacer(Modifier.weight(1f))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(25),
                value = ioState.email,
                label = {
                    InstaText(
                        text = stringResource(R.string.login_screen_textfield_email),
                        color = MaterialTheme.colorScheme.onBackground,
                    )},
                    onValueChange = { loginViewModel.onEmailChanged( it) }
                )
            Spacer(Modifier.height(12.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(25),
                label = {InstaText(text = stringResource(R.string.login_screen_textfield_password), color = MaterialTheme.colorScheme.onBackground)},
                value = ioState.password,
                onValueChange = { loginViewModel.onPasswordChanged( it) }
            )
            Spacer(Modifier.height(12.dp))
            InstaButton( text = stringResource(R.string.login_screen_button_login), onClick = {})
            TextButton(
                {}) {
                InstaText(
                    text = stringResource(R.string.login_screen_recover_pasasword),
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )}
            Spacer(Modifier.weight(1f))
            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {navigateToRegister()},
                colors = ButtonDefaults.outlinedButtonColors(MaterialTheme.colorScheme.primary)
            ) {
                InstaText(text = stringResource(R.string.login_screen_button_register), color = MaterialTheme.colorScheme.onPrimary)
            }
            Icon(
                modifier = Modifier.width(120.dp).padding(vertical = 22.dp),
                painter = painterResource(R.drawable.ic_meta),
                contentDescription = "Icono meta",
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}

