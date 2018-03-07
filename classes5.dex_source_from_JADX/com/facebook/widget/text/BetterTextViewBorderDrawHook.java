package com.facebook.widget.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.MotionEvent;
import android.view.View;

/* compiled from: com.facebook.katana.login.WorkOnboardingFlowComponent */
public class BetterTextViewBorderDrawHook implements BetterTextViewHook {
    private final View f5850a;
    private final Paint f5851b = new Paint(1);
    private final Side f5852c;

    /* compiled from: com.facebook.katana.login.WorkOnboardingFlowComponent */
    /* synthetic */ class C05331 {
        static final /* synthetic */ int[] f5849a = new int[Side.values().length];

        static {
            try {
                f5849a[Side.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5849a[Side.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f5849a[Side.BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f5849a[Side.RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* compiled from: com.facebook.katana.login.WorkOnboardingFlowComponent */
    public enum Side {
        TOP,
        LEFT,
        BOTTOM,
        RIGHT
    }

    public BetterTextViewBorderDrawHook(View view, int i, int i2, Side side) {
        this.f5850a = view;
        this.f5852c = side;
        this.f5851b.setColor(i2);
        this.f5851b.setStrokeWidth((float) i);
    }

    public final boolean mo633a(MotionEvent motionEvent) {
        return false;
    }

    public final void mo632a(Canvas canvas) {
        int width;
        int i;
        int i2;
        int i3 = 0;
        switch (C05331.f5849a[this.f5852c.ordinal()]) {
            case 1:
                width = this.f5850a.getWidth();
                i = 0;
                i2 = 0;
                break;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                width = 0;
                i = 0;
                i2 = 0;
                i3 = this.f5850a.getHeight();
                break;
            case 3:
                i2 = this.f5850a.getHeight() - 1;
                width = this.f5850a.getWidth();
                i = i2;
                int i4 = i2;
                i2 = 0;
                i3 = i4;
                break;
            case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                i = this.f5850a.getWidth() - 1;
                width = i;
                i2 = i;
                i = 0;
                i3 = this.f5850a.getHeight();
                break;
            default:
                width = 0;
                i = 0;
                i2 = 0;
                break;
        }
        canvas.drawLine((float) i2, (float) i, (float) width, (float) i3, this.f5851b);
    }
}
