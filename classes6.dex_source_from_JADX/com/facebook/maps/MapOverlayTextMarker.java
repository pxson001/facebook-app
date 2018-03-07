package com.facebook.maps;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.location.Location;

/* compiled from: web_always */
public class MapOverlayTextMarker extends MapOverlayDrawableMarker {
    private final Paint f271a;
    private final float f272b;
    private final Rect f273c;
    private final int f274d;
    private final int f275e;
    private final Rect f276f = this.f270d;
    private final String f277g;

    @SuppressLint({"BadMethodUse-java.lang.String.length"})
    public MapOverlayTextMarker(Resources resources, Location location, String str, int i) {
        super(resources, location, 2130843570, resources.getDimensionPixelOffset(2131427822));
        int dimensionPixelOffset = resources.getDimensionPixelOffset(2131427823);
        this.f275e = dimensionPixelOffset;
        this.f274d = dimensionPixelOffset;
        this.f277g = str;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextSize((float) i);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.setTextAlign(Align.CENTER);
        paint.setColor(-16777216);
        paint.setStyle(Style.FILL);
        this.f271a = paint;
        this.f272b = this.f271a.measureText(str);
        this.f273c = new Rect();
        this.f271a.getTextBounds(str, 0, str.length(), this.f273c);
    }

    public final int mo38b() {
        return Math.max(super.mo38b(), (int) (((this.f272b + ((float) (this.f275e * 2))) + ((float) this.f276f.left)) + ((float) this.f276f.right)));
    }

    public final int mo39c() {
        return Math.max(super.mo39c(), ((this.f273c.height() + (this.f274d * 2)) + this.f276f.top) + this.f276f.bottom);
    }

    public final void mo37a(Canvas canvas, Point point) {
        super.mo37a(canvas, point);
        canvas.drawText(this.f277g, (float) point.x, (float) ((((point.y + this.f269c) - this.f276f.bottom) - (((mo39c() - this.f276f.bottom) - this.f276f.top) / 2)) + (this.f273c.height() / 2)), this.f271a);
    }
}
