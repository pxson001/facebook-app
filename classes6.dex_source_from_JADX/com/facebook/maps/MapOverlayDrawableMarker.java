package com.facebook.maps;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.Location;

/* compiled from: web_view_search_box_single_state_no_pulse */
public class MapOverlayDrawableMarker implements MapOverlayMarker {
    private final Location f267a;
    private final Drawable f268b;
    public final int f269c;
    public final Rect f270d = new Rect();

    public MapOverlayDrawableMarker(Resources resources, Location location, int i, int i2) {
        this.f267a = location;
        this.f268b = resources.getDrawable(i);
        this.f269c = i2;
        this.f268b.getPadding(this.f270d);
    }

    public final Location mo36a() {
        return this.f267a;
    }

    public int mo38b() {
        return this.f268b.getMinimumWidth();
    }

    public int mo39c() {
        return this.f268b.getMinimumHeight();
    }

    public void mo37a(Canvas canvas, Point point) {
        this.f268b.setBounds(new Rect(point.x - (mo38b() / 2), (point.y - mo39c()) + this.f269c, point.x + (mo38b() / 2), point.y + this.f269c));
        this.f268b.draw(canvas);
    }
}
