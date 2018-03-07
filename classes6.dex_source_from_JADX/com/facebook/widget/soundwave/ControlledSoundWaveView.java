package com.facebook.widget.soundwave;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.facebook.R;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.annotations.VisibleForTesting;
import java.util.Arrays;
import java.util.Random;

/* compiled from: com.google.android.gms.maps.internal.IInfoWindowAdapter */
public class ControlledSoundWaveView extends View implements AnimatorUpdateListener {
    public int f19853a;
    private int f19854b;
    private int f19855c;
    private int f19856d;
    private SoundWaveController f19857e;
    private float[] f19858f;
    private float[] f19859g;
    private float f19860h = 1.0f;
    public Handler f19861i;
    public Runnable f19862j;
    private Paint f19863k;
    private ValueAnimator f19864l;
    public Random f19865m;

    /* compiled from: com.google.android.gms.maps.internal.IInfoWindowAdapter */
    class C14921 implements Runnable {
        final /* synthetic */ ControlledSoundWaveView f19851a;

        C14921(ControlledSoundWaveView controlledSoundWaveView) {
            this.f19851a = controlledSoundWaveView;
        }

        public void run() {
            this.f19851a.f19853a;
            HandlerDetour.b(this.f19851a.f19861i, this.f19851a.f19862j, (long) this.f19851a.f19853a, 1339342858);
        }
    }

    /* compiled from: com.google.android.gms.maps.internal.IInfoWindowAdapter */
    public interface SoundWaveController {
        double mo1500a();

        int mo1501b();
    }

    /* compiled from: com.google.android.gms.maps.internal.IInfoWindowAdapter */
    class C14932 implements SoundWaveController {
        final /* synthetic */ ControlledSoundWaveView f19852a;

        C14932(ControlledSoundWaveView controlledSoundWaveView) {
            this.f19852a = controlledSoundWaveView;
        }

        public final double mo1500a() {
            return (double) this.f19852a.f19865m.nextFloat();
        }

        public final int mo1501b() {
            return 200;
        }
    }

    public ControlledSoundWaveView(Context context) {
        super(context);
        m28573a(context, null);
    }

    public ControlledSoundWaveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m28573a(context, attributeSet);
    }

    public ControlledSoundWaveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m28573a(context, attributeSet);
    }

    private void m28573a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ValueBasedSoundWaveView);
        if (obtainStyledAttributes != null) {
            this.f19856d = obtainStyledAttributes.getColor(1, getResources().getColor(2131361864));
            this.f19855c = obtainStyledAttributes.getDimensionPixelSize(0, getResources().getDimensionPixelSize(2131428276));
            this.f19854b = obtainStyledAttributes.getInt(2, 5);
            obtainStyledAttributes.recycle();
        }
        this.f19865m = new Random();
        this.f19861i = new Handler();
        this.f19858f = new float[this.f19854b];
        this.f19859g = new float[this.f19854b];
        this.f19863k = new Paint();
        this.f19863k.setStrokeWidth((float) this.f19855c);
        this.f19863k.setColor(this.f19856d);
        this.f19863k.setAntiAlias(true);
        this.f19864l = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f19864l.addUpdateListener(this);
        this.f19864l.setInterpolator(new DecelerateInterpolator());
        this.f19862j = new C14921(this);
    }

    public static void m28578c(ControlledSoundWaveView controlledSoundWaveView) {
        controlledSoundWaveView.m28580d();
        float a = (float) controlledSoundWaveView.f19857e.mo1500a();
        float[] fArr = controlledSoundWaveView.f19858f;
        if (Float.isNaN(a)) {
            a = controlledSoundWaveView.f19865m.nextFloat();
        }
        fArr[0] = a;
        controlledSoundWaveView.f19860h = 0.0f;
        controlledSoundWaveView.f19864l.cancel();
        controlledSoundWaveView.f19864l.start();
    }

    private void m28580d() {
        for (int i = 0; i < this.f19854b; i++) {
            this.f19859g[i] = ((this.f19858f[i] - this.f19859g[i]) * this.f19860h) + this.f19859g[i];
            if (i != 0) {
                this.f19858f[i] = this.f19859g[i - 1];
            }
        }
    }

    public final void m28582a() {
        m28583a(new C14932(this));
    }

    public final void m28583a(SoundWaveController soundWaveController) {
        this.f19857e = soundWaveController;
        this.f19853a = this.f19857e.mo1501b();
        this.f19864l.setDuration((long) this.f19853a);
        HandlerDetour.b(this.f19861i, this.f19862j, (long) this.f19853a, -764496856);
    }

    public final void m28585b() {
        HandlerDetour.a(this.f19861i, this.f19862j);
    }

    public final void m28584a(float... fArr) {
        if (m28576b(fArr)) {
            HandlerDetour.a(this.f19861i, this.f19862j);
            m28580d();
            for (int i = 0; i < this.f19854b; i++) {
                this.f19858f[i] = fArr[i];
            }
            this.f19860h = 0.0f;
            this.f19864l.cancel();
            this.f19864l.start();
            return;
        }
        throw new IllegalArgumentException("End values are invalid: " + Arrays.toString(fArr));
    }

    private boolean m28576b(float[] fArr) {
        if (fArr.length < this.f19854b) {
            return false;
        }
        for (float f : fArr) {
            if (((double) f) < 0.0d || ((double) f) > 1.0d) {
                return false;
            }
        }
        return true;
    }

    public void onDraw(Canvas canvas) {
        float paddingLeft = (float) getPaddingLeft();
        float paddingTop = (float) getPaddingTop();
        float height = ((float) getHeight()) - (((float) getPaddingBottom()) + paddingTop);
        float width = ((((float) getWidth()) - (((float) getPaddingRight()) + paddingLeft)) - ((float) (this.f19855c * (this.f19854b - 1)))) / ((float) this.f19854b);
        if (width < 0.0f) {
            canvas.drawColor(0, Mode.CLEAR);
            return;
        }
        this.f19863k.setStrokeWidth(width);
        for (int i = 0; i != this.f19854b; i++) {
            float f = (((((float) this.f19855c) + width) * ((float) i)) + (width / 2.0f)) + paddingLeft;
            Canvas canvas2 = canvas;
            float f2 = f;
            canvas2.drawLine(f, paddingTop + height, f2, paddingTop + ((1.0f - (((this.f19858f[i] - this.f19859g[i]) * this.f19860h) + this.f19859g[i])) * height), this.f19863k);
        }
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f19860h = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    @VisibleForTesting
    public float[] getCurrentValues() {
        return this.f19858f;
    }
}
