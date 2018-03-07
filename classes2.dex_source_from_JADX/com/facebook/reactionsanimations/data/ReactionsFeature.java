package com.facebook.reactionsanimations.data;

import android.graphics.Color;
import android.graphics.Matrix;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.reactionsanimations.KeyFramedPath;
import com.facebook.reactionsanimations.KeyFramedStrokeWidth;
import com.facebook.reactionsanimations.data.ReactionsAnimation.PropertyType;
import java.util.List;

/* compiled from: gysj_imp */
public class ReactionsFeature {
    public final Matrix f21429a = new Matrix();
    public final float[] f21430b = new float[1];
    public ReactionsAnimation[] f21431c;
    public KeyFramedPath f21432d;
    private KeyFramedStrokeWidth f21433e;
    private Integer f21434f = null;
    private Integer f21435g = null;
    @DoNotStrip
    public int mAnimationGroup;
    @DoNotStrip
    public ReactionsFeatureEffect mEffect;
    @DoNotStrip
    public List<ReactionsAnimation> mFeatureAnimations;
    @DoNotStrip
    private String mFillColor;
    @DoNotStrip
    public List<ReactionsFeatureFrame> mKeyFrames;
    @DoNotStrip
    private String mName;
    @DoNotStrip
    private String mStrokeColor;
    @DoNotStrip
    private float mStrokeWidth;
    @DoNotStrip
    public float[][][] mTimingCurves;

    public final int m29156a() {
        if (this.f21434f == null) {
            this.f21434f = Integer.valueOf(m29155a(this.mFillColor));
        }
        return this.f21434f.intValue();
    }

    public final int m29158b() {
        if (this.f21435g == null) {
            this.f21435g = Integer.valueOf(m29155a(this.mStrokeColor));
        }
        return this.f21435g.intValue();
    }

    private static int m29155a(String str) {
        if (str == null) {
            return 0;
        }
        return Color.parseColor(str);
    }

    public final void m29157a(float f) {
        this.f21430b[0] = this.mStrokeWidth;
        if (this.mFeatureAnimations != null && this.f21433e != KeyFramedStrokeWidth.a) {
            if (this.f21433e == null) {
                for (ReactionsAnimation reactionsAnimation : this.mFeatureAnimations) {
                    if (reactionsAnimation.mPropertyType == PropertyType.STROKE_WIDTH) {
                        this.f21433e = new KeyFramedStrokeWidth(reactionsAnimation.mAnimationFrames, reactionsAnimation.mTimingCurves);
                    }
                }
                if (this.f21433e == null) {
                    this.f21433e = KeyFramedStrokeWidth.a;
                    return;
                }
            }
            this.f21433e.a(f, this.f21430b);
        }
    }
}
