package com.example.myapplication


import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class MyGraphView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint()
    private val graph = Graph()
    private var startNodeIndex: Int? = null
    private var endNodeIndex: Int? = null
    private var pathCalculated = false

    init {
        paint.color = Color.BLACK
        paint.strokeWidth = 5f

        // Adicione 10 nós de exemplo
        graph.addNode(1, 100f, 100f)
        graph.addNode(2, 200f, 300f)
        graph.addNode(3, 300f, 150f)
        graph.addNode(4, 400f, 250f)
        graph.addNode(5, 500f, 100f)
        graph.addNode(6, 600f, 300f)
        graph.addNode(7, 700f, 150f)
        graph.addNode(8, 800f, 250f)
        graph.addNode(9, 900f, 100f)
        graph.addNode(10, 1000f, 300f)
    }

    fun setStartNode(index: Int) {
        startNodeIndex = index
        pathCalculated = false
        invalidate()  // Solicita uma atualização do desenho
    }

    fun setEndNode(index: Int) {
        endNodeIndex = index
        pathCalculated = false
        invalidate()  // Solicita uma atualização do desenho
    }

    fun calculateShortestPath() {
        pathCalculated = true
        val startNodeIndex = startNodeIndex
        val endNodeIndex = endNodeIndex
        if (startNodeIndex != null && endNodeIndex != null) {
            graph.calculateShortestPath(startNodeIndex + 1, endNodeIndex + 1)
            invalidate()
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Desenhe os nós do grafo
        for (node in graph.getNodes()) {
            drawNode(canvas, node.x, node.y)
        }

        // Desenhe as conexões entre os nós (apenas se o caminho não tiver sido calculado)
        if (pathCalculated) {
            val shortestPath = graph.getShortestPath()
            if (shortestPath.isNotEmpty()) {
                for (i in 0 until shortestPath.size - 1) {
                    val startNode = shortestPath[i]
                    val endNode = shortestPath[i + 1]
                    drawConnection(canvas, startNode.x, startNode.y, endNode.x, endNode.y, Color.RED, 8f)
                }
            }
        }
    }

    private fun drawNode(canvas: Canvas, x: Float, y: Float) {
        // Desenhe um círculo representando um nó do grafo
        paint.color = Color.BLACK
        paint.strokeWidth = 5f
        canvas.drawCircle(x, y, 20f, paint)
    }

    private fun drawConnection(canvas: Canvas, startX: Float, startY: Float, endX: Float, endY: Float, color: Int = Color.BLACK, strokeWidth: Float = 5f) {
        paint.color = color
        paint.strokeWidth = strokeWidth

        // Desenhe uma linha representando uma conexão entre os nós
        canvas.drawLine(startX, startY, endX, endY, paint)
    }
}











