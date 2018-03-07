package com.facebook.android.maps.model;

import com.facebook.android.maps.FacebookMap;
import com.facebook.android.maps.TiledMapDrawable;
import com.facebook.android.maps.internal.TileTree;

/* compiled from: available_for_sale_count */
public class TileOverlay extends TiledMapDrawable {
    private final TileProvider f8437x;

    public TileOverlay(FacebookMap facebookMap, TileOverlayOptions tileOverlayOptions, TileTree tileTree) {
        super(facebookMap, tileTree);
        this.i = tileOverlayOptions.f8672c;
        this.u = tileOverlayOptions.f8671b;
        this.f8437x = tileOverlayOptions.f8670a;
    }

    protected Tile mo1069b(int i, int i2, int i3) {
        return this.f8437x.mo1066b(i, i2, i3);
    }
}
