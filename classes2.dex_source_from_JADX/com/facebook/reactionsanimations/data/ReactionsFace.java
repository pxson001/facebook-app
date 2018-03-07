package com.facebook.reactionsanimations.data;

import android.graphics.Matrix;
import android.util.SparseArray;
import com.facebook.proguard.annotations.DoNotStrip;
import java.util.List;

/* compiled from: gzip */
public class ReactionsFace {
    public final SparseArray<Matrix> f21427a = new SparseArray();
    @DoNotStrip
    private int mAnimationDuration;
    @DoNotStrip
    private List<ReactionsAnimationGroup> mAnimationGroups;
    @DoNotStrip
    public float[] mCanvasSize;
    @DoNotStrip
    public List<ReactionsFeature> mFeatures;
    @DoNotStrip
    public int mFrameCount;
    @DoNotStrip
    public int mFrameRate;
    @DoNotStrip
    private int mKey;

    public final void m29152a(float f) {
        for (ReactionsAnimationGroup reactionsAnimationGroup : this.mAnimationGroups) {
            if (this.f21427a.indexOfKey(reactionsAnimationGroup.mGroupId) < 0) {
                this.f21427a.put(reactionsAnimationGroup.mGroupId, new Matrix());
            }
            Matrix matrix = (Matrix) this.f21427a.get(reactionsAnimationGroup.mGroupId);
            matrix.reset();
            if (reactionsAnimationGroup.f21424a == null) {
                reactionsAnimationGroup.f21424a = new ReactionsAnimation[3];
                for (ReactionsAnimation reactionsAnimation : reactionsAnimationGroup.mAnimations) {
                    reactionsAnimationGroup.f21424a[reactionsAnimation.mPropertyType.ordinal()] = reactionsAnimation;
                }
            }
            for (ReactionsAnimation reactionsAnimation2 : reactionsAnimationGroup.f21424a) {
                if (reactionsAnimation2 != null) {
                    reactionsAnimation2.m29138e().a(f, matrix);
                }
            }
            if (reactionsAnimationGroup.mParentGroup > 0) {
                matrix.preConcat((Matrix) this.f21427a.get(reactionsAnimationGroup.mParentGroup));
            }
        }
    }
}
