package ir.dorantech.kmp.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import ir.dorantech.kmp.data.network.Ktor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun KtorSimpleScreen(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var simpleGetResult by remember { mutableStateOf("") }
    var simplePost by remember { mutableStateOf("") }
    LaunchedEffect(Unit) {
        withContext(Dispatchers.Default) {
            launch { simpleGetResult = Ktor.simpleGet() }
            launch { simplePost = Ktor.simplePost() }
        }
    }
    Column(modifier = modifier) {
        Button(onClick = onBackClick) {
            Text("back")
        }
        Text(text = "The status code of simpleGet is $simpleGetResult")
        Text(text = "The status code of simplePost is $simpleGetResult")
    }
}