package com.facebook.photos.tagging.shared;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: has_past_places_in_main_list_loaded */
public class FaceBoxesView extends View {
    private static final Matrix f13273b = new Matrix();
    @Inject
    public DefaultAndroidThreadUtil f13274a;
    private Paint f13275c;
    private Paint f13276d;
    private LinearGradient f13277e;
    private ValueAnimator f13278f;
    private AnimatorListener f13279g;
    private AnimatorUpdateListener f13280h;
    public FaceBoxClickListener f13281i;
    private boolean f13282j;
    private final Matrix f13283k;
    private final Matrix f13284l;
    private final Matrix f13285m;
    private final Matrix f13286n;
    private final Matrix f13287o;
    private final RectF f13288p;
    private final RectF f13289q;
    private final float[] f13290r;
    private final List<RectF> f13291s;
    private RectF f13292t;
    private final RectF f13293u;
    private boolean f13294v;

    /* compiled from: has_past_places_in_main_list_loaded */
    public interface FaceBoxClickListener {
        void m20946a(RectF rectF);
    }

    /* compiled from: has_past_places_in_main_list_loaded */
    class ShimmerAnimatorListener implements AnimatorListener {
        final /* synthetic */ FaceBoxesView f13270a;

        public ShimmerAnimatorListener(FaceBoxesView faceBoxesView) {
            this.f13270a = faceBoxesView;
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            this.f13270a.m20956b();
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* compiled from: has_past_places_in_main_list_loaded */
    class ShimmerUpdateListener implements AnimatorUpdateListener {
        final /* synthetic */ FaceBoxesView f13271a;
        private float f13272b;

        public ShimmerUpdateListener(FaceBoxesView faceBoxesView) {
            this.f13271a = faceBoxesView;
            this.f13272b = -1.0f;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (this.f13272b == -1.0f) {
                this.f13272b = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ViewCompat.d(this.f13271a);
                return;
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            float width = (float) this.f13271a.getWidth();
            ViewCompat.a(this.f13271a, (int) (Math.min(floatValue, this.f13272b) * width), 0, (int) ((width * Math.max(floatValue, this.f13272b)) + (0.3f * width)), this.f13271a.getHeight());
            this.f13272b = floatValue;
        }
    }

    private static <T extends View> void m20949a(Class<T> cls, T t) {
        m20950a((Object) t, t.getContext());
    }

    private static void m20950a(Object obj, Context context) {
        ((FaceBoxesView) obj).f13274a = DefaultAndroidThreadUtil.b(FbInjector.get(context));
    }

    public FaceBoxesView(Context context) {
        super(context);
        this.f13279g = new ShimmerAnimatorListener(this);
        this.f13280h = new ShimmerUpdateListener(this);
        this.f13283k = new Matrix();
        this.f13284l = new Matrix();
        this.f13285m = new Matrix();
        this.f13286n = new Matrix();
        this.f13287o = new Matrix();
        this.f13288p = new RectF();
        this.f13289q = new RectF();
        this.f13290r = new float[9];
        this.f13291s = Lists.a();
        this.f13293u = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
        this.f13294v = false;
        m20951c();
    }

    public FaceBoxesView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13279g = new ShimmerAnimatorListener(this);
        this.f13280h = new ShimmerUpdateListener(this);
        this.f13283k = new Matrix();
        this.f13284l = new Matrix();
        this.f13285m = new Matrix();
        this.f13286n = new Matrix();
        this.f13287o = new Matrix();
        this.f13288p = new RectF();
        this.f13289q = new RectF();
        this.f13290r = new float[9];
        this.f13291s = Lists.a();
        this.f13293u = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
        this.f13294v = false;
        m20951c();
    }

    public FaceBoxesView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13279g = new ShimmerAnimatorListener(this);
        this.f13280h = new ShimmerUpdateListener(this);
        this.f13283k = new Matrix();
        this.f13284l = new Matrix();
        this.f13285m = new Matrix();
        this.f13286n = new Matrix();
        this.f13287o = new Matrix();
        this.f13288p = new RectF();
        this.f13289q = new RectF();
        this.f13290r = new float[9];
        this.f13291s = Lists.a();
        this.f13293u = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
        this.f13294v = false;
        m20951c();
    }

    private void m20951c() {
        m20949a(FaceBoxesView.class, (View) this);
        this.f13275c = new Paint();
        this.f13275c.setColor(-1509949441);
        this.f13275c.setStyle(Style.STROKE);
        this.f13275c.setAntiAlias(true);
        this.f13276d = new Paint(this.f13275c);
        this.f13276d.setColor(805306368);
        this.f13277e = new LinearGradient(0.0f, 0.5f, 1.0f, 0.5f, new int[]{-1509949441, -1, -1, -1509949441}, new float[]{0.0f, 0.5f, 0.8f, 1.0f}, TileMode.CLAMP);
    }

    public void setFaceBoxes(@Nullable Collection<RectF> collection) {
        this.f13274a.a();
        m20956b();
        this.f13291s.clear();
        if (collection != null) {
            this.f13291s.addAll(collection);
        }
        if (!this.f13282j) {
            m20952d();
        }
        invalidate();
    }

    public final void m20954a(int i, int i2, Matrix matrix) {
        Preconditions.checkNotNull(matrix);
        m20948a(matrix, (float) i, (float) i2);
        this.f13282j = true;
    }

    private void m20952d() {
        Preconditions.checkState(!this.f13282j);
        m20948a(f13273b, (float) getWidth(), (float) getHeight());
    }

    private void m20948a(Matrix matrix, float f, float f2) {
        if (!this.f13294v) {
            this.f13283k.reset();
            this.f13283k.setScale(f, f2, 0.0f, 0.0f);
            this.f13284l.set(matrix);
            this.f13285m.reset();
            this.f13285m.postConcat(this.f13283k);
            this.f13285m.postConcat(this.f13284l);
            this.f13285m.invert(this.f13286n);
            invalidate();
        }
    }

    public void setFaceboxClickedListener(FaceBoxClickListener faceBoxClickListener) {
        this.f13281i = faceBoxClickListener;
    }

    public final void m20953a() {
        m20947a(3);
    }

    private void m20947a(int i) {
        this.f13274a.a();
        if (this.f13278f == null && !this.f13291s.isEmpty()) {
            this.f13278f = ValueAnimator.ofFloat(new float[]{-0.3f, 1.3f});
            this.f13278f.setRepeatCount(i);
            this.f13278f.setDuration(1300);
            this.f13278f.setRepeatMode(1);
            this.f13278f.addListener(this.f13279g);
            this.f13278f.addUpdateListener(this.f13280h);
            this.f13278f.start();
        }
    }

    public final void m20956b() {
        this.f13274a.a();
        if (this.f13278f != null) {
            this.f13278f.cancel();
            this.f13278f = null;
            invalidate();
        }
    }

    public void setImageBounds(RectF rectF) {
        this.f13292t = rectF;
        this.f13294v = true;
        this.f13283k.reset();
        if (this.f13292t != null) {
            this.f13283k.setRectToRect(this.f13293u, this.f13292t, ScaleToFit.FILL);
            this.f13284l.reset();
            this.f13285m.set(this.f13283k);
            this.f13285m.invert(this.f13286n);
        }
        invalidate();
    }

    public void setDraweeMatrix(Matrix matrix) {
        this.f13294v = true;
        this.f13283k.set(matrix);
        this.f13284l.reset();
        this.f13285m.set(this.f13283k);
        this.f13285m.invert(this.f13286n);
        invalidate();
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 738234177);
        super.onSizeChanged(i, i2, i3, i4);
        if (!this.f13282j) {
            m20952d();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1389608066, a);
    }

    protected void onDraw(Canvas canvas) {
        float floatValue;
        super.onDraw(canvas);
        canvas.save();
        canvas.concat(this.f13284l);
        if (this.f13278f != null) {
            floatValue = ((Float) this.f13278f.getAnimatedValue()).floatValue();
            this.f13287o.reset();
            this.f13287o.postScale(0.3f, 1.0f);
            this.f13287o.postTranslate(floatValue, 0.0f);
            this.f13287o.postConcat(this.f13283k);
            this.f13277e.setLocalMatrix(this.f13287o);
            this.f13275c.setShader(this.f13277e);
        } else {
            this.f13275c.setShader(null);
        }
        floatValue = getCompensation();
        float f = getResources().getDisplayMetrics().density;
        float f2 = (floatValue * f) * 2.0f;
        f = 4.0f * (floatValue * f);
        float f3 = f / 2.0f;
        this.f13275c.setStrokeWidth(f2);
        this.f13276d.setStrokeWidth(f2);
        for (RectF mapRect : this.f13291s) {
            this.f13283k.mapRect(this.f13288p, mapRect);
            this.f13289q.set(this.f13288p.left - f3, this.f13288p.top - f3, this.f13288p.right + f3, this.f13288p.bottom + f3);
            canvas.drawRoundRect(this.f13289q, f, f, this.f13276d);
            canvas.drawRoundRect(this.f13288p, f, f, this.f13275c);
        }
        canvas.restore();
    }

    private float getCompensation() {
        if (this.f13294v) {
            return 1.0f;
        }
        this.f13284l.getValues(this.f13290r);
        return 1.0f / this.f13290r[0];
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -377519149);
        m20956b();
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1484547890, a);
    }

    public final boolean m20955a(PointF pointF) {
        if (this.f13291s.isEmpty()) {
            return false;
        }
        float[] fArr = new float[]{pointF.x, pointF.y};
        this.f13286n.mapPoints(fArr);
        for (RectF rectF : this.f13291s) {
            if (rectF.contains(fArr[0], fArr[1])) {
                this.f13281i.m20946a(rectF);
                return true;
            }
        }
        return false;
    }
}
