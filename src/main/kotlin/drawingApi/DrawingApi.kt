package drawingApi

interface DrawingApi {
    val radius: Int
        get() = 10
    val getDrawingAreaWidth: Int
        get() = 500
    val getDrawingAreaHeight: Int
        get() = 500

    fun drawCircle(center: Pair<Int, Int>)
    fun drawLine(point1: Pair<Int, Int>, point2: Pair<Int, Int>)
    fun draw()
}