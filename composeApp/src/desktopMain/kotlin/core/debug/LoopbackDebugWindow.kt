package core.debug

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import kotlin.system.exitProcess

@Composable
fun LoopbackDebugWindow() {
    Window(
        onCloseRequest = { exitProcess(0) },
        title = "Midi Loopback Test"
    ) {
        LoopbackTestView()
    }
}