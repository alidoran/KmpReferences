package ir.dorantech.kmp.navigation

import kotlinx.serialization.Serializable

sealed interface Routes {
    @Serializable
    data object DefaultKmp : Routes

    @Serializable
    data object Main: Routes

    @Serializable
    data object Ktor: Routes

    @Serializable
    data object Kodein: Routes
}