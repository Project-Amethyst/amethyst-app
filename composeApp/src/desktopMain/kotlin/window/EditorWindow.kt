package window

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.WindowState
import kotlin.system.exitProcess

@Composable
fun EditorWindow() {
    Window(
        onCloseRequest = {
            exitProcess(0)
        },
        title = "Amethyst Studio",
        state = WindowState(
            width = 1100.dp,
            height = 800.dp,
            position = WindowPosition(alignment = Alignment.Center)
        ),
    ) {

    }
}