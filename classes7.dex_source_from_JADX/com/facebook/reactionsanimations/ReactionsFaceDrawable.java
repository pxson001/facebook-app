package com.facebook.reactionsanimations;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.facebook.reactionsanimations.ReactionsFaceAnimationCallback.FrameListener;
import com.facebook.reactionsanimations.ReactionsScalingDrawable.ScaleDirection;
import com.facebook.reactionsanimations.data.ReactionsAnimation;
import com.facebook.reactionsanimations.data.ReactionsFace;
import com.facebook.reactionsanimations.data.ReactionsFeature;
import com.facebook.reactionsanimations.data.ReactionsGradient;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: fetch_feedback_with_viewer_context */
public class ReactionsFaceDrawable extends Drawable implements FrameListener, ReactionsScalingDrawable {
    private final ReactionsFace f14373a;
    private final Paint f14374b = new Paint(1);
    private final List<KeyFramedPath> f14375c;
    private final List<Path> f14376d;
    private final ReactionsFaceAnimationCallback f14377e;
    private final Matrix f14378f;
    private final Matrix f14379g;
    private final Matrix f14380h;
    private int f14381i;
    private int f14382j;
    private float f14383k;
    private float f14384l;
    private float f14385m;
    private float f14386n;
    private Shader f14387o;

    public ReactionsFaceDrawable(ReactionsFace reactionsFace) {
        this.f14373a = reactionsFace;
        this.f14374b.setStrokeCap(Cap.ROUND);
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        int size = this.f14373a.mFeatures.size();
        for (int i = 0; i < size; i++) {
            ReactionsFeature reactionsFeature = (ReactionsFeature) this.f14373a.mFeatures.get(i);
            if (reactionsFeature.d == null) {
                reactionsFeature.d = new KeyFramedPath(reactionsFeature.mKeyFrames, reactionsFeature.mTimingCurves);
            }
            arrayList.add(reactionsFeature.d);
            arrayList2.add(new Path());
        }
        this.f14375c = Collections.unmodifiableList(arrayList);
        this.f14376d = Collections.unmodifiableList(arrayList2);
        this.f14377e = ReactionsFaceAnimationCallback.m18257a(this, this.f14373a);
        this.f14378f = new Matrix();
        this.f14379g = new Matrix();
        this.f14380h = new Matrix();
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        this.f14381i = i3 - i;
        this.f14382j = i4 - i2;
        this.f14383k = ((float) this.f14381i) / this.f14373a.mCanvasSize[0];
        this.f14384l = ((float) this.f14381i) / this.f14373a.mCanvasSize[1];
        m18267b(0.0f);
        m18268b(1.0f, 1.0f, ScaleDirection.UP);
    }

    public final void mo1143a(float f, float f2, ScaleDirection scaleDirection) {
        m18268b(f, f2, scaleDirection);
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.translate((float) bounds.left, (float) bounds.top);
        canvas.concat(this.f14379g);
        for (int i = 0; i < this.f14373a.mFeatures.size(); i++) {
            ReactionsFeature reactionsFeature = (ReactionsFeature) this.f14373a.mFeatures.get(i);
            Path path = (Path) this.f14376d.get(i);
            this.f14374b.setShader(null);
            if (reactionsFeature.a() != 0) {
                this.f14374b.setStyle(Style.FILL);
                if (reactionsFeature.mEffect == null) {
                    this.f14374b.setColor(reactionsFeature.a());
                    canvas.drawPath(path, this.f14374b);
                } else {
                    this.f14374b.setShader(this.f14387o);
                    canvas.drawPath(path, this.f14374b);
                }
            }
            if (reactionsFeature.b() != 0) {
                this.f14374b.setColor(reactionsFeature.b());
                this.f14374b.setStyle(Style.STROKE);
                this.f14374b.setStrokeWidth(reactionsFeature.b[0]);
                canvas.drawPath(path, this.f14374b);
            }
        }
        canvas.concat(this.f14380h);
        canvas.translate((float) (-bounds.left), (float) (-bounds.top));
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }

    public final void m18269a() {
        ReactionsFaceAnimationCallback reactionsFaceAnimationCallback = this.f14377e;
        reactionsFaceAnimationCallback.f14369e = false;
        reactionsFaceAnimationCallback.mo1141b();
        reactionsFaceAnimationCallback.mo1140a();
    }

    public final void m18272b() {
        this.f14377e.f14369e = true;
    }

    private void m18267b(float f) {
        this.f14373a.a(f);
        for (int i = 0; i < this.f14373a.mFeatures.size(); i++) {
            Matrix matrix;
            ReactionsFeature reactionsFeature = (ReactionsFeature) this.f14373a.mFeatures.get(i);
            Matrix matrix2 = (Matrix) this.f14373a.a.get(reactionsFeature.mAnimationGroup);
            if (matrix2 != null) {
                this.f14378f.set(matrix2);
            } else {
                this.f14378f.reset();
            }
            matrix2 = this.f14378f;
            reactionsFeature.a.reset();
            if (reactionsFeature.mFeatureAnimations == null) {
                matrix = reactionsFeature.a;
            } else {
                if (reactionsFeature.c == null) {
                    reactionsFeature.c = new ReactionsAnimation[3];
                    for (ReactionsAnimation reactionsAnimation : reactionsFeature.mFeatureAnimations) {
                        if (reactionsAnimation.mPropertyType.isMatrixBased()) {
                            reactionsFeature.c[reactionsAnimation.mPropertyType.ordinal()] = reactionsAnimation;
                        }
                    }
                }
                for (ReactionsAnimation reactionsAnimation2 : reactionsFeature.c) {
                    if (reactionsAnimation2 != null) {
                        reactionsAnimation2.e().m18245a(f, reactionsFeature.a);
                    }
                }
                matrix = reactionsFeature.a;
            }
            matrix2.preConcat(matrix);
            Path path = (Path) this.f14376d.get(i);
            path.reset();
            ((KeyFramedPath) this.f14375c.get(i)).m18245a(f, path);
            path.transform(this.f14378f);
            reactionsFeature.a(f);
            if (reactionsFeature.mEffect != null) {
                reactionsFeature.mEffect.mGradient.a(this.f14373a.mCanvasSize[1], this.f14373a.mFrameRate, this.f14373a.mFrameCount);
                ReactionsGradient reactionsGradient = reactionsFeature.mEffect.mGradient;
                this.f14387o = reactionsGradient.c[(int) ((f / ((float) reactionsGradient.d)) * ((float) (reactionsGradient.c.length - 1)))];
            }
        }
    }

    public final void mo1142a(float f) {
        m18267b(f);
        invalidateSelf();
    }

    private void m18268b(float f, float f2, ScaleDirection scaleDirection) {
        if (this.f14385m != f || this.f14386n != f2) {
            this.f14379g.setScale(this.f14383k, this.f14384l);
            if (f == 1.0f && f2 == 1.0f) {
                this.f14385m = 1.0f;
                this.f14386n = 1.0f;
                this.f14379g.invert(this.f14380h);
                return;
            }
            float f3 = scaleDirection == ScaleDirection.UP ? (float) this.f14382j : 0.0f;
            this.f14379g.postScale(f, f, (float) (this.f14381i / 2), (float) (this.f14382j / 2));
            this.f14379g.postScale(f2, f2, (float) (this.f14381i / 2), f3);
            this.f14385m = f;
            this.f14386n = f2;
            this.f14379g.invert(this.f14380h);
        }
    }
}
