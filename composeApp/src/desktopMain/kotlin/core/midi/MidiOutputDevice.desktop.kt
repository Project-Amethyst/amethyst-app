package core.midi

import javax.sound.midi.MidiDevice
import javax.sound.midi.MidiSystem
import javax.sound.midi.ShortMessage
import javax.sound.midi.SysexMessage

actual suspend fun OutputDevice.sendSysEx(dataBytes: Array<Byte>) {
    val msg = SysexMessage()
    msg.setMessage(dataBytes.toByteArray(), dataBytes.size)

    (internalDevice as MidiDevice).receiver.send(msg, 0)
}

actual suspend fun OutputDevice.sendData(dataBytes: Array<Byte>) {
    TODO("Didnt figure that out yet with Java Midi")
}

actual suspend fun OutputDevice.Companion.fetchDevices(): Array<OutputDevice> {
    var outputDevices: Array<OutputDevice> = arrayOf()

    MidiSystem.getMidiDeviceInfo().forEach { info ->
        val device = MidiSystem.getMidiDevice(info)

        if (device.maxReceivers == -1) {
            outputDevices = outputDevices.plus(
                OutputDevice(
                    name = info.name,
                    internalDevice = device
                )
            )
        }
    }

    return outputDevices
}

actual suspend fun OutputDevice.sendNoteOn(channel: Int, pitch: Int, velocity: Int) {
    (internalDevice as MidiDevice).receiver.send(ShortMessage(ShortMessage.NOTE_ON, channel, pitch, velocity), 0)
}

actual suspend fun OutputDevice.sendNoteOff(channel: Int, pitch: Int, velocity: Int) {
    (internalDevice as MidiDevice).receiver.send(ShortMessage(ShortMessage.NOTE_OFF, channel, pitch, velocity), 0)
}

actual suspend fun OutputDevice.openDevice() {
    (internalDevice as MidiDevice).open()
}

actual suspend fun OutputDevice.closeDevice() {
    (internalDevice as MidiDevice).close()
}

actual fun OutputDevice.isOpen(): Boolean {
    return (internalDevice as MidiDevice).isOpen
}
