package com.facebook.android.maps.model;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import com.facebook.android.maps.FacebookMap;
import com.facebook.android.maps.Projection;
import com.facebook.android.maps.WrappedMapDrawable;
import com.facebook.android.maps.internal.RectD;

/* compiled from: authorize */
public final class Circle extends WrappedMapDrawable {
    private LatLng f8550o;
    private int f8551p;
    private double f8552q;
    private int f8553r;
    private float f8554s;
    private final Paint f8555t = new Paint(1);
    private final float[] f8556u = new float[2];
    private final RectD f8557v = new RectD();
    private float f8558w;
    private float f8559x;
    private float f8560y;

    public Circle(FacebookMap facebookMap, CircleOptions circleOptions) {
        super(facebookMap);
        this.f8550o = circleOptions.f8561a;
        this.f8551p = circleOptions.f8562b;
        this.f8552q = circleOptions.f8563c;
        this.f8553r = circleOptions.f8564d;
        this.f8554s = circleOptions.f8565e;
        this.k = circleOptions.f8567g;
        this.i = circleOptions.f8566f;
        m14561q();
    }

    private void m14561q() {
        this.m = (double) Projection.d(this.f8550o.f8569b);
        this.n = (double) Projection.b(this.f8550o.f8568a);
        this.f8557v.a = (double) Projection.b(Math.toDegrees(this.f8552q / 6371009.0d) + this.f8550o.f8568a);
        double d = this.f8089n - this.f8557v.a;
        this.f8557v.b = this.f8089n + d;
        this.f8557v.c = this.f8088m - d;
        this.f8557v.d = d + this.f8088m;
    }

    public final LatLng mo1081a() {
        return this.f8550o;
    }

    public final void m14564a(LatLng latLng) {
        this.f8550o = latLng;
        m14561q();
        m14231f();
    }

    public final void m14563a(double d) {
        this.f8552q = d;
        m14561q();
        m14231f();
    }

    protected final RectD mo1083c() {
        return this.f8557v;
    }

    protected final boolean mo1084p() {
        this.f8081f.a(this.f8088m, this.f8089n, this.f8556u);
        this.f8558w = this.f8556u[0];
        this.f8559x = this.f8556u[1];
        this.f8081f.a(this.f8088m, this.f8557v.a, this.f8556u);
        this.f8560y = (float) Math.hypot((double) (this.f8556u[0] - this.f8558w), (double) (this.f8556u[1] - this.f8559x));
        return true;
    }

    protected final void mo1082b(Canvas canvas) {
        this.f8555t.setStyle(Style.FILL);
        this.f8555t.setColor(this.f8551p);
        canvas.drawCircle(this.f8558w, this.f8559x, this.f8560y, this.f8555t);
        if (this.f8554s > 0.0f) {
            this.f8555t.setStyle(Style.STROKE);
            this.f8555t.setColor(this.f8553r);
            this.f8555t.setStrokeWidth(this.f8554s);
            canvas.drawCircle(this.f8558w, this.f8559x, this.f8560y, this.f8555t);
        }
    }
}
