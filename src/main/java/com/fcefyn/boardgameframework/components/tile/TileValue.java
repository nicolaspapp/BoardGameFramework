package com.fcefyn.boardgameframework.components.tile;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public enum TileValue {
    X("X"), O("O"), NONE("");

    final String symbol;

    TileValue(String symbol) {
        this.symbol = symbol;
    }
}
