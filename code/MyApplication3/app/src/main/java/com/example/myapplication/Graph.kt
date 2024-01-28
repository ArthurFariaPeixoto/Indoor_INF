package com.example.myapplication

data class Node(val id: Int, val x: Float, val y: Float){
    val neighbors: MutableList<Node> = mutableListOf()

    fun addNeighbor(neighbor: Node) {
        neighbors.add(neighbor)
    }
}

class Graph {

    private val nodes = mutableListOf<Node>()
    private var shortestPath = emptyList<Node>()

    fun addNode(id: Int, x: Float, y: Float) {
        nodes.add(Node(id, x, y))
    }

    fun getNodes(): List<Node> {
        return nodes
    }
    

    fun calculateShortestPath(startNodeId: Int, endNodeId: Int): List<Node> {
        val startNode = nodes.find { it.id == startNodeId }
        val endNode = nodes.find { it.id == endNodeId }

        if (startNode != null && endNode != null) {
            // Redefinição da propriedade shortestPath
            shortestPath = emptyList()

            // Verificação da existência de arestas
            fun hasEdge(node1: Node, node2: Node): Boolean {
                val neighbors = node1.neighbors
                for (neighbor in neighbors) {
                    if (neighbor.id == node2.id) {
                        return true
                    }
                }
                return false
            }

            // Algoritmo de Dijkstra
            val distances = mutableMapOf<Node, Float>()
            val previousNodes = mutableMapOf<Node, Node?>()
            val unvisitedNodes = nodes.toMutableList()

            distances[startNode] = 0f

            while (unvisitedNodes.isNotEmpty()) {
                val currentNode = unvisitedNodes.minByOrNull { distances.getOrDefault(it, Float.POSITIVE_INFINITY) }!!

                unvisitedNodes.remove(currentNode)

                for (neighbor in unvisitedNodes) {
                    if (hasEdge(currentNode, neighbor)) {
                        val tentativeDistance = distances.getOrDefault(currentNode, Float.POSITIVE_INFINITY) +
                                calculateDistance(currentNode, neighbor)

                        if (tentativeDistance < distances.getOrDefault(neighbor, Float.POSITIVE_INFINITY)) {
                            distances[neighbor] = tentativeDistance
                            previousNodes[neighbor] = currentNode
                        }
                    }
                }
            }

            // Construção do caminho
            shortestPath = buildPath(startNode, endNode, previousNodes)
            return shortestPath
        }

        return emptyList()
    }

    fun getShortestPath(): List<Node> {
        return shortestPath
    }

    private fun calculateDistance(node1: Node, node2: Node): Float {
        val deltaX = node2.x - node1.x
        val deltaY = node2.y - node1.y
        return Math.sqrt((deltaX * deltaX + deltaY * deltaY).toDouble()).toFloat()
    }

    private fun buildPath(startNode: Node, endNode: Node, previousNodes: Map<Node, Node?>): List<Node> {
        val path = mutableListOf<Node>()
        var currentNode: Node? = endNode

        while (currentNode != null) {
            path.add(currentNode)
            currentNode = previousNodes[currentNode]
        }

        return path.reversed()
    }
}




