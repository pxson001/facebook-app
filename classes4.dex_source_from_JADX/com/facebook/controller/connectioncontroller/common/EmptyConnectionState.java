package com.facebook.controller.connectioncontroller.common;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;

/* compiled from: minutiae_single_icon_fetch */
public final class EmptyConnectionState<TEdge> implements ConnectionState<TEdge> {
    public static final ConnectionState f7635a = new EmptyConnectionState();

    private EmptyConnectionState() {
    }

    public final TEdge mo622a(int i) {
        throw new IndexOutOfBoundsException();
    }

    public final int mo625d() {
        return 0;
    }

    public final ConnectionLocation mo621a() {
        return ConnectionLocation.f7941a;
    }

    public final ConnectionLocation mo623b() {
        return ConnectionLocation.f7941a;
    }

    public final ConnectionLocation mo624c() {
        return ConnectionLocation.f7941a;
    }

    public final ImmutableList<ConnectionChunk> mo626e() {
        return RegularImmutableList.a;
    }
}
