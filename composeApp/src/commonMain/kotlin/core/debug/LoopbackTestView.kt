package core.debug

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import core.midi.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun LoopbackTestView() {
    val scope = rememberCoroutineScope()
    var outputDevices: Array<OutputDevice>? by remember { mutableStateOf(null) }
    var selectedOutput: Int? by remember { mutableStateOf(null) }
    var inputDevices: Array<InputDevice>? by remember { mutableStateOf(null) }
    var selectedInput: Int? by remember { mutableStateOf(null) }

    LaunchedEffect(Unit) {
        scope.launch {
            outputDevices = OutputDevice.fetchDevices()
            inputDevices = InputDevice.fetchDevices()
        }
    }

    Row(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.5f)
        ) {
            inputDevices?.let {
                MidiDeviceDisplay(
                    text = "Input Devices",
                    devices = it.map { it.name }.toTypedArray(),
                    selected = selectedInput
                ) {
                    scope.launch {
                        inputDevices!!.forEach { device ->
                            if (device.isOpen()) {
                                device.closeDevice()
                            }
                        }
                    }

                    selectedInput = it

                    scope.launch {
                        inputDevices!![selectedInput!!].openDevice(
                            onNoteOn = { byteArray ->
                                if (outputDevices!![selectedOutput!!].isOpen()) {
                                    val velocityChain = listOf(5, 9, 13, 17, 21, 25, 29, 33, 37, 41, 45, 0)
                                    scope.launch {
                                        for (vel in velocityChain) {
                                            outputDevices!![selectedOutput!!].sendNoteOn(
                                                channel = 0,
                                                pitch = "${byteArray[1].toUByte()}".toInt(),
                                                velocity = vel,
                                            )
                                            delay(24)
                                        }
                                    }
                                }
                            },
                            onNoteOff = {

                            }
                        )
                    }
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.5f)
        ) {
            outputDevices?.let {
                MidiDeviceDisplay(
                    text = "Output Devices",
                    devices = it.map { it.name }.toTypedArray(),
                    selected = selectedOutput,
                    onSelect = {
                        scope.launch {
                            outputDevices!!.forEach { device ->
                                if (device.isOpen()) {
                                    device.closeDevice()
                                }
                            }
                        }

                        selectedOutput = it

                        scope.launch {
                            outputDevices!![selectedOutput!!].openDevice()
                        }
                    }
                )
            }
        }
    }
}

@Composable
private fun MidiDeviceDisplay(
    text: String,
    devices: Array<String>,
    selected: Int?,
    onSelect: (Int) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp),

        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth(),

            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                fontSize = 24.sp,
            )
        }

        Divider()

        Column {
            devices.forEachIndexed { index, midiDevice ->
                if (selected == index) {
                    Button(
                        onClick = {
                            onSelect(index)
                        },
                        modifier = Modifier
                            .padding(horizontal = 20.dp)
                            .fillMaxWidth()
                    ) {
                        Text(midiDevice)
                    }
                } else {
                    OutlinedButton(
                        onClick = {
                            onSelect(index)
                        },
                        modifier = Modifier
                            .padding(horizontal = 20.dp)
                            .fillMaxWidth()
                    ) {
                        Text(midiDevice)
                    }
                }
            }
        }
    }
}
