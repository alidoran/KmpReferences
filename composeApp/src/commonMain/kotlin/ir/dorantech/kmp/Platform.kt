package ir.dorantech.kmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform