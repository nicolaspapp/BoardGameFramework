package com.fcefyn.boardgameframework.components.tile;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;

/**
 * Generic Tile entity for board games
 *
 * @author Nicolas Papp (nicolaspapp@gmail.com)
 * */
public class TileEntity extends Entity {

    public TileEntity(double x, double y, int rows, int columns) {
        setX(x);
        setY(y);
        addComponent(new TileModel());

        getBoundingBoxComponent().addHitBox(new HitBox(BoundingShape.box(FXGL.getAppWidth() / columns, FXGL.getAppHeight() / rows)));
        getViewComponent().addChild(new TileView(this));
        addComponent(new TileController());
    }

    public TileValue getValue() {
        return getComponent(TileModel.class).getValue();
    }

    public TileController getControl() {
        return getComponent(TileController.class);
    }
}
