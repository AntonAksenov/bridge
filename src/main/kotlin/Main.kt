import drawingApi.DrawingApiAWT
import drawingApi.DrawingApiJFX
import graph.EdgesGraph
import graph.MatrixGraph
import java.lang.IllegalArgumentException
import kotlin.io.path.Path

fun main(args: Array<String>) {
    if (args.size != 3) {
        throw IllegalArgumentException("there should be exactly 3 arguments")
    }
    val drawingApi = when(args[0]) {
        "jfx" -> DrawingApiJFX()
        "awt" -> DrawingApiAWT()
        else -> throw IllegalArgumentException("first argument should be either jfx or awt")
    }
    val graph = when(args[1]) {
        "edges" -> EdgesGraph(drawingApi)
        "matrix" -> MatrixGraph(drawingApi)
        else -> throw IllegalArgumentException("second argument should be either edges or matrix")
    }
    graph.readGraphFromFile(Path(args[2]).toFile())
    graph.drawGraph()
}