package window.platform

import androidx.compose.runtime.Composable
import androidx.compose.ui.awt.ComposeWindow

object LinuxWindowOptimization: WindowOptimization {
    override val customTopBarSupport: Boolean = false

    override fun windowInit(handle: Long) {

    }

    @Composable
    override fun DraggableTopBar() {

    }
}
