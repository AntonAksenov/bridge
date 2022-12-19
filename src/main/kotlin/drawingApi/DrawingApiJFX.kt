package drawingApi

import javafx.application.Application
import javafx.scene.Group
import javafx.scene.Scene
import javafx.scene.shape.Circle
import javafx.scene.shape.Line
import javafx.scene.shape.Shape
import javafx.stage.Stage

class DrawingApiJFX : DrawingApi, Application() {
    companion object {
        private val shapes = mutableListOf<Shape>()
    }

    override fun draw() {
        launch()
    }

    override fun drawCircle(center: Pair<Int, Int>) {
        shapes.add(Circle(center.first.toDouble(), center.second.toDouble(), radius.toDouble()))
    }

    override fun drawLine(point1: Pair<Int, Int>, point2: Pair<Int, Int>) {
        shapes.add(
            Line(
                point1.first.toDouble(),
                point1.second.toDouble(),
                point2.first.toDouble(),
                point2.second.toDouble()
            )
        )
    }

    override fun start(p0: Stage) {
        p0.title = "javafx graph"

        val root = Group()

        shapes.forEach(root.children::add)

        p0.scene = Scene(root)
        p0.show()
    }
}
