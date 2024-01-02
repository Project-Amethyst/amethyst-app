package window

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.window.WindowDraggableArea
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.WindowState
import ui.AmethystTheme
import ui.robotoFont
import kotlin.system.exitProcess

@Composable
fun ProjectSelectionWindow() {
    Window(
        onCloseRequest = {
            exitProcess(0)
        },
        title = "Amethyst - Project Selection",
        state = WindowState(
            width = 800.dp,
            height = 450.dp,
            position = WindowPosition(alignment = Alignment.Center)
        ),
        resizable = false
    ) {
        AmethystTheme {
            Row(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.4f)
                        .fillMaxHeight(),

                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource("images/amethyst_transbg.png"),
                        contentDescription = null,
                        modifier = Modifier
                            .size(260.dp)
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                    ) {

                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(64.dp)
                            .padding(horizontal = 16.dp, vertical = 10.dp),

                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()
                                .border(2.dp, MaterialTheme.colorScheme.onBackground.copy(0.6f)),

                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Open a Project File",
                                fontFamily = robotoFont,
                                fontSize = 16.sp,
                                lineHeight = 16.sp
                            )
                        }

                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()
                                .border(2.dp, MaterialTheme.colorScheme.onBackground.copy(0.6f)),

                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Create a new Project",
                                fontFamily = robotoFont,
                                fontSize = 16.sp,
                                lineHeight = 16.sp
                            )
                        }
                    }
                }
            }
        }
    }
}
