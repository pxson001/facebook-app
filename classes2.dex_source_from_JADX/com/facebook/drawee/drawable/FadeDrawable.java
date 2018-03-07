package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.proxygen.HTTPTransportCallback;
import java.util.Arrays;

/* compiled from: messaging/<p$1> */
public class FadeDrawable extends ArrayDrawable {
    @VisibleForTesting
    public int f14257a;
    @VisibleForTesting
    public int f14258b;
    @VisibleForTesting
    long f14259c;
    @VisibleForTesting
    public int[] f14260d;
    @VisibleForTesting
    public int[] f14261e;
    @VisibleForTesting
    int f14262f;
    @VisibleForTesting
    public boolean[] f14263g;
    @VisibleForTesting
    public int f14264h;
    private final Drawable[] f14265i;

    public FadeDrawable(Drawable[] drawableArr) {
        super(drawableArr);
        Preconditions.b(drawableArr.length > 0, "At least one layer required!");
        this.f14265i = drawableArr;
        this.f14260d = new int[drawableArr.length];
        this.f14261e = new int[drawableArr.length];
        this.f14262f = 255;
        this.f14263g = new boolean[drawableArr.length];
        this.f14264h = 0;
        this.f14257a = 2;
        Arrays.fill(this.f14260d, 0);
        this.f14260d[0] = 255;
        Arrays.fill(this.f14261e, 0);
        this.f14261e[0] = 255;
        Arrays.fill(this.f14263g, false);
        this.f14263g[0] = true;
    }

    public void invalidateSelf() {
        if (this.f14264h == 0) {
            super.invalidateSelf();
        }
    }

    public final void m20658b() {
        this.f14264h++;
    }

    public final void m20659c() {
        this.f14264h--;
        invalidateSelf();
    }

    public final void m20660c(int i) {
        this.f14258b = i;
        if (this.f14257a == 1) {
            this.f14257a = 0;
        }
    }

    public final void m20661d(int i) {
        this.f14257a = 0;
        this.f14263g[i] = true;
        invalidateSelf();
    }

    public final void m20662e(int i) {
        this.f14257a = 0;
        this.f14263g[i] = false;
        invalidateSelf();
    }

    public final void m20663f(int i) {
        this.f14257a = 0;
        Arrays.fill(this.f14263g, false);
        this.f14263g[i] = true;
        invalidateSelf();
    }

    public final void m20665g(int i) {
        this.f14257a = 0;
        Arrays.fill(this.f14263g, 0, i + 1, true);
        Arrays.fill(this.f14263g, i + 1, this.f14265i.length, false);
        invalidateSelf();
    }

    public final void m20664g() {
        this.f14257a = 2;
        for (int i = 0; i < this.f14265i.length; i++) {
            int i2;
            int[] iArr = this.f14261e;
            if (this.f14263g[i]) {
                i2 = 255;
            } else {
                i2 = 0;
            }
            iArr[i] = i2;
        }
        invalidateSelf();
    }

    private boolean m20656a(float f) {
        int i = 0;
        boolean z = true;
        while (i < this.f14265i.length) {
            this.f14261e[i] = (int) ((((float) ((this.f14263g[i] ? 1 : -1) * 255)) * f) + ((float) this.f14260d[i]));
            if (this.f14261e[i] < 0) {
                this.f14261e[i] = 0;
            }
            if (this.f14261e[i] > 255) {
                this.f14261e[i] = 255;
            }
            if (this.f14263g[i] && this.f14261e[i] < 255) {
                z = false;
            }
            if (!this.f14263g[i] && this.f14261e[i] > 0) {
                z = false;
            }
            i++;
        }
        return z;
    }

    public void draw(Canvas canvas) {
        int i = 2;
        int i2 = 0;
        boolean z = true;
        switch (this.f14257a) {
            case 0:
                int i3;
                System.arraycopy(this.f14261e, 0, this.f14260d, 0, this.f14265i.length);
                this.f14259c = m20657i();
                boolean a = m20656a(this.f14258b == 0 ? 1.0f : 0.0f);
                if (a) {
                    i3 = 2;
                } else {
                    i3 = 1;
                }
                this.f14257a = i3;
                z = a;
                break;
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                Preconditions.b(this.f14258b > 0);
                boolean a2 = m20656a(((float) (m20657i() - this.f14259c)) / ((float) this.f14258b));
                if (!a2) {
                    i = 1;
                }
                this.f14257a = i;
                z = a2;
                break;
        }
        while (i2 < this.f14265i.length) {
            Drawable drawable = this.f14265i[i2];
            i = (this.f14261e[i2] * this.f14262f) / 255;
            if (drawable != null && i > 0) {
                this.f14264h++;
                drawable.mutate().setAlpha(i);
                this.f14264h--;
                drawable.draw(canvas);
            }
            i2++;
        }
        if (!z) {
            invalidateSelf();
        }
    }

    public void setAlpha(int i) {
        if (this.f14262f != i) {
            this.f14262f = i;
            invalidateSelf();
        }
    }

    public int getAlpha() {
        return this.f14262f;
    }

    private static long m20657i() {
        return SystemClock.uptimeMillis();
    }
}
