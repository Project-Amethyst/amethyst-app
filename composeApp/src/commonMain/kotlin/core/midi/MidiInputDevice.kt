package core.midi

data class InputDevice(
    override val name: String,
    override val internalDevice: Any? = null
) : MidiDevice {
    companion object
}

expect suspend fun InputDevice.Companion.fetchDevices(): Array<InputDevice>
expect suspend fun InputDevice.openDevice(
    onNoteOn: (ByteArray) -> Unit,
    onNoteOff: (ByteArray) -> Unit
)
expect suspend fun InputDevice.closeDevice()
expect fun InputDevice.isOpen(): Boolean
