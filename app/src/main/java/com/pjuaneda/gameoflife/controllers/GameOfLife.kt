package com.pjuaneda.gameoflife.controllers

import com.pjuaneda.gameoflife.models.Board
import com.pjuaneda.gameoflife.models.Cell
import com.pjuaneda.gameoflife.models.LifeState
import com.pjuaneda.gameoflife.models.getNeighborsCell

class GameOfLife {

    val board: Board = Board(3,3)

    fun nextCycle(){
        val newCells = mutableListOf<Cell>()
        board.cells.forEach { cell ->
            val livingNeighbors = board.getNeighborsCell(cell).filter { it.state == LifeState.LIVING }
            if(cell.state == LifeState.LIVING && livingNeighbors.count() != 2 && livingNeighbors.count() != 3) {
                newCells.add(cell.copy(state = LifeState.DEAD))
            } else if (cell.state == LifeState.DEAD && livingNeighbors.count() == 3){
                newCells.add(cell.copy(state = LifeState.LIVING))
            } else {
                newCells.add(cell)
            }
        }
        board.cells = newCells
    }

}