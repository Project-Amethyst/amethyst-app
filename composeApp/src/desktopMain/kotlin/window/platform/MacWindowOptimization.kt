package window.platform

import androidx.compose.runtime.Composable

object MacWindowOptimization: WindowOptimization {
    override val customTopBarSupport: Boolean = true

    override fun windowInit(handle: Long) {

    }

    @Composable
    override fun DraggableTopBar() {

    }
}
