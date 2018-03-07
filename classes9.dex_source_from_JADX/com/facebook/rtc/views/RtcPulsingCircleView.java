package com.facebook.rtc.views;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: app_in_foreground */
public class RtcPulsingCircleView extends View {
    private static final Class<?> f20161a = RtcPulsingCircleView.class;
    private int f20162b;
    public float f20163c;
    public int f20164d;
    public float f20165e;
    public int f20166f;
    private ValueAnimator f20167g;
    private int f20168h;
    private int f20169i;
    public int f20170j;

    static /* synthetic */ float m19813d(RtcPulsingCircleView rtcPulsingCircleView, float f) {
        float f2 = rtcPulsingCircleView.f20165e + f;
        rtcPulsingCircleView.f20165e = f2;
        return f2;
    }

    static /* synthetic */ float m19814e(RtcPulsingCircleView rtcPulsingCircleView, float f) {
        float f2 = rtcPulsingCircleView.f20165e - f;
        rtcPulsingCircleView.f20165e = f2;
        return f2;
    }

    public RtcPulsingCircleView(Context context) {
        super(context);
        m19806a();
    }

    public RtcPulsingCircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m19806a();
    }

    public RtcPulsingCircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m19806a();
    }

    public void setCircleColor(int i) {
        this.f20170j = i;
    }

    private void m19806a() {
        this.f20170j = getResources().getColor(2131361864);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1466501083);
        if (i == 0 && i2 == 0) {
            Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 824533710, a);
            return;
        }
        this.f20162b = Math.min(getWidth(), getHeight());
        this.f20168h = getWidth() / 2;
        this.f20169i = getHeight() / 2;
        m19812c();
        m19810b();
        LogUtils.g(-604745028, a);
    }

    public void onDraw(Canvas canvas) {
        if (this.f20163c != 0.0f) {
            Paint paint = new Paint(1);
            paint.setStyle(Style.STROKE);
            paint.setStrokeWidth((float) m19804a(2));
            paint.setColor(this.f20170j);
            paint.setAlpha(this.f20164d);
            canvas.drawCircle((float) this.f20168h, (float) this.f20169i, this.f20163c, paint);
            paint.setAlpha(this.f20166f);
            canvas.drawCircle((float) this.f20168h, (float) this.f20169i, this.f20165e, paint);
        }
    }

    private static int m19803a(float f) {
        if (f < 0.5f) {
            return (int) (255.0f * f);
        }
        return (int) ((1.0f - f) * 255.0f);
    }

    private void m19810b() {
        final float f = ((float) this.f20162b) * 0.1f;
        final float f2 = ((float) this.f20162b) * 0.4f;
        this.f20167g = ValueAnimator.ofFloat(new float[]{f, f2});
        this.f20167g.setDuration(1500);
        this.f20167g.setInterpolator(new LinearInterpolator());
        this.f20167g.addUpdateListener(new AnimatorUpdateListener(this) {
            final /* synthetic */ RtcPulsingCircleView f20160c;

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f20160c.f20163c = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.f20160c.f20164d = RtcPulsingCircleView.m19803a(valueAnimator.getAnimatedFraction());
                this.f20160c.f20165e = this.f20160c.f20163c - ((f2 - f) * 0.5f);
                if (this.f20160c.f20165e <= f2 - f) {
                    RtcPulsingCircleView.m19813d(this.f20160c, f2 - f);
                    if (this.f20160c.f20165e > f2) {
                        RtcPulsingCircleView.m19814e(this.f20160c, f2 - f);
                    }
                }
                float animatedFraction = valueAnimator.getAnimatedFraction() - 0.5f;
                if (animatedFraction <= 0.0f) {
                    animatedFraction += 1.0f;
                }
                this.f20160c.f20166f = RtcPulsingCircleView.m19803a(animatedFraction);
                this.f20160c.invalidate();
            }
        });
        this.f20167g.setRepeatCount(-1);
        this.f20167g.setStartDelay(100);
        this.f20167g.start();
    }

    private void m19812c() {
        if (this.f20167g != null) {
            this.f20167g.cancel();
        }
        this.f20163c = 0.0f;
        this.f20165e = 0.0f;
    }

    private int m19804a(int i) {
        return ((int) getResources().getDisplayMetrics().density) * i;
    }
}
