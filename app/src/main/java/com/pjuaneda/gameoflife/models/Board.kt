package com.pjuaneda.gameoflife.models

data class Board(val maxX: Int, val maxY: Int) {
    var cells: List<Cell>

    init {
        val cellList = mutableListOf<Cell>()
        for (x in 0 until maxX){
            for (y in 0 until maxY){
                cellList.add(Cell(LifeState.DEAD, x, y))
            }
        }
        cells = cellList
    }
}

fun Board.getNeighborsCell(cell: Cell): List<Cell> {
    return this.cells.filter { it.x in (cell.x-1)..(cell.x+1) && it.y in (cell.y -1)..(cell.y + 1)}
        .filterNot { it.x == cell.x && it.y == cell.y }
}