package com.fcefyn.boardgameframework.components.game;

import com.fcefyn.boardgameframework.components.tile.TileEntity;

public interface BoardGameApp {
    void onUserMove(TileEntity tile);
}
