package com.facebook.feed.rows.core.events;

import javax.annotation.Nullable;

/* compiled from: rtc_conferencing_select_dialog_android */
public class Subscription<E extends KeyedEvent<K>, K> {
    final Class<E> f10137a;
    final K f10138b;
    final Action<E> f10139c;

    public Subscription(Class<E> cls, @Nullable K k, Action<E> action) {
        this.f10137a = cls;
        this.f10138b = k;
        this.f10139c = action;
    }
}
