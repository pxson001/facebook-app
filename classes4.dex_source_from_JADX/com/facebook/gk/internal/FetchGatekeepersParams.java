package com.facebook.gk.internal;

import com.google.common.collect.ImmutableSet;

/* compiled from: timeline_sections */
public class FetchGatekeepersParams {
    public final ImmutableSet<String> f1002a;
    public final Session f1003b;

    /* compiled from: timeline_sections */
    public enum Session {
        IS_SESSIONLESS,
        IS_NOT_SESSIONLESS
    }

    public FetchGatekeepersParams(ImmutableSet<String> immutableSet, Session session) {
        this.f1002a = immutableSet;
        this.f1003b = session;
    }
}
