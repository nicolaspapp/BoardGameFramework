package com.fcefyn.boardgameframework.apps;

import com.almasb.fxgl.app.GameSettings;
import com.fcefyn.boardgameframework.components.Board;
import com.fcefyn.boardgameframework.components.game.TwoPlayerGameApplication;
import com.fcefyn.boardgameframework.components.tictactoe.WinningCondition;
import com.fcefyn.boardgameframework.components.tile.TileEntity;
import com.fcefyn.boardgameframework.components.tile.TileValue;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGL.*;
import static com.almasb.fxgl.dsl.FXGL.getGameController;

public class TicTacToe extends TwoPlayerGameApplication {

    private Board board;
    private static final int boardRows = 4;
    private static final int boardColumns = 4;

    private WinningCondition checkWinning;

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
        board = new Board(boardRows,boardColumns);
        checkWinning = new WinningCondition(board);
    }

    @Override
    protected void initUI() {

    }

    @Override
    public boolean playerOneMove(TileEntity tile) {
        return tile.getControl().mark(TileValue.X);
    }

    @Override
    public boolean playerTwoMove(TileEntity tile) {
        return tile.getControl().mark(TileValue.O);
    }

    @Override
    public boolean checkPlayerHasWon() {
        return checkWinning.hasWon();
    }

    @Override
    public void playWinAnimation() {
        TileEntity[] winningTiles = checkWinning.getWinnerTiles();
        Line line = new Line();
        line.setStartX(winningTiles[0].getCenter().getX());
        line.setStartY(winningTiles[0].getCenter().getY());
        line.setEndX(winningTiles[0].getCenter().getX());
        line.setEndY(winningTiles[0].getCenter().getY());
        line.setStroke(Color.YELLOW);
        line.setStrokeWidth(3);

        getGameScene().addUINode(line);

        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1),
                new KeyValue(line.endXProperty(), winningTiles[2].getCenter().getX()),
                new KeyValue(line.endYProperty(), winningTiles[2].getCenter().getY())));
        timeline.setOnFinished(e -> gameOver(winningTiles[0].getValue().toString()));
        timeline.play();
    }

    private void gameOver(String winner) {
        getDisplay().showConfirmationBox("Winner: " + winner + "\nContinue?", yes -> {
            if (yes)
                getGameController().startNewGame();
            else
                getGameController().exit();
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
