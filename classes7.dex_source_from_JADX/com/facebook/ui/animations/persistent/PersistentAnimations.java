package com.facebook.ui.animations.persistent;

import android.animation.Animator;
import com.facebook.common.time.Clock;
import com.facebook.ui.animations.BaseAnimatorListener;
import com.google.common.collect.ImmutableList;

/* compiled from: error while saving to bitmap */
public class PersistentAnimations {
    private final Clock f15217a;
    public final ImmutableList<PersistentAnimation> f15218b;
    private final long f15219c;
    private Runnable f15220d;
    public Animator f15221e;
    public boolean f15222f = false;
    public boolean f15223g = false;

    public PersistentAnimations(Clock clock, Runnable runnable, long j, ImmutableList<PersistentAnimation> immutableList) {
        this.f15220d = runnable;
        this.f15219c = j;
        this.f15218b = immutableList;
        this.f15217a = clock;
    }

    public final void m19218a() {
        if (!this.f15222f) {
            long a = this.f15217a.a() - this.f15219c;
            int a2 = m19214a(a);
            if (a2 < 0) {
                this.f15222f = true;
                this.f15220d.run();
                return;
            }
            m19216a(this, a2, ((float) (a - m19215a(a2))) / ((float) ((PersistentAnimation) this.f15218b.get(a2)).mo1178a()));
        }
    }

    public static void m19216a(PersistentAnimations persistentAnimations, final int i, float f) {
        PersistentAnimation persistentAnimation = (PersistentAnimation) persistentAnimations.f15218b.get(i);
        Animator a = persistentAnimation.mo1179a(f);
        a.setDuration((long) ((1.0f - f) * ((float) persistentAnimation.mo1178a())));
        Animator animator = a;
        animator.addListener(new BaseAnimatorListener(persistentAnimations) {
            final /* synthetic */ PersistentAnimations f15216b;

            public void onAnimationEnd(Animator animator) {
                if (this.f15216b.f15223g || i + 1 >= this.f15216b.f15218b.size()) {
                    PersistentAnimations.m19217c(this.f15216b);
                    this.f15216b.f15222f = true;
                    return;
                }
                PersistentAnimations.m19216a(this.f15216b, i + 1, 0.0f);
            }
        });
        animator.start();
        persistentAnimations.f15221e = animator;
    }

    public static void m19217c(PersistentAnimations persistentAnimations) {
        if (persistentAnimations.f15220d != null) {
            persistentAnimations.f15220d.run();
            persistentAnimations.f15220d = null;
        }
    }

    private int m19214a(long j) {
        for (int i = 0; i < this.f15218b.size(); i++) {
            long a = m19215a(i);
            long a2 = ((PersistentAnimation) this.f15218b.get(i)).mo1178a() + a;
            if (a <= j && j < a2) {
                return i;
            }
        }
        return -1;
    }

    private long m19215a(int i) {
        long j = 0;
        for (int i2 = 0; i2 < this.f15218b.size(); i2++) {
            if (i2 == i) {
                return j;
            }
            j += ((PersistentAnimation) this.f15218b.get(i2)).mo1178a();
        }
        return Long.MAX_VALUE;
    }
}
