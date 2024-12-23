package ir.dorantech.kmp.di

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton

val sharedDI = DI {
    bind<String>() with singleton { "Hello from Kodein DI" }
}