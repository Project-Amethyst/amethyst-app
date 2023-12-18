package core.midi

import javax.sound.midi.MidiDevice
import javax.sound.midi.MidiMessage
import javax.sound.midi.MidiSystem
import javax.sound.midi.ShortMessage
import javax.sound.midi.SysexMessage

var OutputDevice.midiDevice: MidiDevice?
    get() = null
    set(value) = setMidiDeviceValue(value)

private fun OutputDevice.setMidiDeviceValue(midiDevice: MidiDevice?) {
    this.midiDevice = midiDevice
}

actual suspend fun OutputDevice.sendSysEx(dataBytes: Array<Byte>) {
    val msg = SysexMessage()
    msg.setMessage(dataBytes.toByteArray(), dataBytes.size)

    this.midiDevice!!.receiver.send(msg, 0)
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
                ).also {
                    it.midiDevice = device
                }
            )
        }
    }

    return outputDevices
}

actual suspend fun OutputDevice.sendNoteOn(channel: Int, pitch: Int, velocity: Int) {
    this.midiDevice!!.receiver.send(ShortMessage(ShortMessage.NOTE_ON, channel, pitch, velocity), 0)
}

actual suspend fun OutputDevice.sendNoteOff(channel: Int, pitch: Int, velocity: Int) {
    this.midiDevice!!.receiver.send(ShortMessage(ShortMessage.NOTE_OFF, channel, pitch, velocity), 0)
}

actual suspend fun OutputDevice.openDevice() {
    this.midiDevice!!.open()
}

actual suspend fun OutputDevice.closeDevice() {
    this.midiDevice!!.close()
}

actual fun OutputDevice.isOpen(): Boolean {
    return this.midiDevice!!.isOpen
}
