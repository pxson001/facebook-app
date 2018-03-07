package com.facebook.tablet.sideshow.nux;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.FbInjector;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.inject.Inject;

/* compiled from: onPageScroll */
public class TabletNuxAnimationView extends View {
    @Inject
    public MonotonicClock f4708a;
    public int f4709b = 0;
    private float f4710c;
    public long f4711d;
    private Handler f4712e;
    private final Paint f4713f = new Paint(1);
    private final Interpolator f4714g = new AccelerateDecelerateInterpolator();
    private final Interpolator f4715h = new OvershootInterpolator(1.0f);
    private final RectF f4716i = new RectF();

    private static <T extends View> void m5899a(Class<T> cls, T t) {
        m5900a((Object) t, t.getContext());
    }

    private static void m5900a(Object obj, Context context) {
        ((TabletNuxAnimationView) obj).f4708a = (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(FbInjector.get(context));
    }

    public TabletNuxAnimationView(Context context) {
        super(context);
        m5892a();
    }

    public TabletNuxAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5892a();
    }

    public TabletNuxAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5892a();
    }

    public TabletNuxAnimationView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m5892a();
    }

    private void m5892a() {
        m5899a(TabletNuxAnimationView.class, (View) this);
        this.f4713f.setStyle(Style.FILL);
        this.f4712e = new Handler(Looper.getMainLooper());
    }

    public void onDraw(Canvas canvas) {
        int i = 1;
        if (this.f4709b == 0) {
            this.f4711d = this.f4708a.now() - 2400;
            this.f4709b = 4;
        }
        if (this.f4709b == 2 || this.f4709b == 4) {
            this.f4710c = (((float) (this.f4708a.now() - this.f4711d)) * 1.0f) / 1200.0f;
            this.f4710c = m5889a(this.f4710c);
            int i2 = this.f4709b == 4 ? 1 : 0;
            int i3 = this.f4710c == 1.0f ? 1 : 0;
            if (i2 != 0) {
                this.f4710c = 1.0f - this.f4710c;
            }
            if (i3 != 0) {
                if (i2 == 0) {
                    i = 3;
                }
                this.f4709b = i;
                if (i2 != 0) {
                    i2 = 2;
                } else {
                    i2 = 4;
                }
                HandlerDetour.b(this.f4712e, new Runnable(this) {
                    final /* synthetic */ TabletNuxAnimationView f4707b;

                    public void run() {
                        this.f4707b.invalidate();
                        this.f4707b.f4709b = i2;
                        this.f4707b.f4711d = this.f4707b.f4708a.now();
                    }
                }, 1000, 80223249);
            }
        } else if (this.f4709b == 1) {
            this.f4710c = 0.0f;
        } else if (this.f4709b == 3) {
            this.f4710c = 1.0f;
        }
        canvas.save();
        float right = (float) getRight();
        float bottom = (float) getBottom();
        this.f4713f.setColor(-11508323);
        float abs = Math.abs(bottom - right) / 2.0f;
        if (bottom > right) {
            canvas.drawRect(0.0f, 0.0f, right, abs, this.f4713f);
            canvas.drawRect(0.0f, bottom - abs, right, bottom, this.f4713f);
        } else if (right > bottom) {
            canvas.drawRect(0.0f, 0.0f, abs, bottom, this.f4713f);
            canvas.drawRect(right - abs, 0.0f, right, bottom, this.f4713f);
        }
        float min = Math.min(right, bottom) / 1500.0f;
        canvas.translate(right / 2.0f, bottom / 2.0f);
        canvas.scale(min, min);
        min = m5889a(this.f4710c / 0.8f);
        m5901b(canvas, min);
        m5894a(canvas, min);
        m5893a(canvas);
        canvas.restore();
        if (this.f4709b == 2 || this.f4709b == 4) {
            invalidate();
        }
    }

    private void m5898a(MonotonicClock monotonicClock) {
        this.f4708a = monotonicClock;
    }

    private static float m5889a(float f) {
        if (f > 1.0f) {
            return 1.0f;
        }
        if (f < 0.0f) {
            return 0.0f;
        }
        return f;
    }

    private void m5894a(Canvas canvas, float f) {
        canvas.save();
        canvas.rotate(this.f4714g.getInterpolation(this.f4714g.getInterpolation(f)) * 90.0f);
        this.f4713f.setColor(-11508323);
        canvas.drawRect(-1100.0f, -1100.0f, 1100.0f, -550.0f, this.f4713f);
        canvas.drawRect(-1100.0f, 550.0f, 1100.0f, 1100.0f, this.f4713f);
        canvas.drawRect(-1100.0f, -600.0f, -350.0f, 600.0f, this.f4713f);
        canvas.drawRect(350.0f, -600.0f, 1100.0f, 600.0f, this.f4713f);
        this.f4713f.setColor(-16777216);
        canvas.drawRect(-320.0f, -600.0f, 320.0f, -550.0f, this.f4713f);
        canvas.drawRect(-320.0f, 550.0f, 320.0f, 600.0f, this.f4713f);
        canvas.drawRect(-350.0f, -570.0f, -300.0f, 570.0f, this.f4713f);
        canvas.drawRect(300.0f, -570.0f, 350.0f, 570.0f, this.f4713f);
        m5897a(canvas, -350.0f, -600.0f, -290.0f, -540.0f, 180.0f, 90.0f, this.f4713f);
        m5897a(canvas, 290.0f, -600.0f, 350.0f, -540.0f, 270.0f, 90.0f, this.f4713f);
        m5897a(canvas, -350.0f, 540.0f, -290.0f, 600.0f, 90.0f, 90.0f, this.f4713f);
        m5897a(canvas, 290.0f, 540.0f, 350.0f, 600.0f, 0.0f, 90.0f, this.f4713f);
        canvas.restore();
    }

    private void m5893a(Canvas canvas) {
        for (int i = 0; i < 4; i++) {
            m5896a(canvas, 130.0f, (float) ((i * 130) - 250), m5889a(((this.f4710c * 2.0f) - 0.5f) - (0.15f * ((float) i))));
        }
    }

    private void m5896a(Canvas canvas, float f, float f2, float f3) {
        float interpolation = this.f4715h.getInterpolation(f3);
        this.f4713f.setColor(-1);
        this.f4713f.setARGB(Math.min(Math.round(255.0f * interpolation), 255), 255, 255, 255);
        canvas.drawRect((150.0f + f) - ((300.0f * interpolation) / 2.0f), (40.0f + f2) - ((80.0f * interpolation) / 2.0f), (300.0f * interpolation) + f, f2 + (interpolation * 80.0f), this.f4713f);
    }

    private void m5901b(Canvas canvas, float f) {
        this.f4713f.setColor(-2434342);
        canvas.drawRect(-700.0f, -700.0f, 700.0f, 700.0f, this.f4713f);
        float interpolation = this.f4714g.getInterpolation(this.f4714g.getInterpolation(f));
        m5895a(canvas, ((1.0f - interpolation) * -250.0f) + (-430.0f * interpolation), ((1.0f - interpolation) * -500.0f) + (-250.0f * interpolation));
        m5895a(canvas, ((1.0f - interpolation) * -250.0f) + (-430.0f * interpolation), (((1.0f - interpolation) * -500.0f) + (-250.0f * interpolation)) + 450.0f);
        m5895a(canvas, ((1.0f - interpolation) * -250.0f) + (-430.0f * interpolation), ((interpolation * -250.0f) + ((1.0f - interpolation) * -500.0f)) + 900.0f);
    }

    private void m5895a(Canvas canvas, float f, float f2) {
        this.f4713f.setColor(-1);
        canvas.drawRect(f, f2, f + 500.0f, f2 + 400.0f, this.f4713f);
        this.f4713f.setColor(-2434342);
        canvas.drawRect(f + 30.0f, f2 + 30.0f, f + 130.0f, f2 + 130.0f, this.f4713f);
        canvas.drawRect(f + 150.0f, f2 + 30.0f, f + 420.0f, f2 + 55.0f, this.f4713f);
        canvas.drawRect(f + 150.0f, f2 + 70.0f, f + 300.0f, f2 + 95.0f, this.f4713f);
        canvas.drawRect(f + 30.0f, f2 + 150.0f, f + 470.0f, f2 + 370.0f, this.f4713f);
    }

    private void m5897a(Canvas canvas, float f, float f2, float f3, float f4, float f5, float f6, Paint paint) {
        this.f4716i.left = f;
        this.f4716i.top = f2;
        this.f4716i.right = f3;
        this.f4716i.bottom = f4;
        canvas.drawArc(this.f4716i, f5, f6, true, paint);
    }
}
