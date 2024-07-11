package com.id.composeui.ui.component;

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.id.composeui.ui.theme.ComposeUITheme
import com.id.composeui.ui.theme.Typography


@Composable
fun AlertLoginDialog(
    name: String = "",
    onDismissRequest: () -> Unit = {}
) {
    AlertDialog(onDismissRequest = onDismissRequest, confirmButton = {
        PrimaryButton(title = "OK") {
            onDismissRequest()
        }
    }, title = {
        Text(text = "You are successfully Login", style = Typography.titleMedium)
    }, text = {
        Text(text = "Thank you for $name to try this application")

    })
}

@Composable
@Preview
fun ShowAlertLoginDialogPreview() {
    ComposeUITheme {
        AlertLoginDialog()
    }
}
