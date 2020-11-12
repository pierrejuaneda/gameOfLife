package com.pjuaneda.gameoflife

import com.pjuaneda.gameoflife.controllers.GameOfLife
import com.pjuaneda.gameoflife.models.LifeState
import org.junit.Test

class GameOfLifeUnitTest {

    @Test
    fun testNextCycleIncrementTheCellsBlinkPattern() {
        val game = GameOfLife()
        game.board.cells.firstOrNull { cell -> cell.x == 0 && cell.y == 1 }?.state = LifeState.LIVING
        game.board.cells.firstOrNull { cell -> cell.x == 1 && cell.y == 1 }?.state = LifeState.LIVING
        game.board.cells.firstOrNull { cell -> cell.x == 2 && cell.y == 1 }?.state = LifeState.LIVING

        game.nextCycle()

        assert(game.board.cells.firstOrNull { cell -> cell.x == 1 && cell.y == 0 }?.state == LifeState.LIVING)
        assert(game.board.cells.firstOrNull { cell -> cell.x == 1 && cell.y == 1 }?.state == LifeState.LIVING)
        assert(game.board.cells.firstOrNull { cell -> cell.x == 1 && cell.y == 2 }?.state == LifeState.LIVING)
        assert(game.board.cells.firstOrNull { cell -> cell.x == 0 && cell.y == 1 }?.state == LifeState.DEAD)
        assert(game.board.cells.firstOrNull { cell -> cell.x == 2 && cell.y == 1 }?.state == LifeState.DEAD)
    }

    @Test
    fun testNextCycleIncrementTheCellsUPattern() {
        val game = GameOfLife()
        game.board.cells.firstOrNull { cell -> cell.x == 0 && cell.y == 0 }?.state = LifeState.LIVING
        game.board.cells.firstOrNull { cell -> cell.x == 0 && cell.y == 1 }?.state = LifeState.LIVING
        game.board.cells.firstOrNull { cell -> cell.x == 0 && cell.y == 2 }?.state = LifeState.LIVING
        game.board.cells.firstOrNull { cell -> cell.x == 1 && cell.y == 2 }?.state = LifeState.LIVING
        game.board.cells.firstOrNull { cell -> cell.x == 2 && cell.y == 2 }?.state = LifeState.LIVING
        game.board.cells.firstOrNull { cell -> cell.x == 2 && cell.y == 1 }?.state = LifeState.LIVING
        game.board.cells.firstOrNull { cell -> cell.x == 2 && cell.y == 0 }?.state = LifeState.LIVING

        game.nextCycle()

        assert(game.board.cells.firstOrNull { cell -> cell.x == 0 && cell.y == 0 }?.state == LifeState.DEAD)
        assert(game.board.cells.firstOrNull { cell -> cell.x == 0 && cell.y == 1 }?.state == LifeState.LIVING)
        assert(game.board.cells.firstOrNull { cell -> cell.x == 0 && cell.y == 2 }?.state == LifeState.LIVING)
        assert(game.board.cells.firstOrNull { cell -> cell.x == 1 && cell.y == 2 }?.state == LifeState.DEAD)
        assert(game.board.cells.firstOrNull { cell -> cell.x == 2 && cell.y == 1 }?.state == LifeState.LIVING)
        assert(game.board.cells.firstOrNull { cell -> cell.x == 2 && cell.y == 2 }?.state == LifeState.LIVING)
        assert(game.board.cells.firstOrNull { cell -> cell.x == 2 && cell.y == 0 }?.state == LifeState.DEAD)
    }

}