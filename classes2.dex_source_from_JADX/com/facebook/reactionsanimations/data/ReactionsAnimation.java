package com.facebook.reactionsanimations.data;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.reactionsanimations.KeyFramedAnimation;
import java.util.List;

/* compiled from: hardware_address */
public class ReactionsAnimation {
    private KeyFramedAnimation f21417a;
    @DoNotStrip
    public float[] mAnchor;
    @DoNotStrip
    public List<ReactionsAnimationFrame> mAnimationFrames;
    @DoNotStrip
    public PropertyType mPropertyType;
    @DoNotStrip
    public float[][][] mTimingCurves;

    /* compiled from: hardware_address */
    public enum PropertyType {
        SCALE(true),
        ROTATION(true),
        POSITION(true),
        STROKE_WIDTH(false);
        
        final boolean mIsMatrixBased;

        private PropertyType(boolean z) {
            this.mIsMatrixBased = z;
        }

        public final boolean isMatrixBased() {
            return this.mIsMatrixBased;
        }
    }

    public final KeyFramedAnimation m29138e() {
        if (this.f21417a == null) {
            this.f21417a = new KeyFramedAnimation(this.mAnimationFrames, this.mTimingCurves, this.mPropertyType, this.mAnchor);
        }
        return this.f21417a;
    }
}
