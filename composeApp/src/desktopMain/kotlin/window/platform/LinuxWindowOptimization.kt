package window.platform

import androidx.compose.runtime.Composable

object LinuxWindowOptimization: WindowOptimization {
    override val customTopBarSupport: Boolean = false

    override fun windowInit(handle: Long) {

    }

    @Composable
    override fun DraggableTopBar() {

    }
}
