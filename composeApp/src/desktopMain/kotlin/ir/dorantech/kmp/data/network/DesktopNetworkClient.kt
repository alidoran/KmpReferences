package ir.dorantech.kmp.data.network

import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.cio.CIO

actual fun provideHttpClientEngineFactory(): HttpClientEngineFactory<*> = CIO