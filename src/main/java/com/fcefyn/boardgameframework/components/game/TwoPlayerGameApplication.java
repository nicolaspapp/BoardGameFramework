package com.fcefyn.boardgameframework.components.game;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.fcefyn.boardgameframework.components.game.BoardGameApp;
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
            playerOneTurn = !playerOneTurn;
        }
    }

    public abstract boolean playerOneMove(TileEntity tile);

    public abstract boolean playerTwoMove(TileEntity tile);
}
