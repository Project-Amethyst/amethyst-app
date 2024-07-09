package core.midi

import android.media.midi.MidiDevice
import android.media.midi.MidiDeviceInfo
import android.media.midi.MidiDeviceService
import android.media.midi.MidiInputPort
import android.os.Build
import androidx.annotation.RequiresApi
import dev.anthonyhfm.amethyst.midiManager

actual suspend fun OutputDevice.Companion.fetchDevices(): Array<OutputDevice> {
    val deviceList: MutableList<OutputDevice> = mutableListOf()

    midiManager.devices.forEach { device ->
        device.ports.forEach { port ->
            if (port.type == MidiDeviceInfo.PortInfo.TYPE_OUTPUT) {
                deviceList.add(
                    OutputDevice(
                        port.name,
                        port
                    )
                )
            }
        }
    }

    return deviceList.toTypedArray()
}

actual suspend fun OutputDevice.sendSysEx(dataBytes: Array<Byte>) {
    TODO("Not implemented yet")
}

actual suspend fun OutputDevice.sendData(dataBytes: Array<Byte>) {
    TODO("Not implemented yet")
}

actual suspend fun OutputDevice.sendNoteOn(channel: Int, pitch: Int, velocity: Int) {
    TODO("Not implemented yet")
}

actual suspend fun OutputDevice.sendNoteOff(channel: Int, pitch: Int, velocity: Int) {
    TODO("Not implemented yet")
}

actual suspend fun OutputDevice.openDevice() {
    TODO("Not implemented yet")
}
actual suspend fun OutputDevice.closeDevice() {
    TODO("Not implemented yet")
}
actual fun OutputDevice.isOpen(): Boolean {
    TODO("Not implemented yet")
}