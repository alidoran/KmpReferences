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
import ir.dorantech.kmp.ui.composable.KodeinScreen
import ir.dorantech.kmp.ui.composable.MainScreen
import ir.dorantech.kmp.ui.composable.KtorSimpleScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(modifier: Modifier = Modifier) {
    MaterialTheme {
        Column {
            val navController: NavHostController = rememberNavController()

            NavHost(
                startDestination = Routes.Main,
                navController = navController,
                modifier = modifier
            ) {
                composable<Routes.Main> {
                    MainScreen(
                        onButtonClick = { clickedButton ->
                            when (clickedButton) {
                                FirstScreenButtons.DefaultKmpBtn ->
                                    navController.navigate(Routes.DefaultKmp)

                                FirstScreenButtons.KtorBtn ->
                                    navController.navigate(Routes.Ktor)

                                FirstScreenButtons.KodeinBtn ->
                                    navController.navigate(Routes.Kodein)
                            }
                        },
                        modifier = modifier
                    )
                }
                composable<Routes.DefaultKmp> {
                    DefaultSampleScreen(
                        onBackClick = { navController.navigate(Routes.Main) },
                        modifier
                    )
                }
                composable<Routes.Ktor> {
                    KtorSimpleScreen(
                        onBackClick = { navController.navigate(Routes.Main) },
                        modifier
                    )
                }
                composable<Routes.Kodein> {
                    KodeinScreen(modifier)
                }
            }
        }
    }
}

