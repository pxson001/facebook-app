package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@GwtCompatible
/* compiled from: messenger_enable_moments_invite_android */
public abstract class AggregateFutureState {
    public static final AtomicReferenceFieldUpdater<AggregateFutureState, Set<Throwable>> f14013a = AtomicReferenceFieldUpdater.newUpdater(AggregateFutureState.class, Set.class, "c");
    public static final AtomicIntegerFieldUpdater<AggregateFutureState> f14014b = AtomicIntegerFieldUpdater.newUpdater(AggregateFutureState.class, "d");
    public volatile Set<Throwable> f14015c = null;
    private volatile int f14016d;

    public abstract void mo2698a(Set<Throwable> set);

    AggregateFutureState(int i) {
        this.f14016d = i;
    }
}
