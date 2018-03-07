package com.facebook.video.player;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.facebook.R;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: composer_post_failure */
public class CountdownRingContainer extends FrameLayout {
    private static final int f18983c = 2131361917;
    @Inject
    public Clock f18984a;
    OverlayRingAnimationHandler f18985b = new OverlayRingAnimationHandler(this);
    private float f18986d;
    private int f18987e;
    private int f18988f;
    private Paint f18989g;
    private Paint f18990h;
    private RectF f18991i;
    @Nullable
    public CountdownRingContainerListener f18992j;
    private long f18993k;
    public long f18994l;
    private boolean f18995m;

    /* compiled from: composer_post_failure */
    public interface CountdownRingContainerListener {
        void m27668a();
    }

    /* compiled from: composer_post_failure */
    class OverlayRingAnimationHandler extends Handler {
        private WeakReference<CountdownRingContainer> f18982a;

        public OverlayRingAnimationHandler(CountdownRingContainer countdownRingContainer) {
            this.f18982a = new WeakReference(Preconditions.checkNotNull(countdownRingContainer));
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    m27669c();
                    return;
                default:
                    return;
            }
        }

        private void m27669c() {
            CountdownRingContainer countdownRingContainer = (CountdownRingContainer) this.f18982a.get();
            if (countdownRingContainer != null) {
                countdownRingContainer.invalidate();
                if (CountdownRingContainer.getElapsedMillisSinceCountdownStart(countdownRingContainer) >= countdownRingContainer.f18994l) {
                    m27671b();
                    CountdownRingContainer.m27683d(countdownRingContainer);
                    return;
                }
                m27670a();
            }
        }

        final void m27670a() {
            sendEmptyMessageDelayed(1, 16);
        }

        final void m27671b() {
            removeMessages(1);
        }
    }

    private static <T extends View> void m27677a(Class<T> cls, T t) {
        m27678a((Object) t, t.getContext());
    }

    private static void m27678a(Object obj, Context context) {
        ((CountdownRingContainer) obj).f18984a = (Clock) SystemClockMethodAutoProvider.a(FbInjector.get(context));
    }

    public CountdownRingContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m27677a(CountdownRingContainer.class, (View) this);
        setWillNotDraw(false);
        m27674a(context, attributeSet);
        m27681c();
    }

    private void m27674a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.CountdownRingContainer, 0, 0);
        try {
            this.f18986d = (float) obtainStyledAttributes.getDimensionPixelSize(0, m27672a(2.0f));
            this.f18994l = (long) obtainStyledAttributes.getInt(3, 3000);
            this.f18987e = obtainStyledAttributes.getColor(1, -1);
            this.f18988f = obtainStyledAttributes.getColor(2, getResources().getColor(f18983c));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void m27676a(Clock clock) {
        this.f18984a = clock;
    }

    private void m27681c() {
        this.f18989g = new Paint();
        this.f18989g.setColor(this.f18987e);
        this.f18989g.setStrokeWidth(this.f18986d);
        this.f18989g.setStyle(Style.STROKE);
        this.f18989g.setAntiAlias(true);
        this.f18990h = new Paint();
        this.f18990h.setColor(this.f18988f);
        this.f18990h.setStrokeWidth(this.f18986d);
        this.f18990h.setStyle(Style.STROKE);
        this.f18990h.setAntiAlias(true);
    }

    public long getCountdownDurationMillis() {
        return this.f18994l;
    }

    public void setCountdownDurationMillis(long j) {
        this.f18994l = j;
    }

    public CountdownRingContainerListener getCountdownRingContainerListener() {
        return this.f18992j;
    }

    public void setCountdownRingContainerListener(CountdownRingContainerListener countdownRingContainerListener) {
        this.f18992j = countdownRingContainerListener;
    }

    public static void m27683d(CountdownRingContainer countdownRingContainer) {
        if (countdownRingContainer.f18992j != null) {
            countdownRingContainer.f18992j.m27668a();
        }
    }

    public final void m27685a() {
        this.f18993k = this.f18984a.a();
        this.f18995m = true;
        this.f18985b.m27670a();
    }

    public final void m27686b() {
        if (this.f18995m) {
            this.f18995m = false;
            this.f18985b.m27671b();
            invalidate();
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 2021119053);
        super.onSizeChanged(i, i2, i3, i4);
        m27684e();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1702061972, a);
    }

    private void m27684e() {
        float f = this.f18986d * 0.5f;
        this.f18991i = new RectF(f, f, ((float) getWidth()) - f, ((float) getHeight()) - f);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m27675a(canvas);
        if (this.f18995m) {
            m27680b(canvas);
        }
    }

    private void m27675a(Canvas canvas) {
        canvas.drawArc(this.f18991i, 0.0f, 360.0f, false, this.f18989g);
    }

    private void m27680b(Canvas canvas) {
        Canvas canvas2 = canvas;
        canvas2.drawArc(this.f18991i, -90.0f, Math.min(360.0f, (360.0f / ((float) this.f18994l)) * ((float) getElapsedMillisSinceCountdownStart(this))), false, this.f18990h);
    }

    public static long getElapsedMillisSinceCountdownStart(CountdownRingContainer countdownRingContainer) {
        return countdownRingContainer.f18984a.a() - countdownRingContainer.f18993k;
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1793854734);
        super.onDetachedFromWindow();
        this.f18985b.m27671b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -2057180970, a);
    }

    private int m27672a(float f) {
        return (int) (((double) (getResources().getDisplayMetrics().density * f)) + 0.5d);
    }
}
