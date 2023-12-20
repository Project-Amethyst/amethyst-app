package core.midi

actual suspend fun InputDevice.Companion.fetchDevices(): Array<InputDevice> {
    TODO("Not yet implemented")
}

actual suspend fun InputDevice.openDevice(
    onNoteOn: (ByteArray) -> Unit,
    onNoteOff: (ByteArray) -> Unit
) {

}

actual suspend fun InputDevice.closeDevice() {
}

actual fun InputDevice.isOpen(): Boolean {
    TODO("Not yet implemented")
}
