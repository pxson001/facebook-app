package com.facebook.controller.connectioncontroller.common;

import com.google.common.collect.ImmutableList;

/* compiled from: member */
public abstract class AbstractConnectionState<TEdge> implements ConnectionState<TEdge> {
    public final ConnectionLocation mo621a() {
        return ConnectionLocation.f7941a;
    }

    public final ConnectionLocation mo623b() {
        ImmutableList e = mo626e();
        if (e.isEmpty()) {
            return mo621a();
        }
        return ((ConnectionChunk) e.get(0)).a;
    }

    public final ConnectionLocation mo624c() {
        ImmutableList e = mo626e();
        int size = e.size();
        if (size > 0) {
            return ((ConnectionChunk) e.get(size - 1)).b;
        }
        return mo621a();
    }
}
