package com.example.trainlib.data.converter

import android.content.Context

object ConverterFactory {

    fun create(context: Context): Converter = ConverterImpl(context)

}