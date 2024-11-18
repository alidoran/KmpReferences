package ir.dorantech.kmp.ui.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ir.dorantech.kmp.ui.GreetingMessage
import ir.dorantech.kmp.data.model.FirstScreenButtons
import kmpreferences.composeapp.generated.resources.Res
import kmpreferences.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.painterResource

@Composable
fun DefaultSampleScreen(
    onBackClick: (FirstScreenButtons) -> Unit,
    modifier: Modifier = Modifier,
) {
    var showContent by remember { mutableStateOf(false) }
    Column(modifier.fillMaxWidth(), horizontalAlignment = Alignment.End) {
        Button(onClick = {onBackClick(FirstScreenButtons.DefaultSample)}) {
            Text("Back")
        }
    }
    Column(modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { showContent = !showContent }) {
            Text("Click me!")
        }
        AnimatedVisibility(showContent) {
            val greeting = remember { GreetingMessage().greet() }
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painterResource(Res.drawable.compose_multiplatform), null)
                Text("Compose: $greeting")
            }
        }
    }
}