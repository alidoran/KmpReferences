package ir.dorantech.kmp.ui

import ir.dorantech.kmp.getPlatform

class GreetingMessage {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}