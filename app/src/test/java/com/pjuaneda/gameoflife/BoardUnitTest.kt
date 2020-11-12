package com.pjuaneda.gameoflife

import com.pjuaneda.gameoflife.models.Board
import com.pjuaneda.gameoflife.models.Cell
import com.pjuaneda.gameoflife.models.LifeState
import com.pjuaneda.gameoflife.models.getNeighborsCell
import org.junit.Test

class BoardUnitTest {
    @Test
    fun testInitializeBoardGivesTheGoodAmountOfCells() {
        val maxX = 9
        val maxY = 9
        val board = Board(maxX, maxY)
        assert(board.cells.count() == (maxX * maxY))
    }

    @Test
    fun testInitializeBoardPopulatesTheCell() {
        val maxX = 9
        val maxY = 9
        val board = Board(maxX, maxY)
        assert(board.cells.first().x == 0)
        assert(board.cells.first().y == 0)

        assert(board.cells.last().x == maxX - 1)
        assert(board.cells.last().y == maxY - 1)

        assert(board.cells.get(16).x == 1)
        assert(board.cells.get(16).y == 7)
    }

    @Test
    fun testGetNeighborCells() {
        val board = Board(9,9)
        val cell = Cell(LifeState.DEAD, 3,3)
        val neighbors = board.getNeighborsCell(cell)
        assert(neighbors.minBy { it.x }?.x == cell.x - 1)
        assert(neighbors.minBy { it.y }?.y == cell.y - 1)
        assert(neighbors.maxBy { it.x }?.x == cell.x + 1)
        assert(neighbors.maxBy { it.y }?.y == cell.y + 1)
        assert(neighbors.firstOrNull { it.x == cell.x - 1 && it.y == cell.y - 1 } != null)
        assert(neighbors.firstOrNull { it.x == cell.x + 1 && it.y == cell.y - 1 } != null)
        assert(neighbors.firstOrNull { it.x == cell.x + 1 && it.y == cell.y + 1 } != null)
        assert(neighbors.firstOrNull { it.x == cell.x - 1 && it.y == cell.y + 1 } != null)
        assert(neighbors.firstOrNull { it.x == cell.x  && it.y == cell.y } == null)
        assert(neighbors.count() == 8)
    }
}