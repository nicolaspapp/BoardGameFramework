package com.fcefyn.boardgameframework.components.game;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.fcefyn.boardgameframework.components.tile.TileEntity;

/**
 * Adapts GameApplication
 *
 * @author Nicolas Papp (nicolaspapp@gmail.com)
 */
public abstract class TwoPlayerGameApplication extends GameApplication implements BoardGameApp {

    private boolean playerOneTurn = true;

    @Override
    protected abstract void initSettings(GameSettings gameSettings);

    @Override
    public void onUserMove(TileEntity tile) {
        boolean ok;
        if(playerOneTurn)
            ok = playerOneMove(tile);
        else
            ok = playerTwoMove(tile);

        if (ok) {
            final boolean over = checkPlayerHasWon();
            if(over){
                playWinAnimation();
            }
            playerOneTurn = !playerOneTurn;
        }
    }

    /**
     * Logic when Player One clicks on a tile
     * @param tile: tile that has been clicked
     * @return: true if movement is posible, false otherwise
     */
    public abstract boolean playerOneMove(TileEntity tile);

    /**
     * Logic when Player Two clicks on a tile
     * @param tile: tile that has been clicked
     * @return: true if movement is posible, false otherwise
     */
    public abstract boolean playerTwoMove(TileEntity tile);

    /**
     * Check if player that just moved has won the match
     * @return: true if match has eneded, false otherwise
     */
    public abstract boolean checkPlayerHasWon();

    /**
     * Plays a win animation before ending the game
     */
    public abstract void playWinAnimation();
}
