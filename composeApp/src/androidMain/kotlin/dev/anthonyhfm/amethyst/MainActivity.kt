package dev.anthonyhfm.amethyst

import App
import android.content.Context
import android.media.midi.MidiManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ui.AmethystTheme

var androidMainActivity: MainActivity? = null
lateinit var midiManager: MidiManager

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        androidMainActivity = this
        midiManager = applicationContext.getSystemService(Context.MIDI_SERVICE) as MidiManager

        setContent {
            AmethystTheme {
                window.statusBarColor = MaterialTheme.colorScheme.background.toArgb()
                window.navigationBarColor = MaterialTheme.colorScheme.surfaceColorAtElevation(1.dp).toArgb()

                App()
            }
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}