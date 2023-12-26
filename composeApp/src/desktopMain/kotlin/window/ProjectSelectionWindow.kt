package window

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.WindowState
import kotlin.system.exitProcess

@Composable
fun ProjectSelectionWindow() {
    Window(
        onCloseRequest = {
            exitProcess(0)
        },
        title = "Amethyst",
        state = WindowState(
            width = 650.dp,
            height = 400.dp,
            position = WindowPosition(alignment = Alignment.Center)
        )
    ) {

    }
}
