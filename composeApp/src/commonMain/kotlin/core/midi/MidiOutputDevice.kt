package core.midi

data class OutputDevice(
    override val name: String,
    override val internalDevice: Any? = null
) : MidiDevice {
    companion object
}

expect suspend fun OutputDevice.Companion.fetchDevices(): Array<OutputDevice>
expect suspend fun OutputDevice.sendData(dataBytes: Array<Byte>)
expect suspend fun OutputDevice.sendSysEx(dataBytes: Array<Byte>)
expect suspend fun OutputDevice.sendNoteOn(channel: Int, pitch: Int, velocity: Int)
expect suspend fun OutputDevice.sendNoteOff(channel: Int, pitch: Int, velocity: Int)
expect suspend fun OutputDevice.openDevice()
expect suspend fun OutputDevice.closeDevice()
expect fun OutputDevice.isOpen(): Boolean
