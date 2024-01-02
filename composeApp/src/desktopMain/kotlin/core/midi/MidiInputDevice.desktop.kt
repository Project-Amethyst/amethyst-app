package core.midi

import javax.sound.midi.MidiDevice
import javax.sound.midi.MidiMessage
import javax.sound.midi.MidiSystem
import javax.sound.midi.Receiver
import kotlin.system.exitProcess

actual suspend fun InputDevice.Companion.fetchDevices(): Array<InputDevice> {
    var inputDevices: Array<InputDevice> = arrayOf()

    MidiSystem.getMidiDeviceInfo().forEach { info ->
        val device = MidiSystem.getMidiDevice(info)

        if (device.maxTransmitters == -1) {
            inputDevices = inputDevices.plus(
                InputDevice(
                    name = info.name,
                    internalDevice = device
                )
            )
        }
    }

    return inputDevices
}

actual suspend fun InputDevice.openDevice(
    onNoteOn: (ByteArray) -> Unit,
    onNoteOff: (ByteArray) -> Unit
) {
    val device = internalDevice as MidiDevice
    device.open()

    val receiver = object : Receiver {
        override fun send(message: MidiMessage?, timeStamp: Long) {
            if (message != null) {
                if (message.message.size == 3) {
                    onNoteOn(message.message)
                }
            }
        }

        override fun close() {

        }
    }

    val transmitter = device.transmitter
    transmitter.receiver = receiver
}

actual suspend fun InputDevice.closeDevice() {
    (internalDevice as MidiDevice).close()
}

actual fun InputDevice.isOpen(): Boolean {
    return (internalDevice as MidiDevice).isOpen
}