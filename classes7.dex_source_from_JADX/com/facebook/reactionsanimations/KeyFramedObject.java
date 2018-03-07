package com.facebook.reactionsanimations;

import android.util.SparseArray;
import android.view.animation.Interpolator;
import com.facebook.reactionsanimations.data.HasKeyFrame;
import java.util.List;

/* compiled from: fetch_lead_gen_deep_link_story */
public abstract class KeyFramedObject<T extends HasKeyFrame, M> {
    private final SparseArray<T> f14355a;
    private final List<Interpolator> f14356b;
    private final int f14357c;
    private final int f14358d;

    protected abstract void mo1139a(T t, T t2, float f, M m);

    public KeyFramedObject(List<T> list, float[][][] fArr) {
        int size = list.size();
        this.f14355a = new SparseArray(size);
        for (int i = 0; i < size; i++) {
            HasKeyFrame hasKeyFrame = (HasKeyFrame) list.get(i);
            this.f14355a.put(hasKeyFrame.a(), hasKeyFrame);
        }
        this.f14357c = this.f14355a.keyAt(0);
        this.f14358d = this.f14355a.keyAt(size - 1);
        this.f14356b = KeyFrameAnimationHelper.m18243a(fArr);
    }

    protected KeyFramedObject() {
        this.f14355a = null;
        this.f14356b = null;
        this.f14357c = 0;
        this.f14358d = 0;
    }

    public final void m18245a(float f, M m) {
        HasKeyFrame hasKeyFrame = null;
        if (this.f14356b.isEmpty() || f <= ((float) this.f14357c)) {
            mo1139a((HasKeyFrame) this.f14355a.get(this.f14357c), null, 0.0f, m);
        } else if (f >= ((float) this.f14358d)) {
            mo1139a((HasKeyFrame) this.f14355a.get(this.f14358d), null, 0.0f, m);
        } else {
            HasKeyFrame hasKeyFrame2;
            int size = this.f14356b.size();
            int i = 0;
            while (i < size) {
                if (((float) this.f14355a.keyAt(i)) == f || (((float) this.f14355a.keyAt(i)) < f && ((float) this.f14355a.keyAt(i + 1)) > f)) {
                    hasKeyFrame = (HasKeyFrame) this.f14355a.valueAt(i + 1);
                    hasKeyFrame2 = (HasKeyFrame) this.f14355a.valueAt(i);
                    break;
                }
                i++;
            }
            hasKeyFrame2 = null;
            mo1139a(hasKeyFrame2, hasKeyFrame, ((Interpolator) this.f14356b.get(i)).getInterpolation((f - ((float) hasKeyFrame2.a())) / ((float) (hasKeyFrame.a() - hasKeyFrame2.a()))), m);
        }
    }

    public static float m18244a(float f, float f2, float f3) {
        return ((f2 - f) * f3) + f;
    }
}
