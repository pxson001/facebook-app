package com.facebook.backstage.nub;

import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.google.common.base.Preconditions;

/* compiled from: requestIdentity= */
public class FloatingWindow<T extends View> {
    public final WindowManager f5410a;
    public final T f5411b;
    public boolean f5412c;
    public LayoutParams f5413d;

    public FloatingWindow(WindowManager windowManager, LayoutParams layoutParams, T t) {
        Preconditions.checkNotNull(t);
        this.f5410a = windowManager;
        this.f5413d = layoutParams;
        this.f5411b = t;
        m5638a(true);
        m5641b(false);
    }

    public final void m5639b() {
        if (!this.f5412c) {
            this.f5410a.addView(this.f5411b, this.f5413d);
            this.f5412c = true;
        }
    }

    public final void m5642c() {
        if (this.f5412c) {
            this.f5413d = this.f5413d;
            if (null != null) {
                this.f5410a.removeViewImmediate(this.f5411b);
            } else {
                this.f5410a.removeView(this.f5411b);
            }
            this.f5412c = false;
        }
    }

    public final void m5638a(boolean z) {
        m5635a(16, !z);
    }

    protected final void m5641b(boolean z) {
        m5635a(8, !z);
    }

    private void m5636a(LayoutParams layoutParams) {
        if (this.f5412c) {
            this.f5410a.updateViewLayout(this.f5411b, layoutParams);
        } else {
            this.f5413d = layoutParams;
        }
    }

    private void m5635a(int i, boolean z) {
        int i2;
        LayoutParams layoutParams = this.f5413d;
        if (z) {
            i2 = layoutParams.flags | i;
        } else {
            i2 = layoutParams.flags & (i ^ -1);
        }
        if (i2 != layoutParams.flags) {
            layoutParams.flags = i2;
            m5636a(layoutParams);
        }
    }

    public final void m5637a(int i) {
        LayoutParams layoutParams = this.f5413d;
        if (layoutParams.x != i) {
            layoutParams.x = i;
            m5636a(layoutParams);
        }
    }

    public final void m5640b(int i) {
        LayoutParams layoutParams = this.f5413d;
        if (layoutParams.width != i) {
            layoutParams.width = i;
            m5636a(layoutParams);
        }
    }

    public final void m5643c(int i) {
        LayoutParams layoutParams = this.f5413d;
        if (layoutParams.y != i) {
            layoutParams.y = i;
            m5636a(layoutParams);
        }
    }
}
