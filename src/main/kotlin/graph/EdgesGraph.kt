package graph

import drawingApi.DrawingApi
import java.io.Reader

class EdgesGraph(drawingApi: DrawingApi) : Graph(drawingApi) {
    private val edges = mutableListOf<MutableList<Int>>()

    override fun drawGraph() {
        val randomPos = getRandomPos(edges.size)
        for (i in edges.indices) {
            for (j in edges[i]) {
                drawingApi.drawLine(randomPos[i], randomPos[j])
            }
        }
        for (i in edges.indices) {
            drawingApi.drawCircle(randomPos[i])
        }
        drawingApi.draw()
    }

    override fun readGraph(reader: Reader) {
        reader.readLines().forEach { string ->
            val line = mutableListOf<Int>()
            string.split(" ").forEach {
                line.add(it.toInt() - 1)
            }
            edges.add(line)
        }
        val size = edges.size
        for (row in edges) {
            for (e in row) {
                if (e < 0 || e >= size) {
                    throw RuntimeException("Edge should be between 1 and n")
                }
            }
        }
    }
}