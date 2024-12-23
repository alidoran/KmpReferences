package ir.dorantech.kmp.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ir.dorantech.kmp.di.sharedDI
import org.kodein.di.compose.withDI
import org.kodein.di.direct
import org.kodein.di.instance

@Composable
fun KodeinScreen(
    modifier: Modifier = Modifier
) = withDI(sharedDI) {
    var injectedString by remember { mutableStateOf("") }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(injectedString)

        Button(onClick = {
            injectedString = sharedDI.direct.instance<String>().toString()
        }){
            Text("Print injected String")
        }
    }
}