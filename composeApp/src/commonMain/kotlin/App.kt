import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ui.AmethystTheme

@Composable
fun App() {
    AmethystTheme {
        BoxWithConstraints {
            if (maxWidth > 600.dp) {
                TabletView()
            } else {
                MobileView()
            }
        }
    }
}

@Composable
fun TabletView() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(topEnd = 20.dp, bottomEnd = 20.dp))
                    .fillMaxHeight()
                    .width(400.dp)
                    .background(MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp))
            ) {

            }

            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Launchpad here",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MobileView() {
    BottomSheetScaffold(
        sheetContent = {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Peek Controls for Lightshow",
                        color = Color.White
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                )
            }
        },
        sheetPeekHeight = BottomSheetDefaults.SheetPeekHeight + 50.dp
    ) { contentPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),

            contentAlignment = Alignment.Center
        ) {

        }
    }
}