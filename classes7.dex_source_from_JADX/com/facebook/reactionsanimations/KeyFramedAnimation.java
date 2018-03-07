package com.facebook.reactionsanimations;

import android.graphics.Matrix;
import com.facebook.reactionsanimations.data.HasKeyFrame;
import com.facebook.reactionsanimations.data.ReactionsAnimation.PropertyType;
import com.facebook.reactionsanimations.data.ReactionsAnimationFrame;
import java.util.List;

/* compiled from: fetch_profile_data */
public class KeyFramedAnimation extends KeyFramedObject<ReactionsAnimationFrame, Matrix> {
    private final PropertyType f14359a;
    public final float[] f14360b;

    /* compiled from: fetch_profile_data */
    /* synthetic */ class C10561 {
        static final /* synthetic */ int[] f14354a = new int[PropertyType.values().length];

        static {
            try {
                f14354a[PropertyType.ROTATION.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f14354a[PropertyType.SCALE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f14354a[PropertyType.POSITION.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    protected final void mo1139a(HasKeyFrame hasKeyFrame, HasKeyFrame hasKeyFrame2, float f, Object obj) {
        ReactionsAnimationFrame reactionsAnimationFrame = (ReactionsAnimationFrame) hasKeyFrame;
        ReactionsAnimationFrame reactionsAnimationFrame2 = (ReactionsAnimationFrame) hasKeyFrame2;
        Matrix matrix = (Matrix) obj;
        switch (C10561.f14354a[this.f14359a.ordinal()]) {
            case 1:
                if (reactionsAnimationFrame2 == null) {
                    matrix.postRotate(reactionsAnimationFrame.mData[0], this.f14360b[0], this.f14360b[1]);
                } else {
                    matrix.postRotate(KeyFramedObject.m18244a(reactionsAnimationFrame.mData[0], reactionsAnimationFrame2.mData[0], f), this.f14360b[0], this.f14360b[1]);
                }
                return;
            case 2:
                m18247c(reactionsAnimationFrame, reactionsAnimationFrame2, f, matrix);
                return;
            case 3:
                m18248d(reactionsAnimationFrame, reactionsAnimationFrame2, f, matrix);
                return;
            default:
                return;
        }
    }

    public KeyFramedAnimation(List<ReactionsAnimationFrame> list, float[][][] fArr, PropertyType propertyType, float[] fArr2) {
        super(list, fArr);
        this.f14359a = propertyType;
        if (fArr2 == null) {
            fArr2 = new float[2];
        }
        this.f14360b = fArr2;
        if (propertyType == PropertyType.POSITION) {
            this.f14360b[0] = ((ReactionsAnimationFrame) list.get(0)).mData[0];
            this.f14360b[1] = ((ReactionsAnimationFrame) list.get(0)).mData[1];
        }
    }

    private void m18247c(ReactionsAnimationFrame reactionsAnimationFrame, ReactionsAnimationFrame reactionsAnimationFrame2, float f, Matrix matrix) {
        if (reactionsAnimationFrame2 == null) {
            matrix.postScale(reactionsAnimationFrame.mData[0] / 100.0f, reactionsAnimationFrame.mData[1] / 100.0f, this.f14360b[0], this.f14360b[1]);
            return;
        }
        matrix.postScale(KeyFramedObject.m18244a(reactionsAnimationFrame.mData[0], reactionsAnimationFrame2.mData[0], f) / 100.0f, KeyFramedObject.m18244a(reactionsAnimationFrame.mData[1], reactionsAnimationFrame2.mData[1], f) / 100.0f, this.f14360b[0], this.f14360b[1]);
    }

    private void m18248d(ReactionsAnimationFrame reactionsAnimationFrame, ReactionsAnimationFrame reactionsAnimationFrame2, float f, Matrix matrix) {
        if (reactionsAnimationFrame2 != null) {
            matrix.postTranslate(KeyFramedObject.m18244a(reactionsAnimationFrame.mData[0], reactionsAnimationFrame2.mData[0], f) - this.f14360b[0], KeyFramedObject.m18244a(reactionsAnimationFrame.mData[1], reactionsAnimationFrame2.mData[1], f) - this.f14360b[1]);
        }
    }
}
