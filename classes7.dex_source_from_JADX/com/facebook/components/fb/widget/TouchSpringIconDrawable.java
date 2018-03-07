package com.facebook.components.fb.widget;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.components.Touchable;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringListener;
import javax.annotation.Nullable;

/* compiled from: creativeEditingDataKey */
public class TouchSpringIconDrawable extends ForwardingDrawable implements Touchable {
    private static final Rect f16665a = new Rect();
    public final SpringListener f16666c = new IconSpringListener(this);
    public Spring f16667d;

    /* compiled from: creativeEditingDataKey */
    class IconSpringListener extends SimpleSpringListener {
        private final TouchSpringIconDrawable f16664a;

        public IconSpringListener(TouchSpringIconDrawable touchSpringIconDrawable) {
            this.f16664a = touchSpringIconDrawable;
        }

        public final void m20702a(Spring spring) {
            float d = (float) spring.d();
            if (d >= 1.3f) {
                spring.b(1.0d);
            }
            if (Math.abs(spring.i - ((double) d)) > ((double) (1.0f / ((float) Math.max(this.f16664a.getIntrinsicWidth(), this.f16664a.getIntrinsicHeight()))))) {
                this.f16664a.setLevel((int) (d * 5000.0f));
            } else {
                this.f16664a.setLevel((int) (5000.0d * spring.i));
            }
        }
    }

    TouchSpringIconDrawable() {
        super(null);
    }

    public final boolean m20706a(MotionEvent motionEvent, View view) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.f16667d.b(0.800000011920929d);
                break;
            case 1:
                this.f16667d.b(1.399999976158142d);
                break;
            case 3:
                this.f16667d.b(1.0d);
                break;
        }
        return false;
    }

    public final boolean m20705a(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 3 || actionMasked == 1 || actionMasked == 0) {
            return true;
        }
        return false;
    }

    protected boolean onLevelChange(int i) {
        getCurrent().setLevel(i);
        m20703a(i, getBounds());
        invalidateSelf();
        return true;
    }

    protected void onBoundsChange(Rect rect) {
        m20703a(getLevel(), rect);
    }

    private void m20703a(int i, Rect rect) {
        int width = rect.width();
        width -= ((10000 - i) * width) / 10000;
        int height = rect.height();
        height -= ((10000 - i) * height) / 10000;
        if (width > 0 && height > 0) {
            Gravity.apply(0, width, height, rect, f16665a);
            getCurrent().setBounds(f16665a.left, f16665a.top, f16665a.right, f16665a.bottom);
        }
    }

    public int getIntrinsicWidth() {
        return getCurrent().getIntrinsicWidth() * 2;
    }

    public int getIntrinsicHeight() {
        return getCurrent().getIntrinsicHeight() * 2;
    }

    public boolean isStateful() {
        return true;
    }

    public void draw(Canvas canvas) {
        Drawable current = getCurrent();
        if (current.getLevel() != 0) {
            current.draw(canvas);
        }
    }

    public final void m20704a(@Nullable Drawable drawable, @Nullable Spring spring) {
        if (this.f16667d != null) {
            this.f16667d.m();
        }
        this.f16667d = spring;
        if (this.f16667d != null) {
            this.f16667d.m();
            this.f16667d.a(this.f16666c);
        }
        b(drawable);
        if (drawable != null) {
            setLevel(5000);
            m20703a(getLevel(), getBounds());
        }
    }
}
