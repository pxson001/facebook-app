package com.facebook.android.maps.internal;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.location.Location;
import com.facebook.android.maps.CameraUpdateFactory;
import com.facebook.android.maps.FacebookMap;
import com.facebook.android.maps.MapDrawable;
import com.facebook.android.maps.model.LatLng;

/* compiled from: autoplay_on_wifi */
public class MyLocationButtonDrawable extends MapDrawable {
    private float f8449A;
    private float f8450B;
    private float f8451C;
    private boolean f8452D;
    private final float f8453o;
    private final Paint f8454p;
    private float f8455q;
    private float f8456r;
    private float f8457s;
    private float f8458t;
    private float f8459u;
    private float f8460v;
    private float f8461w;
    private float f8462x;
    private float f8463y;
    private float f8464z;

    public MyLocationButtonDrawable(FacebookMap facebookMap) {
        super(facebookMap);
        this.f8454p = new Paint(1);
        this.f8455q = 12.0f * this.f8079d;
        this.f8456r = 37.0f * this.f8079d;
        this.f8457s = 0.5f * this.f8079d;
        this.f8458t = this.f8079d * 2.0f;
        this.f8459u = 5.0f * this.f8079d;
        this.f8460v = 8.0f * this.f8079d;
        this.f8462x = this.f8079d * 3.0f;
        this.f8453o = 48.0f * this.f8079d;
        this.j = 3;
        this.k = 3.0f;
        this.f8451C = (this.f8453o - this.f8456r) / 2.0f;
        this.l = false;
    }

    public final int mo1031a(float f, float f2) {
        if (f >= this.f8463y - this.f8456r && f <= this.f8463y && f2 >= this.f8464z && f2 <= this.f8464z + this.f8456r) {
            this.f8452D = true;
            return 2;
        } else if (f < (this.f8463y - this.f8456r) - this.f8451C || f > this.f8463y + this.f8451C || f2 < this.f8464z - this.f8451C || f2 > (this.f8464z + this.f8456r) + this.f8451C) {
            this.f8452D = false;
            return 0;
        } else {
            this.f8452D = true;
            return 1;
        }
    }

    public final void mo1078m() {
        m14231f();
    }

    public final void mo1079n() {
        this.f8452D = false;
        m14231f();
    }

    public final boolean mo1038b(float f, float f2) {
        Object obj;
        FacebookMap facebookMap = this.f8080e;
        if (facebookMap.f8145s == null || !facebookMap.f8145s.a()) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            Location e = this.f8080e.m14298e();
            if (e != null) {
                this.f8080e.m14281a(CameraUpdateFactory.m14203a(new LatLng(e.getLatitude(), e.getLongitude()), 15.0f));
            }
        }
        return true;
    }

    public final boolean mo1077d(float f, float f2) {
        if (!this.f8452D) {
            return false;
        }
        if (f >= this.f8463y - this.f8456r && f <= this.f8463y && f2 >= this.f8464z && f2 <= this.f8464z + this.f8456r) {
            return false;
        }
        this.f8452D = false;
        m14231f();
        return true;
    }

    public final void mo1032a(Canvas canvas) {
        this.f8463y = (((float) this.f8080e.f8112A.getWidth()) - this.f8455q) - ((float) this.f8080e.f8131e);
        this.f8464z = this.f8455q + ((float) this.f8080e.f8130d);
        this.f8449A = this.f8463y - (this.f8456r / 2.0f);
        this.f8450B = this.f8464z + (this.f8456r / 2.0f);
        this.f8461w = this.f8460v + this.f8462x;
        this.f8454p.setStyle(Style.FILL);
        this.f8454p.setColor(this.f8452D ? -2236963 : -1);
        this.f8454p.setAlpha(230);
        canvas.drawRect(this.f8463y - this.f8456r, this.f8464z, this.f8463y, this.f8456r + this.f8464z, this.f8454p);
        this.f8454p.setColor(-7829368);
        canvas.drawCircle(this.f8449A, this.f8450B, this.f8459u, this.f8454p);
        this.f8454p.setStyle(Style.STROKE);
        this.f8454p.setStrokeWidth(this.f8458t);
        canvas.drawCircle(this.f8449A, this.f8450B, this.f8460v, this.f8454p);
        canvas.drawLine(this.f8449A, this.f8450B - this.f8460v, this.f8449A, this.f8450B - this.f8461w, this.f8454p);
        canvas.drawLine(this.f8449A, this.f8460v + this.f8450B, this.f8449A, this.f8461w + this.f8450B, this.f8454p);
        canvas.drawLine(this.f8449A - this.f8460v, this.f8450B, this.f8449A - this.f8461w, this.f8450B, this.f8454p);
        canvas.drawLine(this.f8460v + this.f8449A, this.f8450B, this.f8461w + this.f8449A, this.f8450B, this.f8454p);
        this.f8454p.setStrokeWidth(this.f8457s);
        this.f8454p.setColor(-3355444);
        canvas.drawRect(this.f8463y - this.f8456r, this.f8464z, this.f8463y, this.f8456r + this.f8464z, this.f8454p);
    }
}
