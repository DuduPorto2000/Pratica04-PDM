package com.example.ifpbbrowser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import android.content.Intent


class MainActivity : AppCompatActivity() {

    private lateinit var buttonAndroid: Button
    private lateinit var buttonGoogle: Button
    private lateinit var buttonIFPB: Button
    private lateinit var editTextEndereco: EditText
    private lateinit var webView: WebView
    private lateinit var buttonCriador: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        buttonAndroid = findViewById(R.id.botaoAndroid)
        buttonGoogle = findViewById(R.id.botaoGoogle)
        buttonIFPB = findViewById(R.id.botaoIFPB)
        editTextEndereco = findViewById(R.id.textoEndereco)
        webView = findViewById(R.id.tela)
        buttonCriador = findViewById(R.id.botaoCriador)

        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        webView.settings.setSupportZoom(true)

        if (intent.data != null) {
            this.editTextEndereco.setText(intent.data.toString())
            this.webView.loadUrl(intent.data.toString())
        }

        buttonAndroid.setOnClickListener {
            open("https://www.android.com")
        }
        buttonGoogle.setOnClickListener {
            open("https://www.google.com")
        }
        buttonIFPB.setOnClickListener {
            open("https://www.ifpb.edu.br")
        }
        buttonCriador.setOnClickListener {

            try {
                startActivity( Intent("CRIADOR") )
            } catch(e: Exception) { println("Erro: Aplicativo com ação 'Criador' não encontrado") }

        }
    }

    private fun open (endereco: String) {
        this.editTextEndereco.setText(endereco)
        this.webView.loadUrl(endereco)
    }
}