
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.application
import window.ProjectSelectionWindow

fun main() = application {
    ProjectSelectionWindow()
}

@Preview
@Composable
fun AppDesktopPreview() {
    App()
}
