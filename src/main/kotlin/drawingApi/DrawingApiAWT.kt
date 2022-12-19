package drawingApi

import java.awt.Frame
import java.awt.Graphics
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import kotlin.system.exitProcess

class DrawingApiAWT : DrawingApi {
    private val circles = mutableListOf<Pair<Int, Int>>()
    private val lines = mutableListOf<Pair<Pair<Int, Int>, Pair<Int, Int>>>()

    override fun draw() {
        val frame = GraphFrame()
        frame.setSize(getDrawingAreaWidth, getDrawingAreaHeight)
        frame.addWindowListener(object : WindowAdapter() {
            override fun windowClosing(event: WindowEvent) {
                exitProcess(0)
            }
        })
        frame.isVisible = true
    }

    override fun drawCircle(center: Pair<Int, Int>) {
        circles.add(center)
    }

    override fun drawLine(point1: Pair<Int, Int>, point2: Pair<Int, Int>) {
        lines.add(Pair(point1, point2))
    }

    inner class GraphFrame : Frame("awt graph") {
        override fun paint(g: Graphics) {
            super.paint(g)
            circles.forEach { circle ->
                g.fillOval(circle.first - radius / 2, circle.second - radius / 2, radius, radius)
            }
            lines.forEach { line ->
                g.drawLine(
                    line.first.first,
                    line.first.second,
                    line.second.first,
                    line.second.second
                )
            }
        }
    }
}