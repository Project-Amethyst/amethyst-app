package core.midi

interface MidiDevice {
    val name: String
    val internalDevice: Any?
}
