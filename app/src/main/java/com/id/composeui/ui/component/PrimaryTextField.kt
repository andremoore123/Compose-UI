package com.id.composeui.ui.component;

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.id.composeui.ui.theme.ComposeUITheme
import com.id.composeui.ui.theme.Typography

enum class PrimaryTextField {
    EMAIL,
    PASSwORD,
    DEFAULT
}

@Composable
fun PrimaryTextField(
    modifier: Modifier = Modifier,
    title: String = "",
    value: String = "",
    inputType: PrimaryTextField = PrimaryTextField.DEFAULT,
    onTextChange: (String) -> Unit = {}
) {
    Column(
        modifier = modifier
    ) {
        AnimatedVisibility(visible = value.isNotEmpty()) {
            Text(
                text = title,
                style = Typography.titleMedium,
                modifier = Modifier.padding(bottom = 5.dp)
            )
        }
        OutlinedTextField(
            value = value,
            onValueChange = { onTextChange(it) },
            label = {
                AnimatedVisibility(visible = value.isEmpty()) {
                    Text(text = title)
                }
            },
            textStyle = Typography.bodyMedium,
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            maxLines = 1,
            visualTransformation = if (inputType == PrimaryTextField.PASSwORD) PasswordVisualTransformation() else VisualTransformation.None
        )
    }
}

@Composable
@Preview
fun ShowPrimaryTextFieldPreview() {
    ComposeUITheme {
        PrimaryTextField(
            title = "Email"
        )
    }
}
