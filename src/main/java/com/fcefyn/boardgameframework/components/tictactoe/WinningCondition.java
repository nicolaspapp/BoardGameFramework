package com.fcefyn.boardgameframework.components.tictactoe;

import com.fcefyn.boardgameframework.components.Board;
import com.fcefyn.boardgameframework.components.tile.TileEntity;
import com.fcefyn.boardgameframework.components.tile.TileValue;

/**
 * Determines winning conditions for TicTacToe Game
 */
public class WinningCondition {

    private Board board;
    private TileEntity winnerTiles[];

    public WinningCondition(Board board){
        this.board = board;
    }

    public boolean hasWon(){
        return checkRows() || checkColumns() || checkDiagonals();
    }

    public TileEntity[] getWinnerTiles(){
        return winnerTiles;
    }

    /**
     * Checks 3 in row
     * @return
     */
    private boolean checkRows(){
        for(TileEntity[] row: board.getTiles()){
            int column=0;
            while(column+2 < row.length){
                if(checkTiles(row[column], row[column+1], row[column+2])){
                    return true;
                }
                column++;
            }
        }
        return false;
    }

    /**
     * Checks 3 in columns
     * @return
     */
    private boolean checkColumns(){
        TileEntity[][] tiles = board.getTiles();
        int columns_size = tiles[0].length;
        for(int columns=0; columns < columns_size; columns++){
            int rows = 0;
            while(rows+2 < tiles.length){
                if(checkTiles(tiles[rows][columns], tiles[rows+1][columns], tiles[rows+2][columns])){
                    return true;
                }
                rows++;
            }
        }
        return false;
    }

    /**
     * Check tiles in diagonals
     * @return
     */
    private boolean checkDiagonals(){
        TileEntity[][] tiles = board.getTiles();
        int columns=0;
        int rows=0;
        while(rows+2 < tiles.length){
            while (columns+2 < tiles[0].length){
                if(checkTiles(tiles[rows][columns], tiles[rows+1][columns+1], tiles[rows+2][columns+2]))
                    return true;
                columns++;
            }
            rows++;
        }

        rows=0;
        columns=tiles[0].length-1;
        while(rows+2 < tiles.length){
            while(columns-2 >= 0){
                if(checkTiles(tiles[rows][columns], tiles[rows+1][columns-1], tiles[rows+2][columns-2]))
                    return true;
                columns--;
            }
            rows++;
        }

        return false;
    }


    /**
     * Check if tiles 1,2 and 3 have the same value
     * @param tile1
     * @param tile2
     * @param tile3
     * @return
     */
    private boolean checkTiles(TileEntity tile1, TileEntity tile2, TileEntity tile3){
        if(tile1.getValue() != TileValue.NONE
                && tile1.getValue() == tile2.getValue()
                && tile1.getValue() == tile3.getValue()){
            winnerTiles = new TileEntity[3];
            winnerTiles[0] = tile1;
            winnerTiles[1] = tile2;
            winnerTiles[2] = tile3;
            return true;
        }
        return false;
    }
}
