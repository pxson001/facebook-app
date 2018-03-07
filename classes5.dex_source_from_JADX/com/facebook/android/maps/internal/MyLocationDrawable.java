package com.facebook.android.maps.internal;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.location.Location;
import com.facebook.android.maps.FacebookMap;
import com.facebook.android.maps.MapDrawable;
import com.facebook.android.maps.Projection;
import com.facebook.android.maps.internal.ValueAnimator.AnimatorUpdateListener;

/* compiled from: autoplay_on_cell */
public class MyLocationDrawable extends MapDrawable implements AnimatorUpdateListener {
    private final float f8465A;
    private final float f8466B;
    private final float f8467C;
    private final Paint f8468o;
    private final Path f8469p;
    private final RectD f8470q;
    public final ValueAnimator f8471r;
    private float f8472s;
    private float f8473t;
    private final float f8474u;
    private float f8475v;
    private boolean f8476w;
    private final float f8477x;
    private final float f8478y;
    private final float f8479z;

    public MyLocationDrawable(FacebookMap facebookMap) {
        super(facebookMap);
        this.f8468o = new Paint(1);
        this.f8469p = new Path();
        this.f8470q = new RectD();
        this.j = 3;
        this.k = 0.0f;
        this.f8474u = 8.0f * this.f8079d;
        this.f8478y = 11.0f * this.f8079d;
        this.f8477x = this.f8478y + 1.5f;
        this.f8479z = 12.0f * this.f8079d;
        this.f8465A = 10.0f * this.f8079d;
        this.f8466B = 24.0f * this.f8079d;
        this.f8467C = this.f8466B * 2.0f;
        this.f8471r = ValueAnimator.m14529a(0.0f, 1.0f);
        this.f8471r.f8523x = -1;
        this.f8471r.m14542a((AnimatorUpdateListener) this);
        this.f8471r.m14538a(2100);
    }

    public final void mo1032a(Canvas canvas) {
        Location e = this.f8080e.m14298e();
        if (e != null) {
            float max = Math.max(this.f8466B, Math.min(this.f8467C, e.getAccuracy()));
            this.f8468o.setColor(-12888163);
            this.f8468o.setAlpha((int) ((1.0f - this.f8472s) * 255.0f));
            this.f8081f.a(this.f8470q);
            double d = (double) Projection.d(e.getLongitude());
            this.f8081f.a(d + ((double) ((int) Math.ceil(this.f8470q.c - d))), (double) Projection.b(e.getLatitude()), this.f8078c);
            float f = this.f8078c[0];
            float f2 = this.f8078c[1];
            canvas.drawCircle(f, f2, this.f8472s * max, this.f8468o);
            this.f8468o.setColor(-3355444);
            canvas.drawCircle(f, f2, this.f8477x, this.f8468o);
            this.f8468o.setColor(-1);
            canvas.drawCircle(f, f2, this.f8478y, this.f8468o);
            this.f8468o.setColor(-12888163);
            this.f8468o.setAlpha((int) (this.f8475v * 255.0f));
            canvas.drawCircle(f, f2, this.f8475v * this.f8474u, this.f8468o);
            if (e.hasBearing()) {
                canvas.save(1);
                canvas.rotate(e.getBearing() + this.f8081f.b(), f, f2);
                float f3 = f - (this.f8479z / 2.0f);
                f = f2 - this.f8477x;
                this.f8469p.reset();
                this.f8469p.moveTo(f3, f);
                this.f8469p.lineTo((this.f8479z / 2.0f) + f3, f - this.f8465A);
                this.f8469p.lineTo(this.f8479z + f3, f);
                this.f8469p.lineTo((0.5f * this.f8479z) + f3, f - (0.25f * this.f8465A));
                this.f8469p.lineTo(f3, f);
                this.f8469p.close();
                canvas.drawPath(this.f8469p, this.f8468o);
                canvas.restore();
            }
        }
    }

    public final void m14511p() {
        this.f8471r.m14544d();
        m14231f();
    }

    public final void mo1033a(ValueAnimator valueAnimator) {
        this.f8472s = valueAnimator.f8503C;
        if (this.f8472s < this.f8473t) {
            this.f8476w = !this.f8476w;
        }
        if (this.f8476w) {
            this.f8475v = 1.0f - ((1.0f - this.f8472s) * 0.25f);
        } else {
            this.f8475v = 1.0f - (this.f8472s * 0.25f);
        }
        this.f8473t = this.f8472s;
        m14231f();
    }
}
