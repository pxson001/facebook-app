package com.facebook.rtc.views;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.facebook.R;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: app_info */
public class RtcLevelTileView extends View {
    private int f20149a;
    private int f20150b;
    public int f20151c;
    private ValueAnimator f20152d;
    private int f20153e;
    private int f20154f;
    private int f20155g;

    /* compiled from: app_info */
    class C23701 implements AnimatorUpdateListener {
        final /* synthetic */ RtcLevelTileView f20148a;

        C23701(RtcLevelTileView rtcLevelTileView) {
            this.f20148a = rtcLevelTileView;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f20148a.f20151c = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            this.f20148a.invalidate();
        }
    }

    public RtcLevelTileView(Context context) {
        super(context);
        m19798a(context, null, 0);
    }

    public RtcLevelTileView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m19798a(context, attributeSet, 0);
    }

    public RtcLevelTileView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m19798a(context, attributeSet, i);
    }

    private void m19798a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RtcLevelTileView, i, 0);
        this.f20149a = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f20151c = this.f20149a;
        obtainStyledAttributes.recycle();
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1229412739);
        if (i == 0 && i2 == 0) {
            Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -230367244, a);
            return;
        }
        this.f20150b = Math.min(getWidth(), getHeight());
        if (this.f20150b < this.f20149a) {
            AssertionError assertionError = new AssertionError("Overall size must be equal or larger than tile size");
            LogUtils.g(1580194532, a);
            throw assertionError;
        }
        this.f20154f = getWidth() / 2;
        this.f20155g = getHeight() / 2;
        LogUtils.g(1332530775, a);
    }

    public void onDraw(Canvas canvas) {
        if (this.f20151c > this.f20149a) {
            Paint paint = new Paint(1);
            paint.setStyle(Style.STROKE);
            paint.setStrokeWidth((float) (this.f20151c - this.f20149a));
            paint.setColor(getResources().getColor(2131362523));
            paint.setAlpha(127);
            canvas.drawCircle((float) this.f20154f, (float) this.f20155g, (float) (((double) this.f20149a) / 2.0d), paint);
        }
    }

    public final void m19799a(int i) {
        if (this.f20153e != i && this.f20150b != 0) {
            if (((double) i) > 10.0d) {
                i = 10;
            }
            int i2 = ((int) (((double) (this.f20150b - this.f20149a)) * (((double) i) / 10.0d))) + this.f20149a;
            this.f20152d = ValueAnimator.ofInt(new int[]{this.f20151c, i2});
            this.f20152d.setDuration(100);
            this.f20152d.setInterpolator(new AccelerateDecelerateInterpolator());
            this.f20152d.addUpdateListener(new C23701(this));
            this.f20152d.start();
            this.f20153e = i;
        }
    }
}
