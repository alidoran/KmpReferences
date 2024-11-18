package ir.dorantech.kmp.data.network

import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.js.*

actual fun provideHttpClientEngineFactory(): HttpClientEngineFactory<*> = Js