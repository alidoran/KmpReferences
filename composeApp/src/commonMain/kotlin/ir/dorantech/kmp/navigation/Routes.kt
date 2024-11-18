package ir.dorantech.kmp.navigation

import kotlinx.serialization.Serializable

sealed interface Routes {
    @Serializable
    data object DefaultSample : Routes

    @Serializable
    data object FirstPage: Routes

    @Serializable
    data object KtorSimple: Routes
}