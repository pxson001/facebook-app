package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: offersite/detail/view/?offer_view_id=%s&share_id=%s&site_uri=%s&title=%s&notif_trigger=%s&notif_medium=%s&rule=%s */
public interface Multiset<E> extends Collection<E> {
    int mo2163a(@Nullable Object obj);

    int mo2164a(@Nullable E e, int i);

    Set<Entry<E>> mo2172a();

    boolean mo2151a(E e, int i, int i2);

    boolean add(E e);

    int mo2165b(@Nullable Object obj, int i);

    int mo2168c(E e, int i);

    boolean contains(@Nullable Object obj);

    boolean containsAll(Collection<?> collection);

    Set<E> mo2155d();

    boolean equals(@Nullable Object obj);

    int hashCode();

    Iterator<E> iterator();

    boolean remove(@Nullable Object obj);
}
