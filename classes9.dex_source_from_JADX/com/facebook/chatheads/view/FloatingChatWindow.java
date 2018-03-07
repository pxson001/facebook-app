package com.facebook.chatheads.view;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.facebook.proguard.annotations.KeepGettersAndSetters;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.base.Preconditions;

@KeepGettersAndSetters
/* compiled from: readPrimitiveField() cannot handle enums. */
public class FloatingChatWindow<T extends View> {
    public final WindowManager f5793a;
    public LayoutParams f5794b;
    public T f5795c;
    public boolean f5796d;
    public Handler f5797e = new Handler(Looper.getMainLooper());
    private OnTouchListener f5798f;
    private int f5799g;
    private boolean f5800h = true;

    /* compiled from: readPrimitiveField() cannot handle enums. */
    class C06131 implements Runnable {
        final /* synthetic */ FloatingChatWindow f5831a;

        C06131(FloatingChatWindow floatingChatWindow) {
            this.f5831a = floatingChatWindow;
        }

        public void run() {
            this.f5831a.setLayoutParams(this.f5831a.getLayoutParams());
        }
    }

    public FloatingChatWindow(WindowManager windowManager, LayoutParams layoutParams) {
        this.f5793a = windowManager;
        this.f5794b = layoutParams;
        setTouchable(true);
        setFocusable(false);
    }

    public final void m6012a(T t) {
        Preconditions.checkNotNull(t);
        Preconditions.checkState(this.f5795c == null);
        this.f5795c = t;
    }

    public void mo229a() {
        if (!this.f5796d) {
            this.f5793a.addView(this.f5795c, this.f5794b);
            this.f5796d = true;
            HandlerDetour.a(this.f5797e, new C06131(this), -234984040);
        }
    }

    public void mo230b() {
        if (this.f5796d) {
            this.f5794b = getLayoutParams();
            if (null != null) {
                this.f5793a.removeViewImmediate(this.f5795c);
            } else {
                this.f5793a.removeView(this.f5795c);
            }
            this.f5796d = false;
        }
    }

    public int getY() {
        return getLayoutParams().y;
    }

    public void setY(int i) {
        this.f5797e.removeCallbacksAndMessages(null);
        LayoutParams layoutParams = getLayoutParams();
        if (layoutParams.y != i) {
            layoutParams.y = i;
            setLayoutParams(layoutParams);
        }
    }

    public int getWidth() {
        return getLayoutParams().width;
    }

    public void setWidth(int i) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams.width != i) {
            layoutParams.width = i;
            setLayoutParams(layoutParams);
        }
    }

    public int getHeight() {
        return getLayoutParams().height;
    }

    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams.height != i) {
            layoutParams.height = i;
            setLayoutParams(layoutParams);
        }
    }

    public void setTouchable(boolean z) {
        m6010a(16, !z);
    }

    public void setFocusable(boolean z) {
        m6010a(8, !z);
    }

    protected void setIsIMFocusable(boolean z) {
        m6010a(131072, z);
    }

    public void setAlpha(float f) {
        LayoutParams layoutParams = getLayoutParams();
        if (layoutParams.alpha != f) {
            layoutParams.alpha = f;
            setLayoutParams(layoutParams);
        }
    }

    public float getAlpha() {
        return getLayoutParams().alpha;
    }

    public LayoutParams getLayoutParams() {
        if (this.f5796d && this.f5799g == 0) {
            return (LayoutParams) this.f5795c.getLayoutParams();
        }
        return this.f5794b;
    }

    public void setLayoutParams(LayoutParams layoutParams) {
        if (this.f5796d && this.f5799g == 0) {
            this.f5793a.updateViewLayout(this.f5795c, layoutParams);
            this.f5800h = false;
            return;
        }
        this.f5794b = layoutParams;
        this.f5800h = true;
    }

    private void m6010a(int i, boolean z) {
        int i2;
        LayoutParams layoutParams = getLayoutParams();
        if (z) {
            i2 = layoutParams.flags | i;
        } else {
            i2 = layoutParams.flags & (i ^ -1);
        }
        if (i2 != layoutParams.flags) {
            layoutParams.flags = i2;
            setLayoutParams(layoutParams);
        }
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        this.f5798f = onTouchListener;
        this.f5795c.setOnTouchListener(this.f5798f);
    }
}
