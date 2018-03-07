package com.facebook.catalyst.shadow.flat;

import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PathEffect;
import android.graphics.RectF;
import javax.annotation.Nullable;

/* compiled from: map_region */
public abstract class AbstractDrawBorder extends AbstractDrawCommand {
    public static final Paint f5616c = new Paint(1);
    public static final RectF f5617d = new RectF();
    private int f5618e;
    public int f5619f = -16777216;
    public float f5620g;
    public float f5621h;
    @Nullable
    private Path f5622i;

    AbstractDrawBorder() {
    }

    static {
        f5616c.setStyle(Style.STROKE);
    }

    public final float m6937e() {
        return this.f5620g;
    }

    public final int m6938g() {
        return this.f5619f;
    }

    protected final void mo154h() {
        m6935c(1);
    }

    @Nullable
    public PathEffect mo156i() {
        return null;
    }

    protected final boolean m6934b(int i) {
        return (this.f5618e & i) == i;
    }

    public final void m6935c(int i) {
        this.f5618e |= i;
    }

    public final void m6936d(int i) {
        this.f5618e &= i ^ -1;
    }

    public final Path m6941j() {
        if (m6934b(1)) {
            if (this.f5622i == null) {
                this.f5622i = new Path();
            }
            Path path = this.f5622i;
            float f = this.f5620g * 0.5f;
            path.reset();
            f5617d.set(this.f5611c + f, this.f5612d + f, this.f5613e - f, this.f5614f - f);
            path.addRoundRect(f5617d, this.f5621h, this.f5621h, Direction.CW);
            m6936d(1);
        }
        return this.f5622i;
    }
}
