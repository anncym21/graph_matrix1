package com.example.graph_matrix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    class Graph {
        private data class Vertex(val name: String) {
            val neighbors = mutableSetOf<Vertex>()
        }

        private val vertices = mutableMapOf<String, Vertex>()

        private operator fun get(name: String) = vertices[name] ?: throw IllegalArgumentException()

        fun addVertex(name: String) {
            vertices[name] = Vertex(name)
        }

        private fun connect(first: Vertex, second: Vertex) {
            first.neighbors.add(second)
            second.neighbors.add(first)
        }

        fun connect(first: String, second: String) = connect(this[first], this[second])

        fun neighbors(name: String) = vertices[name]?.neighbors?.map { it.name } ?: listOf()
    }
}