package com.facebook.ui.animations.persistent;

import com.facebook.common.time.Clock;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: error_results */
public class PersistentAnimationBuilder {
    private final Clock f15211a;
    public final List<PersistentAnimation> f15212b = Lists.a();
    public Runnable f15213c;
    public long f15214d;

    private PersistentAnimationBuilder(Clock clock) {
        this.f15211a = clock;
    }

    public static PersistentAnimationBuilder m19212a(Clock clock) {
        return new PersistentAnimationBuilder(clock);
    }

    public final PersistentAnimations m19213a() {
        return new PersistentAnimations(this.f15211a, this.f15213c, this.f15214d, ImmutableList.copyOf(this.f15212b));
    }
}
