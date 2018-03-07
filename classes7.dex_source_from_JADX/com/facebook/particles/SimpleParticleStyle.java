package com.facebook.particles;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.facebook.common.util.MathUtil;
import com.facebook.particles.suppliers.Constant;
import com.facebook.particles.suppliers.FloatSupplier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: max_age_sec */
public class SimpleParticleStyle {
    private final List<Bitmap> f9232a;
    public FloatSupplier f9233b;
    public FloatSupplier f9234c;
    public boolean f9235d;
    public FloatSupplier f9236e;
    public FloatSupplier f9237f;
    public FloatSupplier f9238g;
    public FloatSupplier f9239h;
    public long f9240i;
    public FloatSupplier f9241j;

    public SimpleParticleStyle(List<Bitmap> list) {
        this.f9233b = Constant.f9242a;
        this.f9234c = Constant.f9242a;
        this.f9236e = Constant.f9242a;
        this.f9237f = Constant.f9242a;
        this.f9238g = Constant.f9242a;
        this.f9239h = Constant.f9243b;
        this.f9241j = Constant.f9242a;
        this.f9232a = new ArrayList(list);
    }

    public SimpleParticleStyle(Bitmap bitmap) {
        this(Collections.singletonList(bitmap));
    }

    public final int m11278a() {
        return ((Bitmap) this.f9232a.get(0)).getWidth();
    }

    public final int m11280b() {
        return ((Bitmap) this.f9232a.get(0)).getHeight();
    }

    public final float m11281f() {
        return this.f9236e.mo482a();
    }

    public final void m11279a(Canvas canvas, Paint paint, float f) {
        Bitmap bitmap = (Bitmap) this.f9232a.get((int) (((float) this.f9232a.size()) * MathUtil.b(f, 0.0f, 0.99f)));
        canvas.drawBitmap(bitmap, (float) ((-bitmap.getWidth()) / 2), (float) ((-bitmap.getHeight()) / 2), paint);
    }
}
