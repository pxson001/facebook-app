package com.facebook.messaging.ephemeral;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.facebook.common.util.MathUtil;
import com.facebook.debug.log.BLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* compiled from: mStreet1 */
public class ShatterView extends View {
    private static final Class<ShatterView> f11049a = ShatterView.class;
    private final Paint f11050b = new Paint();
    private final Random f11051c = new Random();
    private final Rect f11052d = new Rect();
    private final Rect f11053e = new Rect();
    private final Rect f11054f = new Rect();
    private Bitmap f11055g;
    public List<Particle> f11056h;
    public ValueAnimator f11057i;

    /* compiled from: mStreet1 */
    class C12231 implements AnimatorUpdateListener {
        final /* synthetic */ ShatterView f11036a;

        C12231(ShatterView shatterView) {
            this.f11036a = shatterView;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ShatterView shatterView = this.f11036a;
            float animatedFraction = shatterView.f11057i.getAnimatedFraction();
            for (Particle particle : shatterView.f11056h) {
                particle.f11043g = particle.f11046j * animatedFraction;
                particle.f11044h = particle.f11047k * animatedFraction;
                particle.f11045i = 1.0f + (particle.f11048l * animatedFraction);
            }
            shatterView.invalidate();
        }
    }

    /* compiled from: mStreet1 */
    public class Particle {
        int f11037a;
        int f11038b;
        int f11039c;
        int f11040d;
        int f11041e;
        int f11042f;
        public float f11043g;
        public float f11044h;
        public float f11045i;
        public float f11046j;
        public float f11047k;
        public float f11048l;
    }

    public ShatterView(Context context) {
        super(context);
    }

    public final void m11447a(View view) {
        Bitmap drawingCache;
        try {
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            drawingCache = view.getDrawingCache();
        } catch (Throwable e) {
            BLog.a(f11049a, "Unable to retrieve bitmap for expired ephemeral message animation.", e);
            drawingCache = null;
        }
        if (drawingCache == null) {
            view.setDrawingCacheEnabled(false);
            return;
        }
        this.f11055g = drawingCache.copy(drawingCache.getConfig(), false);
        view.setDrawingCacheEnabled(false);
        if (this.f11057i != null) {
            this.f11057i.cancel();
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        this.f11056h = new ArrayList();
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131427878);
        int width = this.f11055g.getWidth();
        int height = this.f11055g.getHeight();
        int ceil = (int) Math.ceil((double) (((float) this.f11055g.getWidth()) / ((float) dimensionPixelSize)));
        int ceil2 = (int) Math.ceil((double) (((float) this.f11055g.getHeight()) / ((float) dimensionPixelSize)));
        for (int i = 0; i < ceil; i++) {
            for (int i2 = 0; i2 < ceil2; i2++) {
                int i3 = i * dimensionPixelSize;
                int i4 = i2 * dimensionPixelSize;
                int min = Math.min(i3 + dimensionPixelSize, width) - i3;
                int min2 = Math.min(i4 + dimensionPixelSize, height) - i4;
                Particle particle = new Particle();
                particle.f11037a = i3;
                particle.f11038b = i4;
                particle.f11039c = min;
                particle.f11040d = min2;
                particle.f11041e = i3 + rect.left;
                particle.f11042f = rect.top + i4;
                particle.f11045i = 1.0f;
                particle.f11046j = (float) MathUtil.a(-150, 150, this.f11051c.nextFloat());
                particle.f11047k = (float) MathUtil.a(-150, 150, this.f11051c.nextFloat());
                particle.f11048l = MathUtil.a(-0.15f, 0.05f, this.f11051c.nextFloat());
                this.f11056h.add(particle);
            }
        }
        this.f11057i = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f}).setDuration(400);
        this.f11057i.setInterpolator(new DecelerateInterpolator());
        this.f11057i.addUpdateListener(new C12231(this));
        this.f11057i.start();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f11057i != null) {
            this.f11050b.setAlpha((int) (255.0f * (1.0f - this.f11057i.getAnimatedFraction())));
            for (Particle particle : this.f11056h) {
                this.f11052d.set(particle.f11037a, particle.f11038b, particle.f11037a + particle.f11039c, particle.f11038b + particle.f11040d);
                this.f11053e.set(particle.f11041e, particle.f11042f, particle.f11041e + particle.f11039c, particle.f11042f + particle.f11040d);
                this.f11053e.offset(-this.f11054f.left, -this.f11054f.top);
                canvas.save();
                canvas.translate(particle.f11043g, particle.f11044h);
                canvas.scale(particle.f11045i, particle.f11045i, (float) this.f11052d.centerX(), (float) this.f11052d.centerY());
                canvas.drawBitmap(this.f11055g, this.f11052d, this.f11053e, this.f11050b);
                canvas.restore();
            }
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        getGlobalVisibleRect(this.f11054f);
    }
}
