package dev.anthonyhfm.amethyst

import App
import android.content.Context
import android.media.midi.MidiManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

var androidMainActivity: MainActivity? = null
lateinit var midiManager: MidiManager

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        androidMainActivity = this
        midiManager = applicationContext.getSystemService(Context.MIDI_SERVICE) as MidiManager

        setContent {
            App()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}