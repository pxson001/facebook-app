package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;

@GwtCompatible
@Beta
/* compiled from: locationPackages */
public final class EvictingQueue<E> extends ForwardingQueue<E> implements Serializable {
    private final Queue<E> delegate;
    @VisibleForTesting
    final int maxSize;

    protected final /* synthetic */ Collection mo731b() {
        return mo728a();
    }

    protected final /* synthetic */ Object mo733e() {
        return mo728a();
    }

    private EvictingQueue(int i) {
        boolean z;
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "maxSize (%s) must >= 0", new Object[]{Integer.valueOf(i)});
        this.delegate = new ArrayDeque(i);
        this.maxSize = i;
    }

    public static <E> EvictingQueue<E> m9494a(int i) {
        return new EvictingQueue(i);
    }

    protected final Queue<E> mo728a() {
        return this.delegate;
    }

    public final boolean offer(E e) {
        return add(e);
    }

    public final boolean add(E e) {
        Preconditions.checkNotNull(e);
        if (this.maxSize != 0) {
            if (size() == this.maxSize) {
                this.delegate.remove();
            }
            this.delegate.add(e);
        }
        return true;
    }

    public final boolean addAll(Collection<? extends E> collection) {
        return m9503b(collection);
    }

    public final boolean contains(Object obj) {
        return mo728a().contains(Preconditions.checkNotNull(obj));
    }

    public final boolean remove(Object obj) {
        return mo728a().remove(Preconditions.checkNotNull(obj));
    }
}
