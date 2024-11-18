package ir.dorantech.kmp

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ir.dorantech.kmp.data.model.FirstScreenButtons
import ir.dorantech.kmp.navigation.Routes
import ir.dorantech.kmp.ui.composable.DefaultSampleScreen
import ir.dorantech.kmp.ui.composable.FirstScreen
import ir.dorantech.kmp.ui.composable.KtorSimpleScreen
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
                        onButtonClick = {clickedButton ->
                            when (clickedButton){
                                FirstScreenButtons.DefaultSample ->
                                    navController.navigate(Routes.DefaultSample)
                                FirstScreenButtons.KtorSimple ->
                                    navController.navigate(Routes.KtorSimple)
                            }
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
                composable<Routes.KtorSimple> {
                    KtorSimpleScreen({
                        navController.navigate(Routes.FirstPage)
                    }, modifier)
                }
            }
        }
    }
}

