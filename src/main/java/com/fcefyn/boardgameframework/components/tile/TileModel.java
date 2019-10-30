package com.fcefyn.boardgameframework.components.tile;

import com.almasb.fxgl.entity.components.ObjectComponent;
import com.fcefyn.boardgameframework.components.tile.TileValue;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public class TileModel extends ObjectComponent<TileValue> {

    public TileModel() {
        super(TileValue.NONE);
    }
}
