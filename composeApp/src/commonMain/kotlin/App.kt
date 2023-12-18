import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import core.midi.OutputDevice
import core.midi.fetchDevices
import kotlinx.coroutines.launch

@Composable
fun App() {
    val scope = rememberCoroutineScope()
    var outputDevices: Array<OutputDevice>? by remember { mutableStateOf(null) }

    scope.launch {
        outputDevices = OutputDevice.fetchDevices()
    }

    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            outputDevices?.forEach {
                Text(it.name)
            }
        }
    }
}
