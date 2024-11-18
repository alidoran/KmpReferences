package ir.dorantech.kmp.data.network

import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.darwin.Darwin

actual fun provideHttpClientEngineFactory(): HttpClientEngineFactory<*> = Darwin