package com.facebook.ui.animations.persistent.parts;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import com.facebook.ui.animations.persistent.PersistentAnimation;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.Nullable;

/* compiled from: entryName */
public class PersistentSetAnimation implements PersistentAnimation {
    private final ImmutableList<PersistentAnimation> f15234a;
    private final long f15235b;
    @Nullable
    private final AnimatorListener f15236c;

    public PersistentSetAnimation(ImmutableList<PersistentAnimation> immutableList, long j, AnimatorListener animatorListener) {
        this.f15234a = immutableList;
        this.f15235b = j;
        this.f15236c = animatorListener;
    }

    public final Animator mo1179a(float f) {
        Animator animatorSet = new AnimatorSet();
        Collection arrayList = new ArrayList(this.f15234a.size());
        int size = this.f15234a.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(((PersistentAnimation) this.f15234a.get(i)).mo1179a(f));
        }
        animatorSet.setDuration((long) ((1.0f - f) * ((float) this.f15235b)));
        animatorSet.playTogether(arrayList);
        if (this.f15236c != null) {
            animatorSet.addListener(this.f15236c);
        }
        return animatorSet;
    }

    public final long mo1178a() {
        return this.f15235b;
    }
}
