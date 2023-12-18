package core.midi

actual suspend fun OutputDevice.sendSysEx(dataBytes: Array<Byte>) {
}

actual suspend fun OutputDevice.sendData(dataBytes: Array<Byte>) {
}

actual suspend fun OutputDevice.Companion.fetchDevices(): Array<OutputDevice> {
    TODO("Not implemented yet")
}

actual suspend fun OutputDevice.sendNoteOn(channel: Int, pitch: Int, velocity: Int) {
}

actual suspend fun OutputDevice.sendNoteOff(channel: Int, pitch: Int, velocity: Int) {
}

actual suspend fun OutputDevice.openDevice() {
}

actual suspend fun OutputDevice.closeDevice() {
}

actual fun OutputDevice.isOpen(): Boolean {
    TODO("Not yet implemented")
}
