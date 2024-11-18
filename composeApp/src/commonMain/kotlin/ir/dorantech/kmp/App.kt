package ir.dorantech.kmp

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ir.dorantech.kmp.navigation.Routes
import ir.dorantech.kmp.ui.DefaultSampleScreen
import ir.dorantech.kmp.ui.FirstScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(modifier: Modifier = Modifier) {
    MaterialTheme {
        Column {
            val navController: NavHostController = rememberNavController()

            NavHost(
                startDestination = Routes.FirstPage,
                navController = navController,
                modifier = modifier
            ) {
                composable<Routes.FirstPage> {
                    FirstScreen(
                        onDefaultSampleClick = {
                            navController.navigate(Routes.DefaultSample)
                        },
                        modifier = modifier
                    )
                }
                composable<Routes.DefaultSample> {
                    DefaultSampleScreen(
                        onBackClick = {
                            navController.navigate(Routes.FirstPage)
                        },
                        modifier
                    )
                }
            }
        }
    }
}

