package ui

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font

actual val robotoFont: FontFamily = FontFamily(
    Font(
        resource = "roboto/Roboto-Thin.ttf",
        weight = FontWeight.W100,
        style = FontStyle.Normal
    ),
    Font(
        resource = "roboto/Roboto-ThinItalic.ttf",
        weight = FontWeight.W100,
        style = FontStyle.Italic
    ),
    Font(
        resource = "roboto/Roboto-Light.ttf",
        weight = FontWeight.W300,
        style = FontStyle.Normal
    ),
    Font(
        resource = "roboto/Roboto-LightItalic.ttf",
        weight = FontWeight.W300,
        style = FontStyle.Italic
    ),
    Font(
        resource = "roboto/Roboto-Regular.ttf",
        weight = FontWeight.W400,
        style = FontStyle.Normal
    ),
    Font(
        resource = "roboto/Roboto-RegularItalic.ttf",
        weight = FontWeight.W400,
        style = FontStyle.Italic
    ),
    Font(
        resource = "roboto/Roboto-Medium.ttf",
        weight = FontWeight.W500,
        style = FontStyle.Normal
    ),
    Font(
        resource = "roboto/Roboto-MediumItalic.ttf",
        weight = FontWeight.W500,
        style = FontStyle.Italic
    ),
    Font(
        resource = "roboto/Roboto-Bold.ttf",
        weight = FontWeight.W700,
        style = FontStyle.Normal
    ),
    Font(
        resource = "roboto/Roboto-BoldItalic.ttf",
        weight = FontWeight.W700,
        style = FontStyle.Italic
    ),
    Font(
        resource = "roboto/Roboto-Black.ttf",
        weight = FontWeight.W900,
        style = FontStyle.Normal
    ),
    Font(
        resource = "roboto/Roboto-Black.ttf",
        weight = FontWeight.W900,
        style = FontStyle.Italic
    ),
)