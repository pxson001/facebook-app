package com.facebook.nearby.data;

import android.graphics.RectF;
import com.facebook.common.time.Clock;
import com.facebook.nearby.model.MapTile;
import com.google.common.annotations.VisibleForTesting;
import java.util.List;

/* compiled from: user_bulk_accepted */
public class TilesHelper {
    private final Clock f322a;

    public TilesHelper(Clock clock) {
        this.f322a = clock;
    }

    public final double m415a(RectF rectF, List<MapTile> list) {
        double d = 0.0d;
        for (MapTile mapTile : list) {
            d = m413a(m414a(rectF, new RectF((float) mapTile.bounds.l(), (float) mapTile.bounds.j(), (float) mapTile.bounds.a(), (float) mapTile.bounds.k()))) + d;
        }
        return d / m413a(rectF);
    }

    public final boolean m416a(List<MapTile> list) {
        long a = this.f322a.a() / 1000;
        for (MapTile a2 : list) {
            if (a2.m484a(a)) {
                return true;
            }
        }
        return false;
    }

    @VisibleForTesting
    private static RectF m414a(RectF rectF, RectF rectF2) {
        return new RectF(Math.max(rectF2.left, rectF.left), Math.min(rectF2.top, rectF.top), Math.min(rectF2.right, rectF.right), Math.max(rectF2.bottom, rectF.bottom));
    }

    private static double m413a(RectF rectF) {
        return (double) Math.abs(rectF.height() * rectF.width());
    }
}
