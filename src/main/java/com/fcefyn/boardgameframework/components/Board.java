package com.fcefyn.boardgameframework.components;

import com.fcefyn.boardgameframework.components.tile.TileEntity;

import static com.almasb.fxgl.dsl.FXGL.*;

/**
 * Generic board for implementation in multitple games
 *
 * @author Nicolas Papp (nicolaspapp@gmail.com)
 */
public class Board {

    private TileEntity[][] board;

    public Board(int rows, int columns){
        board = new TileEntity[rows][columns];
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < columns; x++) {
                TileEntity tile = new TileEntity(x * getAppWidth() / columns, y * getAppHeight() / rows,
                        rows, columns);
                board[y][x] = tile;
                getGameWorld().addEntity(tile);
            }
        }
    }
}
