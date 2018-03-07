package com.facebook.feed.rows.core;

import com.facebook.inject.Lazy;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.google.common.collect.ImmutableMap.Builder;

/* compiled from: last_modified */
public class RootPartRegistrationController<E extends AnyEnvironment> {
    private final Builder<Class<?>, Lazy<?>> f17959a;

    public RootPartRegistrationController(Builder<Class<?>, Lazy<? extends MultiRowPartWithIsNeeded<?, ? super E>>> builder) {
        this.f17959a = builder;
    }

    public final <T> void m25196a(Class<? extends T> cls, Lazy<? extends MultiRowPartWithIsNeeded<? super T, ? super E>> lazy) {
        this.f17959a.m609b(cls, lazy);
    }
}
