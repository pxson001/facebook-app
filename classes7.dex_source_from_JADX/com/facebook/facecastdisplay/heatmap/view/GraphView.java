package com.facebook.facecastdisplay.heatmap.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import com.facebook.common.references.CloseableReference;
import com.facebook.facecastdisplay.heatmap.model.DataPoint;
import com.facebook.facecastdisplay.heatmap.model.DataSet;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.module.PlatformBitmapFactoryMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.inject.Inject;

/* compiled from: at least 10 */
public class GraphView extends View {
    @Nullable
    public DataSet f19062a;
    @Inject
    public PlatformBitmapFactory f19063b;
    private final Paint f19064c;
    private final Paint f19065d;
    private final Path f19066e;
    @Nullable
    private Canvas f19067f;
    private final PorterDuffXfermode f19068g;
    private final RectF f19069h;
    private final Interpolator f19070i;
    public final ValueAnimator f19071j;
    private final AnimatorListenerAdapter f19072k;
    private final Runnable f19073l;
    private RectF f19074m;
    public float f19075n;
    public float f19076o;
    private float f19077p;
    public boolean f19078q;
    private boolean f19079r;
    @Nullable
    private CloseableReference<Bitmap> f19080s;

    /* compiled from: at least 10 */
    class C16611 implements AnimatorUpdateListener {
        final /* synthetic */ GraphView f19087a;

        C16611(GraphView graphView) {
            this.f19087a = graphView;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f19087a.invalidate();
        }
    }

    /* compiled from: at least 10 */
    class C16622 extends AnimatorListenerAdapter {
        final /* synthetic */ GraphView f19088a;

        C16622(GraphView graphView) {
            this.f19088a = graphView;
        }

        public void onAnimationEnd(Animator animator) {
            this.f19088a.f19078q = true;
        }
    }

    /* compiled from: at least 10 */
    class C16633 implements Runnable {
        final /* synthetic */ GraphView f19089a;

        C16633(GraphView graphView) {
            this.f19089a = graphView;
        }

        public void run() {
            this.f19089a.m22638a(true);
        }
    }

    public static void m22635a(Object obj, Context context) {
        ((GraphView) obj).f19063b = PlatformBitmapFactoryMethodAutoProvider.a(FbInjector.get(context));
    }

    public GraphView(Context context) {
        this(context, null);
    }

    public GraphView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GraphView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19070i = PathInterpolatorCompat.a(0.78f, 0.01f, 0.29f, 1.0f);
        this.f19078q = true;
        Class cls = GraphView.class;
        m22635a(this, getContext());
        this.f19066e = new Path();
        this.f19069h = new RectF();
        this.f19068g = new PorterDuffXfermode(Mode.SRC_IN);
        this.f19064c = new Paint(1);
        this.f19065d = new Paint();
        this.f19071j = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f19071j.setDuration(500);
        this.f19071j.setInterpolator(this.f19070i);
        this.f19071j.addUpdateListener(new C16611(this));
        this.f19072k = new C16622(this);
        this.f19073l = new C16633(this);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f19062a != null && !this.f19078q) {
            if (this.f19079r) {
                m22636b(canvas);
                this.f19079r = false;
                return;
            }
            if (!(this.f19062a == null || this.f19062a.m22648b())) {
                float f = this.f19062a.f19086b;
                float a = (float) (this.f19062a.m22646a() - 1);
                for (int i = 0; i < this.f19062a.m22646a(); i++) {
                    DataPoint a2 = this.f19062a.m22647a(i);
                    float animatedFraction = this.f19076o - ((this.f19071j.isStarted() ? this.f19071j.getAnimatedFraction() : 1.0f) * ((this.f19062a.m22647a(i).f19082a / f) * this.f19076o));
                    a2.f19083b = (((float) i) / a) * this.f19075n;
                    a2.f19084c = animatedFraction;
                }
            }
            m22634a(canvas);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1362611035);
        super.onSizeChanged(i, i2, i3, i4);
        if (!(i3 == i && i4 == i2)) {
            mo1450a();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -2126487551, a);
    }

    private void mo1450a() {
        this.f19074m = new RectF((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()));
        this.f19075n = this.f19074m.right - this.f19074m.left;
        this.f19076o = this.f19074m.bottom - this.f19074m.top;
        if (this.f19080s == null) {
            this.f19080s = this.f19063b.a((int) this.f19075n, (int) this.f19076o, Config.ARGB_8888);
            ((Bitmap) this.f19080s.a()).setHasAlpha(true);
            this.f19067f = new Canvas((Bitmap) this.f19080s.a());
        }
    }

    private void m22634a(Canvas canvas) {
        if (this.f19062a != null) {
            this.f19066e.reset();
            this.f19066e.moveTo(0.0f, this.f19076o);
            m22637d();
            this.f19066e.lineTo(this.f19075n, this.f19076o);
            this.f19066e.lineTo(0.0f, this.f19076o);
            this.f19066e.close();
            m22636b(canvas);
        }
    }

    private void m22636b(Canvas canvas) {
        if (this.f19067f == null) {
            mo1450a();
        }
        this.f19067f.drawColor(0, Mode.CLEAR);
        this.f19067f.drawPath(this.f19066e, this.f19064c);
        this.f19065d.setXfermode(this.f19068g);
        this.f19069h.set(this.f19077p * this.f19075n, 0.0f, this.f19075n, this.f19076o);
        this.f19065d.setColor(getResources().getColor(2131362615));
        this.f19067f.drawRect(this.f19069h, this.f19065d);
        this.f19069h.set(0.0f, 0.0f, this.f19077p * this.f19075n, this.f19076o);
        this.f19065d.setColor(getResources().getColor(2131362614));
        this.f19067f.drawRect(this.f19069h, this.f19065d);
        if (this.f19080s != null) {
            canvas.drawBitmap((Bitmap) this.f19080s.a(), this.f19074m.left, this.f19074m.top, null);
        }
    }

    private void m22637d() {
        if (this.f19062a != null && !this.f19062a.m22648b()) {
            this.f19066e.lineTo(this.f19062a.m22647a(0).f19083b, this.f19062a.m22647a(0).f19084c);
            for (int i = 0; i < this.f19062a.m22646a() - 1; i++) {
                float f = this.f19062a.m22647a(i).f19083b;
                float f2 = this.f19062a.m22647a(i).f19084c;
                float f3 = this.f19062a.m22647a(i + 1).f19083b;
                float f4 = this.f19062a.m22647a(i + 1).f19084c;
                float f5 = this.f19062a.m22647a(m22632a(i + 2)).f19084c - f2;
                this.f19066e.cubicTo(((f3 - this.f19062a.m22647a(m22632a(i - 1)).f19083b) * 0.15f) + f, f2 + (0.15f * (f4 - this.f19062a.m22647a(m22632a(i - 1)).f19084c)), f3 - (0.15f * (this.f19062a.m22647a(m22632a(i + 2)).f19083b - f)), f4 - (0.15f * f5), f3, f4);
            }
        }
    }

    private int m22632a(int i) {
        if (this.f19062a != null && i > this.f19062a.m22646a() - 1) {
            return this.f19062a.m22646a() - 1;
        }
        if (i < 0) {
            return 0;
        }
        return i;
    }

    public final void m22638a(boolean z) {
        if (!z || this.f19071j == null) {
            this.f19078q = true;
            invalidate();
            return;
        }
        this.f19071j.addListener(this.f19072k);
        this.f19071j.reverse();
    }

    public final void m22640b(boolean z) {
        removeCallbacks(this.f19073l);
        if (z) {
            this.f19071j.removeListener(this.f19072k);
            float animatedFraction = this.f19071j.getAnimatedFraction();
            this.f19071j.end();
            this.f19071j.setCurrentPlayTime((long) (animatedFraction * 500.0f));
            this.f19071j.start();
            this.f19078q = false;
            return;
        }
        this.f19078q = false;
        invalidate();
    }

    public final void m22639b() {
        m22640b(true);
        postDelayed(this.f19073l, 2000);
    }

    public void setCursor(float f) {
        this.f19077p = f;
        if (!this.f19071j.isStarted()) {
            this.f19079r = true;
            invalidate();
        }
    }
}
