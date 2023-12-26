package window.platform

import androidx.compose.runtime.Composable

interface WindowOptimization {
    val customTopBarSupport: Boolean
    fun windowInit(handle: Long)

    @Composable
    fun DraggableTopBar()
}
