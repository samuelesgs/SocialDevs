package com.saltwortdevs.socialdevs.view.auth.register

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.saltwortdevs.socialdevs.R
import com.saltwortdevs.socialdevs.view.core.components.InstaText
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.saltwortdevs.socialdevs.view.core.components.InstaButton

@Composable
fun RegisterScreen(registerViewModel : RegisterViewModel = viewModel(), navigateBack : () -> Unit) {
    val ioState by registerViewModel.uiState.collectAsStateWithLifecycle()
    val context = LocalContext.current
    Scaffold (
        topBar = {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "back",
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.clickable{
                    Log.i("REGISTER_SCREEN", "RegisterScreen: ")
                    navigateBack()
                }
            )
        }) { padding ->
        Column(modifier = Modifier
            .padding(padding)
            .background(MaterialTheme.colorScheme.background),
        ) {
            Column(modifier = Modifier.padding(8.dp)) {
                InstaText(
                    modifier = Modifier.padding(12.dp),
                    stringResource(if(ioState.type == 0) R.string.register_screen_textfield_register_phone else R.string.register_screen_title_email),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.titleLarge
                )
                InstaText(
                    modifier = Modifier.padding(12.dp),
                    stringResource(if (ioState.type == 0)R.string.register_screen_subtitle_phone_2 else R.string.register_screen_subtitle_email),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.labelLarge
                )
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(25),
                    value = ioState.value,
                    label = {
                        InstaText(
                            text = stringResource(if (ioState.type == 0)  R.string.register_screen_textfield_register_phone else R.string.login_screen_textfield_email),
                            color = MaterialTheme.colorScheme.onBackground,
                        )},
                    onValueChange = {
                        registerViewModel.onValueChanged(
                            value = it,
                            type = ioState.type
                        )
                    },
                )
                InstaText(
                    modifier = Modifier.padding(12.dp),
                    stringResource(R.string.register_screen_body),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodySmall
                )
                InstaButton(
                    text = stringResource(R.string.register_screen_button_next),
                    enabled = ioState.isLoadingEnabled,
                    onClick = {
                        Toast.makeText(context, "Se a tocado", Toast.LENGTH_SHORT).show()
                    }
                )
                OutlinedButton(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        registerViewModel.onChangeType(ioState.type)
                    },
                    colors = ButtonDefaults.outlinedButtonColors(MaterialTheme.colorScheme.background)
                ) {
                    InstaText(text = stringResource(if (ioState.type == 0) R.string.register_screen_button_register_with_email else R.string.register_screen_button_register_with_phone), color = MaterialTheme.colorScheme.onBackground)
                }
            }
            /*if (ioState.type == 1){
                RegisterEmail(ioState, {},padding)
            }*/
            }
    }


}
/*
@Composable
fun RegisterEmail(ioState: RegisterUiState, onValueChanged: (String) -> Unit, padding: PaddingValues) {
    Column(Modifier
        .padding(padding)
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(16.dp),
            painter = painterResource(R.drawable.back),
            contentDescription = stringResource(R.string.app_name)
        )
        Spacer(Modifier.weight(1f))
        InstaText(
            modifier = Modifier.padding(12.dp),
            stringResource(R.string.login_screen_header_text_lang_spanish),
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(Modifier.weight(1f))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(25),
            value = ioState.value,
            label = {
                InstaText(
                    text = stringResource(R.string.login_screen_textfield_email),
                    color = MaterialTheme.colorScheme.onBackground,
                )},
            onValueChange = { onValueChanged.onEmailChanged( it) }
        )
        InstaButton( text = stringResource(R.string.register_screen_button_next), onClick = {

        })

    }

}
*/