package android.support.v7.graphics;

import android.support.v4.graphics.ColorUtils;
import android.support.v7.graphics.Palette.Generator;
import android.support.v7.graphics.Palette.Swatch;
import java.util.List;

/* compiled from: shareCamption */
public class DefaultGenerator extends Generator {
    public List<Swatch> f3710a;
    private int f3711b;
    public Swatch f3712c;
    private Swatch f3713d;
    public Swatch f3714e;
    private Swatch f3715f;
    private Swatch f3716g;
    private Swatch f3717h;

    DefaultGenerator() {
    }

    public final void mo107a(List<Swatch> list) {
        this.f3710a = list;
        int i = 0;
        for (Swatch swatch : this.f3710a) {
            i = Math.max(i, swatch.f3729e);
        }
        this.f3711b = i;
        m3445e();
        if (this.f3712c == null && this.f3714e != null) {
            float[] b = m3444b(this.f3714e);
            b[2] = 0.5f;
            this.f3712c = new Swatch(ColorUtils.a(b), 0);
        }
        if (this.f3714e == null && this.f3712c != null) {
            b = m3444b(this.f3712c);
            b[2] = 0.26f;
            this.f3714e = new Swatch(ColorUtils.a(b), 0);
        }
    }

    public final Swatch mo106a() {
        return this.f3712c;
    }

    public final Swatch mo108b() {
        return this.f3716g;
    }

    public final Swatch mo109c() {
        return this.f3714e;
    }

    public final Swatch mo110d() {
        return this.f3715f;
    }

    private void m3445e() {
        this.f3712c = m3442a(0.5f, 0.3f, 0.7f, 1.0f, 0.35f, 1.0f);
        this.f3716g = m3442a(0.74f, 0.55f, 1.0f, 1.0f, 0.35f, 1.0f);
        this.f3714e = m3442a(0.26f, 0.0f, 0.45f, 1.0f, 0.35f, 1.0f);
        this.f3713d = m3442a(0.5f, 0.3f, 0.7f, 0.3f, 0.0f, 0.4f);
        this.f3717h = m3442a(0.74f, 0.55f, 1.0f, 0.3f, 0.0f, 0.4f);
        this.f3715f = m3442a(0.26f, 0.0f, 0.45f, 0.3f, 0.0f, 0.4f);
    }

    private Swatch m3442a(float f, float f2, float f3, float f4, float f5, float f6) {
        Swatch swatch = null;
        float f7 = 0.0f;
        for (Swatch swatch2 : this.f3710a) {
            float f8 = swatch2.m3457b()[1];
            float f9 = swatch2.m3457b()[2];
            if (f8 >= f5 && f8 <= f6 && f9 >= f2 && f9 <= f3 && !m3443a(swatch2)) {
                f8 = m3440a(f8, f4, f9, f, swatch2.m3458c(), this.f3711b);
                if (swatch != null) {
                    if (f8 > f7) {
                    }
                }
                f7 = f8;
                swatch = swatch2;
            }
            f8 = f7;
            Swatch swatch22 = swatch;
            f7 = f8;
            swatch = swatch22;
        }
        return swatch;
    }

    private boolean m3443a(Swatch swatch) {
        return this.f3712c == swatch || this.f3714e == swatch || this.f3716g == swatch || this.f3713d == swatch || this.f3715f == swatch || this.f3717h == swatch;
    }

    private static float m3440a(float f, float f2, float f3, float f4, int i, int i2) {
        return m3439a(f, f2, 3.0f, f3, f4, 6.0f, i, i2, 1.0f);
    }

    private static float m3439a(float f, float f2, float f3, float f4, float f5, float f6, int i, int i2, float f7) {
        return m3441a(m3438a(f, f2), f3, m3438a(f4, f5), f6, ((float) i) / ((float) i2), f7);
    }

    public static float[] m3444b(Swatch swatch) {
        Object obj = new float[3];
        System.arraycopy(swatch.m3457b(), 0, obj, 0, 3);
        return obj;
    }

    private static float m3438a(float f, float f2) {
        return 1.0f - Math.abs(f - f2);
    }

    private static float m3441a(float... fArr) {
        float f = 0.0f;
        float f2 = 0.0f;
        for (int i = 0; i < fArr.length; i += 2) {
            float f3 = fArr[i];
            float f4 = fArr[i + 1];
            f2 += f3 * f4;
            f += f4;
        }
        return f2 / f;
    }
}
