// src/main/kotlin/com/seu_pacote_do_projeto/Pathfinding.kt
class Pathfinding(private val nodes: List<Node>, private val connections: List<Connection>) {

    fun findPath(startId: Int, endId: Int): List<Node> {
        val start = nodes.find { it.id == startId } ?: throw IllegalArgumentException("Node not found: $startId")
        val end = nodes.find { it.id == endId } ?: throw IllegalArgumentException("Node not found: $endId")

        val distances = mutableMapOf<Node, Float>()
        val previousNodes = mutableMapOf<Node, Node>()
        val unvisitedNodes = nodes.toMutableSet()

        distances[start] = 0F

        while (unvisitedNodes.isNotEmpty()) {
            val currentNode = getClosestNode(unvisitedNodes, distances)
            unvisitedNodes.remove(currentNode)

            for (connection in connections.filter { it.from == currentNode }) {
                val neighbor = connection.to
                val newDistance = distances[currentNode]!! + connection.weight

                if (newDistance < (distances[neighbor] ?: Float.MAX_VALUE)) {
                    distances[neighbor] = newDistance
                    previousNodes[neighbor] = currentNode
                }
            }
        }

        return buildPath(end, previousNodes)
    }

    private fun getClosestNode(nodes: Set<Node>, distances: Map<Node, Float>): Node {
        return nodes.minByOrNull { distances[it] ?: Float.MAX_VALUE } ?: throw NoSuchElementException("No closest node.")
    }

    private fun buildPath(end: Node, previousNodes: Map<Node, Node>): List<Node> {
        val path = mutableListOf<Node>()
        var current = end

        while (previousNodes.containsKey(current)) {
            path.add(current)
            current = previousNodes[current]!!
        }

        path.add(current)
        path.reverse()

        return path
    }
}
