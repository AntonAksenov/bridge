package graph

import drawingApi.DrawingApi
import java.io.Reader

class MatrixGraph(drawingApi: DrawingApi) : Graph(drawingApi) {
    private val matrix = mutableListOf<MutableList<Boolean>>()

    override fun drawGraph() {
        val randomPos = getRandomPos(matrix.size)
        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                if (matrix[i][j]) {
                    drawingApi.drawLine(randomPos[i], randomPos[j])
                }
            }
        }
        for (i in matrix.indices) {
            drawingApi.drawCircle(randomPos[i])
        }
        drawingApi.draw()
    }

    override fun readGraph(reader: Reader) {
        reader.readLines().forEach { string ->
            val line = mutableListOf<Boolean>()
            string.split(" ").forEach {
                line.add(
                    when (it) {
                        "1" -> true
                        "0" -> false
                        else -> throw IllegalArgumentException("matrix should consist only from zeros and ones separated by spaces")
                    }
                )
            }
            matrix.add(line)
        }
        val size = matrix.size
        for (row in matrix) {
            if (row.size != size) {
                throw RuntimeException("Matrix should be square")
            }
        }
    }
}