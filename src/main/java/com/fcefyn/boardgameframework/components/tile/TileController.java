package com.fcefyn.boardgameframework.components.tile;

import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.entity.component.Required;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
@Required(TileModel.class)
public class TileController extends Component {

    /**
     * @param value tile value
     * @return true if marking succeeded
     */
    public boolean mark(TileValue value) {
        TileModel valueComponent = getEntity().getComponent(TileModel.class);

        if (valueComponent.getValue() != TileValue.NONE)
            return false;

        valueComponent.setValue(value);

        return true;
    }
}
