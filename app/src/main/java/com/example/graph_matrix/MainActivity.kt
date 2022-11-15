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
    fun useGraph() {
        val g = Graph()
        g.addVertex("A")
        g.addVertex("B")
        g.addVertex("C")
        g.addVertex("D")
        g.connect("A", "C")
        g.connect("B", "D")
        g.connect("B", "C")
        println(g.neighbors("B"))
    }

    fun createAdjacencyList(pairs: Array<IntArray>) {
        val graph: HashMap<Int, MutableList<Int>> = hashMapOf()
        pairs.forEach { pair ->
            if (!graph.containsKey(pair[0])) {
                // If the current node isn't in the adjacency list yet,
                // add it and create its dependency list starting with
                // pair[1]
                graph[pair[0]] = mutableListOf(pair[1])
            } else {
                // Otherwise, append pair[1] to its existing dependency
                // list.
                val dependencies = graph[pair[0]]

            }
        }
    }
}