package graph

import drawingApi.DrawingApi
import java.io.*
import kotlin.random.Random

abstract class Graph(val drawingApi: DrawingApi) {
    abstract fun drawGraph()
    abstract fun readGraph(reader: Reader)

    fun readGraphFromFile(file: File) {
        BufferedReader(InputStreamReader(FileInputStream(file))).use { reader -> readGraph(reader) }
    }

    fun getRandomPos(size: Int): Array<Pair<Int, Int>> {
        val random = Random(42)
        return Array(size) {
            Pair(
                random.nextInt(drawingApi.getDrawingAreaWidth),
                random.nextInt(drawingApi.getDrawingAreaHeight)
            )
        }
    }
}