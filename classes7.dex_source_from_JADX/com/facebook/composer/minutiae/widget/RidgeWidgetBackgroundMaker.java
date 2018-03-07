package com.facebook.composer.minutiae.widget;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.lang.reflect.Array;
import javax.inject.Inject;

/* compiled from: task_overlay_shown */
public class RidgeWidgetBackgroundMaker {
    private final int f1902a;
    private final int f1903b;
    public final int f1904c;
    public final int f1905d;
    public final int f1906e;
    public final Paint f1907f;
    public final Paint f1908g;
    public boolean[][] f1909h;
    public int f1910i;
    public int f1911j = 1;
    public Canvas f1912k;
    public Bitmap f1913l;
    private int f1914m;

    @Inject
    public RidgeWidgetBackgroundMaker(Resources resources) {
        this.f1902a = resources.getDimensionPixelSize(2131429694);
        this.f1903b = resources.getDimensionPixelSize(2131429695) - resources.getDimensionPixelSize(2131429697);
        this.f1904c = resources.getDimensionPixelSize(2131429698);
        this.f1905d = resources.getDimensionPixelSize(2131429699);
        this.f1906e = resources.getDimensionPixelSize(2131429700);
        int i = (this.f1903b - (this.f1906e * 2)) - this.f1904c;
        this.f1911j = (i / (this.f1904c + this.f1905d)) + this.f1911j;
        this.f1910i = 1;
        i = (this.f1902a - (this.f1906e * 2)) - this.f1904c;
        this.f1910i = (i / (this.f1904c + this.f1905d)) + this.f1910i;
        this.f1909h = (boolean[][]) Array.newInstance(Boolean.TYPE, new int[]{this.f1910i, this.f1911j});
        this.f1907f = new Paint();
        this.f1907f.setColor(resources.getColor(2131362951));
        this.f1907f.setAntiAlias(true);
        this.f1908g = new Paint();
        this.f1908g.setColor(resources.getColor(2131362952));
        this.f1908g.setAntiAlias(true);
        this.f1913l = Bitmap.createBitmap(this.f1903b, this.f1902a, Config.ARGB_8888);
    }

    public final RidgeWidgetBackgroundMaker m1863a() {
        this.f1912k = new Canvas(this.f1913l);
        this.f1909h = (boolean[][]) Array.newInstance(Boolean.TYPE, new int[]{this.f1910i, this.f1911j});
        this.f1912k.drawColor(-1);
        this.f1914m = 0;
        this.f1912k.drawColor(-1);
        for (int i = 0; i < this.f1910i; i++) {
            for (int i2 = 0; i2 < this.f1911j; i2++) {
                this.f1912k.drawCircle((float) ((this.f1906e + ((this.f1905d + this.f1904c) * i2)) + (this.f1904c / 2)), (float) ((this.f1906e + ((this.f1905d + this.f1904c) * i)) + (this.f1904c / 2)), (float) (this.f1904c / 2), this.f1909h[i][i2] ? this.f1908g : this.f1907f);
            }
        }
        return this;
    }

    public final void m1864a(double d) {
        if (this.f1914m < this.f1911j) {
            int i = (int) (((double) (this.f1910i - 1)) * d);
            for (int i2 = 0; i2 <= i; i2++) {
                int i3 = (this.f1910i - i2) - 1;
                int i4 = this.f1914m;
                this.f1909h[i3][i4] = true;
                i3 = ((i3 * (this.f1905d + this.f1904c)) + this.f1906e) + (this.f1904c / 2);
                this.f1912k.drawCircle((float) (((i4 * (this.f1905d + this.f1904c)) + this.f1906e) + (this.f1904c / 2)), (float) i3, (float) (this.f1904c / 2), this.f1908g);
            }
            this.f1914m++;
        }
    }
}
