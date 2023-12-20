package core.midi

actual suspend fun OutputDevice.Companion.fetchDevices(): Array<OutputDevice> {
    TODO("Not implemented yet")
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