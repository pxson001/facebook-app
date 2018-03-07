package com.facebook.android.maps;

import android.content.Context;
import android.graphics.Canvas;
import com.facebook.android.maps.internal.RectD;
import com.facebook.android.maps.model.LatLng;
import java.util.Comparator;

/* compiled from: background can not be translucent */
public abstract class MapDrawable {
    protected static final Comparator<MapDrawable> f8075a = new C09101();
    private static int f8076o;
    public final int f8077b;
    protected final float[] f8078c = new float[2];
    protected final float f8079d;
    public final FacebookMap f8080e;
    public final Projection f8081f;
    public final Context f8082g;
    protected final int f8083h;
    public boolean f8084i = true;
    public int f8085j = 1;
    public float f8086k;
    protected boolean f8087l = true;
    protected double f8088m;
    protected double f8089n;
    private final RectD f8090p = new RectD();

    /* compiled from: background can not be translucent */
    final class C09101 implements Comparator<MapDrawable> {
        C09101() {
        }

        public final int compare(Object obj, Object obj2) {
            MapDrawable mapDrawable = (MapDrawable) obj;
            MapDrawable mapDrawable2 = (MapDrawable) obj2;
            int i = mapDrawable.f8085j;
            int i2 = mapDrawable2.f8085j;
            float f = mapDrawable.f8086k;
            float f2 = mapDrawable2.f8086k;
            if (i != i2) {
                return i - i2;
            }
            if (f != f2) {
                return (int) Math.signum(f - f2);
            }
            return mapDrawable.f8077b - mapDrawable2.f8077b;
        }
    }

    public abstract void mo1032a(Canvas canvas);

    protected MapDrawable(FacebookMap facebookMap) {
        int i = f8076o;
        f8076o = i + 1;
        this.f8077b = i;
        this.f8080e = facebookMap;
        this.f8081f = facebookMap.f8137k;
        this.f8082g = this.f8080e.f8112A.getContext();
        this.f8079d = this.f8082g.getResources().getDisplayMetrics().density;
        this.f8083h = facebookMap.f8113B;
    }

    protected void mo1036b() {
    }

    public final void m14231f() {
        this.f8080e.f8112A.invalidate();
    }

    protected final void m14220a(int i) {
        if (this.f8085j != i) {
            this.f8085j = i;
            mo1086o();
        }
    }

    protected final boolean m14232h() {
        return this.f8087l;
    }

    public LatLng mo1081a() {
        return new LatLng(Projection.a(this.f8089n), Projection.c(this.f8088m));
    }

    protected final boolean m14223a(RectD rectD, float[] fArr) {
        this.f8081f.a(this.f8090p);
        if (rectD.b < this.f8090p.a || rectD.a > this.f8090p.b) {
            return false;
        }
        fArr[0] = (float) ((int) Math.ceil(this.f8090p.c - rectD.d));
        fArr[1] = (float) ((int) Math.floor(this.f8090p.d - rectD.c));
        if (fArr[0] > fArr[1]) {
            return false;
        }
        return true;
    }

    public void mo1064a(boolean z) {
        this.f8084i = z;
        m14231f();
    }

    public void mo1065l() {
        this.f8080e.m14289b(this);
    }

    public void mo1078m() {
    }

    public void mo1079n() {
    }

    public boolean mo1038b(float f, float f2) {
        return false;
    }

    public boolean mo1041c(float f, float f2) {
        return false;
    }

    public boolean mo1077d(float f, float f2) {
        return false;
    }

    public boolean mo1085e(float f, float f2) {
        return false;
    }

    public int mo1031a(float f, float f2) {
        return 0;
    }

    public void mo1045e() {
    }

    public void mo1043d() {
    }

    public void mo1086o() {
        this.f8080e.m14289b(this);
        this.f8080e.m14277a(this);
    }
}
