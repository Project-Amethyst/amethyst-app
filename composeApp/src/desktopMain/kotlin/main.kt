
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.application
import core.debug.LoopbackDebugWindow
import window.EditorWindow
import window.ProjectSelectionWindow

fun main() = application {
    EditorWindow()
}

@Preview
@Composable
fun AppDesktopPreview() {
    App()
}
