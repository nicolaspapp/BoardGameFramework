package com.fcefyn.boardgameframework.apps;

import com.almasb.fxgl.app.GameSettings;
import com.fcefyn.boardgameframework.components.Board;
import com.fcefyn.boardgameframework.components.game.TwoPlayerGameApplication;
import com.fcefyn.boardgameframework.components.tile.TileEntity;
import com.fcefyn.boardgameframework.components.tile.TileValue;

public class TicTacToe extends TwoPlayerGameApplication {

    private Board board;
    private static final int boardRows = 3;
    private static final int boardColumns = 3;

    @Override
    protected void initSettings(GameSettings settings) {
        // Main Window initialization
        settings.setTitle("TicTacToe");
        settings.setVersion("0.0");
        settings.setWidth(200 * boardColumns);
        settings.setHeight(200 * boardRows);
    }

    @Override
    protected void initGame() {
    }

    @Override
    protected void initUI() {
        board = new Board(boardRows,boardColumns);
    }

    @Override
    public boolean playerOneMove(TileEntity tile) {
        return tile.getControl().mark(TileValue.X);
    }

    @Override
    public boolean playerTwoMove(TileEntity tile) {
        return tile.getControl().mark(TileValue.O);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
