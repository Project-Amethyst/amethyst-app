package core.midi

import android.media.midi.MidiDeviceInfo
import dev.anthonyhfm.amethyst.midiManager

actual suspend fun InputDevice.Companion.fetchDevices(): Array<InputDevice> {
    val deviceList: MutableList<InputDevice> = mutableListOf()

    midiManager.devices.forEach { device ->
        device.ports.forEach { port ->
            if (port.type == MidiDeviceInfo.PortInfo.TYPE_INPUT) {
                deviceList.add(
                    InputDevice(
                        port.name,
                        port
                    )
                )
            }
        }
    }

    return deviceList.toTypedArray()
}

actual suspend fun InputDevice.openDevice(
    onNoteOn: (ByteArray) -> Unit,
    onNoteOff: (ByteArray) -> Unit
) {
    TODO("Not implemented yet")
}

actual suspend fun InputDevice.closeDevice() {
    TODO("Not implemented yet")
}

actual fun InputDevice.isOpen(): Boolean {
    TODO("Not yet implemented")
}