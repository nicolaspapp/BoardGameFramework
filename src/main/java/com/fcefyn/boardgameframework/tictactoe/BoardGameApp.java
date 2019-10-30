package com.fcefyn.boardgameframework.tictactoe;

import com.fcefyn.boardgameframework.components.tile.TileEntity;

public interface BoardGameApp {
    void onUserMove(TileEntity tile);
}
