package com.facebook.android.maps.model;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import com.facebook.android.maps.DrawableHelper;
import com.facebook.android.maps.FacebookMap;
import com.facebook.android.maps.MapDrawable;
import com.facebook.android.maps.Projection;
import com.facebook.android.maps.internal.RectD;
import java.util.List;

/* compiled from: audio_track_id */
public final class Polyline extends MapDrawable {
    private static final Paint f8629o = null;
    public float f8630A;
    private double f8631B;
    private boolean f8632p;
    private List<LatLng> f8633q;
    private double[] f8634r;
    private double[] f8635s;
    private RectD[] f8636t;
    public final Paint f8637u = new Paint(1);
    private final RectD f8638v = new RectD();
    private final RectD f8639w = new RectD();
    private final RectD f8640x = new RectD();
    private final RectF f8641y = new RectF();
    public int f8642z;

    public Polyline(FacebookMap facebookMap, PolylineOptions polylineOptions) {
        super(facebookMap);
        this.k = polylineOptions.f8648f;
        this.f8632p = polylineOptions.f8644b;
        this.i = polylineOptions.f8646d;
        this.f8633q = polylineOptions.f8645c;
        this.f8637u.setStrokeCap(Cap.ROUND);
        this.f8637u.setStyle(Style.STROKE);
        int i = polylineOptions.f8643a;
        this.f8642z = Color.alpha(i);
        this.f8637u.setColor(-16777216 | i);
        m14231f();
        float f = polylineOptions.f8647e;
        this.f8630A = f / 2.0f;
        this.f8637u.setStrokeWidth(f);
        m14231f();
        m14605c();
    }

    protected final void mo1036b() {
        this.f8631B = this.f8081f.a(this.f8079d * 10.0f);
    }

    private void m14605c() {
        this.f8634r = DrawableHelper.m14266a(this.f8633q, false);
        if (this.f8632p) {
            this.f8635s = DrawableHelper.m14265a(this.f8633q);
            this.f8636t = DrawableHelper.m14267a(this.f8634r, this.f8635s);
            this.f8639w.a(this.f8636t[0]);
            int length = this.f8636t.length;
            for (int i = 1; i < length; i++) {
                this.f8639w.b(this.f8636t[i]);
            }
        } else {
            double[] dArr = this.f8634r;
            RectD rectD = this.f8639w;
            rectD.a = Double.POSITIVE_INFINITY;
            rectD.b = Double.NEGATIVE_INFINITY;
            rectD.c = Double.POSITIVE_INFINITY;
            rectD.d = Double.NEGATIVE_INFINITY;
            int length2 = dArr.length;
            for (int i2 = 0; i2 < length2; i2 += 2) {
                double d = dArr[i2];
                double d2 = dArr[i2 + 1];
                if (d2 < rectD.a) {
                    rectD.a = d2;
                }
                if (rectD.b < d2) {
                    rectD.b = d2;
                }
                if (d < rectD.c) {
                    rectD.c = d;
                }
                if (rectD.d < d) {
                    rectD.d = d;
                }
            }
        }
        this.m = (this.f8639w.c + this.f8639w.d) / 2.0d;
        this.n = (this.f8639w.a + this.f8639w.b) / 2.0d;
    }

    public final void mo1032a(Canvas canvas) {
        if (this.f8634r.length >= 4) {
            if (m14223a(this.f8639w, this.f8078c)) {
                Object obj;
                float f = this.f8078c[0];
                float f2 = this.f8078c[1];
                this.f8081f.a(this.f8638v);
                Object obj2 = this.f8642z != 255 ? 1 : null;
                if (this.f8634r.length != 4 || this.f8632p) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj2 != null && obj == null) {
                    this.f8637u.setAlpha(255);
                    this.f8640x.a = this.f8639w.a;
                    this.f8640x.b = this.f8639w.b;
                    this.f8640x.c = this.f8639w.c + ((double) f);
                    this.f8640x.d = this.f8639w.d + ((double) f2);
                    this.f8640x.c(this.f8638v);
                    this.f8081f.a(this.f8640x.c, this.f8640x.a, this.f8078c);
                    this.f8641y.set(this.f8078c[0], this.f8078c[1], this.f8078c[0], this.f8078c[1]);
                    this.f8081f.a(this.f8640x.c, this.f8640x.b, this.f8078c);
                    this.f8641y.union(this.f8078c[0], this.f8078c[1]);
                    this.f8081f.a(this.f8640x.d, this.f8640x.a, this.f8078c);
                    this.f8641y.union(this.f8078c[0], this.f8078c[1]);
                    this.f8081f.a(this.f8640x.d, this.f8640x.b, this.f8078c);
                    this.f8641y.union(this.f8078c[0], this.f8078c[1]);
                    this.f8641y.left -= this.f8630A;
                    this.f8641y.top -= this.f8630A;
                    this.f8641y.right += this.f8630A;
                    this.f8641y.bottom += this.f8630A;
                    canvas.saveLayerAlpha(this.f8641y, this.f8642z, 16);
                }
                this.f8637u.setAlpha(obj != null ? this.f8642z : 255);
                for (float f3 = f; f3 <= f2; f3 = 1.0f + f3) {
                    float f4;
                    if (this.f8632p) {
                        int i = 0;
                        int i2 = 0;
                        for (RectD a : this.f8636t) {
                            this.f8640x.a(a);
                            RectD rectD = this.f8640x;
                            rectD.c += (double) f3;
                            rectD = this.f8640x;
                            rectD.d += (double) f3;
                            if (this.f8640x.c(this.f8638v)) {
                                Object obj3;
                                if (this.f8634r[i2] > 1.0d || this.f8634r[i2 + 3] > 1.0d) {
                                    obj3 = 1;
                                } else {
                                    obj3 = null;
                                }
                                double d = this.f8640x.c;
                                double d2 = this.f8640x.d;
                                double a2 = DrawableHelper.m14264a(d, this.f8635s[i], this.f8635s[i + 1]);
                                Projection projection = this.f8081f;
                                if (obj3 != null) {
                                    a2 = 1.0d - a2;
                                }
                                projection.a(d, a2, this.f8078c);
                                float f5 = this.f8078c[0];
                                f4 = this.f8078c[1];
                                float f6 = f5;
                                while (d < d2) {
                                    if (this.f8631B + d > d2) {
                                        d = d2;
                                    } else {
                                        d += this.f8631B;
                                    }
                                    a2 = DrawableHelper.m14264a(d, this.f8635s[i], this.f8635s[i + 1]);
                                    projection = this.f8081f;
                                    if (obj3 != null) {
                                        a2 = 1.0d - a2;
                                    }
                                    projection.a(d, a2, this.f8078c);
                                    f5 = this.f8078c[0];
                                    float f7 = this.f8078c[1];
                                    canvas.drawLine(f6, f4, f5, f7, this.f8637u);
                                    f4 = f7;
                                    f6 = f5;
                                }
                            }
                            i += 2;
                            i2 += 4;
                        }
                    } else {
                        int length = this.f8634r.length;
                        for (int i3 = 0; i3 < length; i3 += 4) {
                            this.f8081f.a(this.f8634r[i3] + ((double) f3), this.f8634r[i3 + 1], this.f8078c);
                            float f8 = this.f8078c[0];
                            f4 = this.f8078c[1];
                            this.f8081f.a(this.f8634r[i3 + 2] + ((double) f3), this.f8634r[i3 + 3], this.f8078c);
                            canvas.drawLine(f8, f4, this.f8078c[0], this.f8078c[1], this.f8637u);
                        }
                    }
                }
                if (obj2 != null && obj == null) {
                    canvas.restore();
                }
            }
        }
    }
}
