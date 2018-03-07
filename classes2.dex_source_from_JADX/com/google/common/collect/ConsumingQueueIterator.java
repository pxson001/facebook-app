package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Collections;
import java.util.Queue;

@GwtCompatible
/* compiled from: with_tagging_rank */
public class ConsumingQueueIterator<T> extends AbstractIterator<T> {
    private final Queue<T> f712a = Lists.m1306b();

    public ConsumingQueueIterator(T... tArr) {
        Collections.addAll(this.f712a, tArr);
    }

    public final T mo209a() {
        return this.f712a.isEmpty() ? m1437b() : this.f712a.remove();
    }
}
