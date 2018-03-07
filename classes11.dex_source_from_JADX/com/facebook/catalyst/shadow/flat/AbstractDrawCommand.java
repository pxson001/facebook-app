package com.facebook.catalyst.shadow.flat;

import android.graphics.Canvas;

/* compiled from: map_region_after */
public abstract class AbstractDrawCommand extends AbstractClippingDrawCommand implements Cloneable {
    public float f5611c;
    public float f5612d;
    public float f5613e;
    public float f5614f;
    public boolean f5615g;

    protected abstract void mo155c(Canvas canvas);

    AbstractDrawCommand() {
    }

    public final AbstractDrawCommand m6924a(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        if (this.f5615g) {
            boolean d = m6923d(f, f2, f3, f4);
            boolean a = m6920a(f5, f6, f7, f8);
            if (d && a) {
                return this;
            }
            try {
                AbstractDrawCommand abstractDrawCommand = (AbstractDrawCommand) clone();
                if (!d) {
                    abstractDrawCommand.m6922c(f, f2, f3, f4);
                }
                if (!a) {
                    abstractDrawCommand.m6921b(f5, f6, f7, f8);
                }
                return abstractDrawCommand;
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
        m6922c(f, f2, f3, f4);
        m6921b(f5, f6, f7, f8);
        this.f5615g = true;
        return this;
    }

    public final AbstractDrawCommand m6928k() {
        try {
            AbstractDrawCommand abstractDrawCommand = (AbstractDrawCommand) super.clone();
            abstractDrawCommand.f5615g = false;
            return abstractDrawCommand;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final boolean m6929l() {
        return this.f5615g;
    }

    public final float m6930m() {
        return this.f5611c;
    }

    public final float m6931n() {
        return this.f5612d;
    }

    public final float m6932o() {
        return this.f5613e;
    }

    public final float m6933p() {
        return this.f5614f;
    }

    public final void mo153a(FlatViewGroup flatViewGroup, Canvas canvas) {
        Object obj;
        if (this.f5611c < this.f5607c || this.f5612d < this.f5608d || this.f5613e > this.f5609e || this.f5614f > this.f5610f) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            canvas.save(2);
            m6919a(canvas);
            mo155c(canvas);
            canvas.restore();
            return;
        }
        mo155c(canvas);
    }

    protected void mo154h() {
    }

    private void m6922c(float f, float f2, float f3, float f4) {
        this.f5611c = f;
        this.f5612d = f2;
        this.f5613e = f3;
        this.f5614f = f4;
        mo154h();
    }

    private boolean m6923d(float f, float f2, float f3, float f4) {
        return this.f5611c == f && this.f5612d == f2 && this.f5613e == f3 && this.f5614f == f4;
    }
}
