package com.facebook.widget.animatablelistview;

import android.view.animation.Interpolator;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: android.media.property.OUTPUT_SAMPLE_RATE */
public class AnimatingListTransaction<T> {
    public final ImmutableList<AnimatingListMutation<T>> f20489a;
    public final ImmutableList<T> f20490b;
    public final ImmutableList<T> f20491c;
    public final long f20492d;
    @Nullable
    public final Interpolator f20493e;

    AnimatingListTransaction(ImmutableList<AnimatingListMutation<T>> immutableList, ImmutableList<T> immutableList2, ImmutableList<T> immutableList3, long j, Interpolator interpolator) {
        this.f20489a = immutableList;
        this.f20490b = immutableList2;
        this.f20491c = immutableList3;
        this.f20492d = j;
        this.f20493e = interpolator;
    }
}
