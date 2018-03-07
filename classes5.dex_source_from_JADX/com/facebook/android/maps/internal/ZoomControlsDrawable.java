package com.facebook.android.maps.internal;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import com.facebook.android.maps.CameraUpdateFactory;
import com.facebook.android.maps.FacebookMap;
import com.facebook.android.maps.MapDrawable;
import com.facebook.android.maps.MapView;

/* compiled from: auto_translated_message */
public class ZoomControlsDrawable extends MapDrawable {
    private final Paint f8526o;
    private float f8527p;
    private float f8528q;
    private float f8529r;
    private float f8530s;
    private float f8531t;
    private float f8532u;
    private int f8533v;

    public ZoomControlsDrawable(FacebookMap facebookMap) {
        super(facebookMap);
        this.f8526o = new Paint(1);
        this.f8527p = 12.0f * this.f8079d;
        this.f8528q = 37.0f * this.f8079d;
        this.f8529r = 0.5f * this.f8079d;
        this.f8530s = this.f8079d * 2.0f;
        this.j = 3;
        this.k = 2.0f;
        this.l = false;
    }

    public final int mo1031a(float f, float f2) {
        if (f >= this.f8531t - this.f8528q && f <= this.f8531t && f2 >= this.f8532u - (this.f8528q * 2.0f) && f2 <= this.f8532u) {
            if (f2 < this.f8532u - this.f8528q) {
                this.f8533v = 1;
                return 2;
            } else if (f2 > this.f8532u - this.f8528q) {
                this.f8533v = 2;
                return 2;
            }
        }
        this.f8533v = 0;
        return 0;
    }

    public final void mo1078m() {
        if (this.f8533v != 0) {
            m14231f();
        }
    }

    public final void mo1079n() {
        if (this.f8533v == 1) {
            this.f8080e.m14282a(CameraUpdateFactory.m14200a(), 200, null);
        } else if (this.f8533v == 2) {
            this.f8080e.m14282a(CameraUpdateFactory.m14206b(), 200, null);
        }
        this.f8533v = 0;
        m14231f();
    }

    public final boolean mo1077d(float f, float f2) {
        if (this.f8533v == 1) {
            mo1031a(f, f2);
            if (this.f8533v != 1) {
                this.f8533v = 0;
            }
        } else if (this.f8533v == 2) {
            mo1031a(f, f2);
            if (this.f8533v != 2) {
                this.f8533v = 0;
            }
        }
        m14231f();
        if (this.f8533v == 1 || this.f8533v == 2) {
            return true;
        }
        return false;
    }

    protected final void mo1036b() {
        MapView mapView = this.f8080e.f8112A;
        this.f8531t = (((float) mapView.getWidth()) - this.f8527p) - ((float) this.f8080e.f8131e);
        this.f8532u = (((float) mapView.getHeight()) - this.f8527p) - ((float) this.f8080e.f8132f);
    }

    public final void mo1032a(Canvas canvas) {
        this.f8526o.setStyle(Style.FILL);
        this.f8526o.setColor(this.f8533v == 1 ? -2236963 : -1);
        this.f8526o.setAlpha(230);
        canvas.drawRect(this.f8531t - this.f8528q, this.f8532u - (this.f8528q * 2.0f), this.f8531t, this.f8532u - this.f8528q, this.f8526o);
        this.f8526o.setColor(this.f8533v == 2 ? -2236963 : -1);
        this.f8526o.setAlpha(230);
        canvas.drawRect(this.f8531t - this.f8528q, this.f8532u - this.f8528q, this.f8531t, this.f8532u, this.f8526o);
        this.f8526o.setStyle(Style.STROKE);
        this.f8526o.setStrokeWidth(this.f8529r);
        this.f8526o.setColor(-3355444);
        canvas.drawRect(this.f8531t - this.f8528q, this.f8532u - (this.f8528q * 2.0f), this.f8531t, this.f8532u - this.f8528q, this.f8526o);
        canvas.drawRect(this.f8531t - this.f8528q, this.f8532u - this.f8528q, this.f8531t, this.f8532u, this.f8526o);
        this.f8526o.setStrokeWidth(this.f8530s);
        this.f8526o.setColor(-7829368);
        canvas.drawLine(this.f8531t - (this.f8528q * 0.75f), this.f8532u - (this.f8528q * 1.5f), this.f8531t - (this.f8528q * 0.25f), this.f8532u - (this.f8528q * 1.5f), this.f8526o);
        canvas.drawLine(this.f8531t - (this.f8528q * 0.5f), this.f8532u - (this.f8528q * 1.75f), this.f8531t - (this.f8528q * 0.5f), this.f8532u - (this.f8528q * 1.25f), this.f8526o);
        canvas.drawLine(this.f8531t - (this.f8528q * 0.75f), this.f8532u - (this.f8528q * 0.5f), this.f8531t - (this.f8528q * 0.25f), this.f8532u - (this.f8528q * 0.5f), this.f8526o);
    }
}
