package com.id.composeui.ui;

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.id.composeui.ui.component.AlertLoginDialog
import com.id.composeui.ui.component.PrimaryButton
import com.id.composeui.ui.component.PrimaryTextField
import com.id.composeui.ui.theme.ComposeUITheme
import com.id.composeui.ui.theme.Typography


@Composable
fun LoginScreen(
    modifier: Modifier = Modifier
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var openDialog by remember { mutableStateOf(false) }

    if (openDialog) {
        AlertLoginDialog(name = name) {
            openDialog = false
            name = ""
            email = ""
            password = ""
        }
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(30.dp),
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Text(
                text = "Welcome To Compose UI", style = Typography.headlineMedium.copy(
                    fontWeight = FontWeight.Black
                )
            )
            Text(
                text = "This app is built using Jetpack Compose",
                style = Typography.titleLarge.copy(
                    color = Color.Gray
                )
            )
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            PrimaryTextField(title = "Name", value = name, onTextChange = { name = it })
            PrimaryTextField(title = "Email", value = email, onTextChange = { email = it })
            PrimaryTextField(
                title = "Password",
                value = password,
                onTextChange = { password = it },
                inputType = PrimaryTextField.PASSwORD
            )
        }

        PrimaryButton(
            title = "Login", modifier = Modifier.fillMaxWidth(),
            enabled = name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()
        ) {
            openDialog = true
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun ShowLoginScreenPreview() {
    ComposeUITheme {
        LoginScreen()
    }
}
