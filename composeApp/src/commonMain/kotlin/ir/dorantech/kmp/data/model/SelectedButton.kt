package ir.dorantech.kmp.data.model

sealed interface FirstScreenButtons{
    data object DefaultKmpBtn: FirstScreenButtons
    data object KtorBtn: FirstScreenButtons
    data object KodeinBtn: FirstScreenButtons
}