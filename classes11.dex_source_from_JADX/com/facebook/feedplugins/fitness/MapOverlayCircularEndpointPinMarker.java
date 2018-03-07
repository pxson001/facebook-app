package com.facebook.feedplugins.fitness;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.location.Location;
import com.facebook.maps.MapOverlayMarker;

/* compiled from: device_token */
public class MapOverlayCircularEndpointPinMarker implements MapOverlayMarker {
    private final Paint f7628a;
    private final int f7629b;
    private final int f7630c;
    private final int f7631d;
    private final int f7632e;
    private final int f7633f;
    private final int f7634g;
    private final Location f7635h;

    public MapOverlayCircularEndpointPinMarker(Resources resources, Location location) {
        this.f7635h = location;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Style.FILL);
        this.f7628a = paint;
        this.f7629b = resources.getColor(2131363071);
        this.f7630c = resources.getColor(2131363070);
        this.f7631d = resources.getColor(2131363072);
        this.f7632e = resources.getDimensionPixelSize(2131430245);
        this.f7633f = resources.getDimensionPixelSize(2131430244);
        this.f7634g = resources.getDimensionPixelSize(2131430246);
    }

    public final Location m8849a() {
        return this.f7635h;
    }

    public final int m8851b() {
        return this.f7632e * 2;
    }

    public final int m8852c() {
        return this.f7632e * 2;
    }

    public final void m8850a(Canvas canvas, Point point) {
        this.f7628a.setColor(this.f7629b);
        canvas.drawCircle((float) point.x, (float) point.y, (float) this.f7632e, this.f7628a);
        this.f7628a.setColor(this.f7630c);
        canvas.drawCircle((float) point.x, (float) point.y, (float) this.f7633f, this.f7628a);
        this.f7628a.setColor(this.f7631d);
        canvas.drawCircle((float) point.x, (float) point.y, (float) this.f7634g, this.f7628a);
    }
}
