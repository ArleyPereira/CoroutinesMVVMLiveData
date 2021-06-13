package com.br.coroutinesmvvmlivedata.ui.main

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class MainRepository {

    fun getFilmes(callback: (filmes: List<Filme>) -> Unit) {
        Thread {
            Thread.sleep(3000)
            callback.invoke(
                listOf(
                    Filme(1, "Título 01"),
                    Filme(2, "Título 02")
                )
            )
        }.start()
    }

    suspend fun getFilmesCoroutines(): List<Filme> {
        return withContext(Dispatchers.Default) {
            delay(3000)
            listOf(
                Filme(1, "Título 01"),
                Filme(2, "Título 02")
            )
        }
    }

}