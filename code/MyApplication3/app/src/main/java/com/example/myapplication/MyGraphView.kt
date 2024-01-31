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

        // Nós salas topo
        graph.addNode(147, 230f, 360f)
        graph.addNode(140, 360f, 360f)
        graph.addNode(146, 230f, 510f)
        graph.addNode(141, 360f, 450f)
        graph.addNode(145, 230f, 650f)
        graph.addNode(142, 360f, 550f)
        graph.addNode(143, 360f, 650f)
        graph.addNode(144, 360f, 800f)

        // Nós corredores topo e meio
        graph.addNode(9, 300f, 360f)
        graph.addNode(10, 300f, 450f)
        graph.addNode(11, 300f, 510f)
        graph.addNode(12, 300f, 550f)
        graph.addNode(13, 300f, 650f)
        graph.addNode(14, 300f, 800f)
        graph.addNode(15, 300f, 1000f)
        graph.addNode(16, 815f, 1000f)


        // Nós corredores baixo
        graph.addNode(17, 815f, 1000f)
        graph.addNode(18, 815f, 1225f)
        graph.addNode(19, 815f, 1400f)
        graph.addNode(20, 815f, 1650f)


        // Nós salas baixo
        graph.addNode(21, 900f, 1130f)
        graph.addNode(22, 940f, 1240f)
        graph.addNode(23, 900f, 1300f)
        graph.addNode(150, 900f, 1400f)
        graph.addNode(154, 730f, 1620f)
        graph.addNode(153, 730f, 1680f)
        graph.addNode(151, 900f, 1620f)
        graph.addNode(152, 900f, 1680f)
        graph.addNode(29, 815f, 1800f)


        ////Arestas entre sala 147 e 140
        graph.getNodes()[0].addNeighbor(graph.getNodes()[8])
        graph.getNodes()[1].addNeighbor(graph.getNodes()[8])
        graph.getNodes()[8].addNeighbor(graph.getNodes()[0])
        graph.getNodes()[8].addNeighbor(graph.getNodes()[1])
        graph.getNodes()[8].addNeighbor(graph.getNodes()[9])

        ////Arestas sala 146
        graph.getNodes()[10].addNeighbor(graph.getNodes()[2])
        graph.getNodes()[2].addNeighbor(graph.getNodes()[10])
        graph.getNodes()[10].addNeighbor(graph.getNodes()[11])

        ////Arestas sala 141
        graph.getNodes()[9].addNeighbor(graph.getNodes()[8])
        graph.getNodes()[9].addNeighbor(graph.getNodes()[3])
        graph.getNodes()[3].addNeighbor(graph.getNodes()[9])
        graph.getNodes()[9].addNeighbor(graph.getNodes()[10])
        graph.getNodes()[10].addNeighbor(graph.getNodes()[9])

        ////Arestas sala 142
        graph.getNodes()[11].addNeighbor(graph.getNodes()[10])
        graph.getNodes()[11].addNeighbor(graph.getNodes()[5])
        graph.getNodes()[5].addNeighbor(graph.getNodes()[11])

        ////Arestas salas 145 e 143
        graph.getNodes()[11].addNeighbor(graph.getNodes()[12])
        graph.getNodes()[12].addNeighbor(graph.getNodes()[11])
        graph.getNodes()[12].addNeighbor(graph.getNodes()[4])
        graph.getNodes()[12].addNeighbor(graph.getNodes()[6])
        graph.getNodes()[4].addNeighbor(graph.getNodes()[12])
        graph.getNodes()[6].addNeighbor(graph.getNodes()[12])

        ////Arestas sala 144
        graph.getNodes()[12].addNeighbor(graph.getNodes()[13])
        graph.getNodes()[13].addNeighbor(graph.getNodes()[12])
        graph.getNodes()[13].addNeighbor(graph.getNodes()[7])
        graph.getNodes()[7].addNeighbor(graph.getNodes()[13])

        ////Arestas corredor central
        graph.getNodes()[14].addNeighbor(graph.getNodes()[13])
        graph.getNodes()[14].addNeighbor(graph.getNodes()[15])
        graph.getNodes()[15].addNeighbor(graph.getNodes()[14])

        ////Arestas corredor baixo
        graph.getNodes()[15].addNeighbor(graph.getNodes()[16])
        graph.getNodes()[16].addNeighbor(graph.getNodes()[15])
        graph.getNodes()[16].addNeighbor(graph.getNodes()[17])
        graph.getNodes()[17].addNeighbor(graph.getNodes()[16])
        graph.getNodes()[17].addNeighbor(graph.getNodes()[18])
        graph.getNodes()[18].addNeighbor(graph.getNodes()[17])
        graph.getNodes()[18].addNeighbor(graph.getNodes()[19])
        graph.getNodes()[19].addNeighbor(graph.getNodes()[18])


        //Arestas banheiros
        graph.getNodes()[20].addNeighbor(graph.getNodes()[17])
        graph.getNodes()[17].addNeighbor(graph.getNodes()[20])
        graph.getNodes()[17].addNeighbor(graph.getNodes()[21])
        graph.getNodes()[21].addNeighbor(graph.getNodes()[17])
        graph.getNodes()[22].addNeighbor(graph.getNodes()[17])
        graph.getNodes()[17].addNeighbor(graph.getNodes()[22])

        //Arestas sala 150
        graph.getNodes()[18].addNeighbor(graph.getNodes()[23])
        graph.getNodes()[23].addNeighbor(graph.getNodes()[18])

        //Arestas sala 151
        graph.getNodes()[19].addNeighbor(graph.getNodes()[24])
        graph.getNodes()[24].addNeighbor(graph.getNodes()[19])

        //Arestas sala 152
        graph.getNodes()[19].addNeighbor(graph.getNodes()[25])
        graph.getNodes()[25].addNeighbor(graph.getNodes()[19])

        //Arestas sala 153
        graph.getNodes()[19].addNeighbor(graph.getNodes()[26])
        graph.getNodes()[26].addNeighbor(graph.getNodes()[19])

        //Arestas sala 154
        graph.getNodes()[19].addNeighbor(graph.getNodes()[27])
        graph.getNodes()[27].addNeighbor(graph.getNodes()[19])

        //Arestas sala misterio
        graph.getNodes()[19].addNeighbor(graph.getNodes()[28])
        graph.getNodes()[28].addNeighbor(graph.getNodes()[19])

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
                    drawConnection(canvas, startNode.x, startNode.y, endNode.x, endNode.y, Color.parseColor("#2d9bf0"), 15f)
                }
            }
        }
    }

    private fun drawNode(canvas: Canvas, x: Float, y: Float) {
        // Desenhe um círculo representando um nó do grafo
        paint.color = Color.BLACK
        paint.strokeWidth = 5f
        canvas.drawCircle(x, y, 0.1f, paint)
    }

    private fun drawConnection(canvas: Canvas, startX: Float, startY: Float, endX: Float, endY: Float, color: Int = Color.BLACK, strokeWidth: Float = 5f) {
        paint.color = color
        paint.strokeWidth = strokeWidth

        // Desenhe uma linha representando uma conexão entre os nós
        canvas.drawLine(startX, startY, endX, endY, paint)
    }
}











