package com.example.domain.usecases

interface BaseUseCase<inpute, output> {
    suspend fun execute(inpute: inpute): output
}