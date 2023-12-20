package core.midi

actual suspend fun InputDevice.Companion.fetchDevices(): Array<InputDevice> {
    TODO("Not implemented yet")
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