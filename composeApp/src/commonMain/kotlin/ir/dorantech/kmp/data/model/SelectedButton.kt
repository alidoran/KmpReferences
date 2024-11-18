package ir.dorantech.kmp.data.model

sealed interface FirstScreenButtons{
    data object DefaultSample: FirstScreenButtons
    data object KtorSimple: FirstScreenButtons
}