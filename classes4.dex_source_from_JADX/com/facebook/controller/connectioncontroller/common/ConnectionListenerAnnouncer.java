package com.facebook.controller.connectioncontroller.common;

import android.os.Looper;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: messenger_seen_heads_max_group_size */
public final class ConnectionListenerAnnouncer<TEdge> implements ConnectionListener<TEdge> {
    private final List<ConnectionListener<TEdge>> f7933a = new CopyOnWriteArrayList();

    public final void m8246a(ConnectionListener<TEdge> connectionListener) {
        if (connectionListener == null) {
            throw new NullPointerException();
        }
        this.f7933a.add(connectionListener);
    }

    public final void m8250b(ConnectionListener<TEdge> connectionListener) {
        if (connectionListener == null) {
            throw new NullPointerException();
        }
        this.f7933a.remove(connectionListener);
    }

    public final void mo627a(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Must be run on UI thread");
        }
        for (ConnectionListener a : this.f7933a) {
            a.mo627a(connectionLocation, connectionOrder);
        }
    }

    public final void mo630b(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Must be run on UI thread");
        }
        for (ConnectionListener b : this.f7933a) {
            b.mo630b(connectionLocation, connectionOrder);
        }
    }

    public final void mo628a(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder, Throwable th) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Must be run on UI thread");
        }
        for (ConnectionListener a : this.f7933a) {
            a.mo628a(connectionLocation, connectionOrder, th);
        }
    }

    public final void mo633a(int i, int i2, boolean z) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Must be run on UI thread");
        }
        for (ConnectionListener a : this.f7933a) {
            a.mo633a(i, i2, z);
        }
    }

    public final void mo632a(int i, int i2) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Must be run on UI thread");
        }
        for (ConnectionListener a : this.f7933a) {
            a.mo632a(i, i2);
        }
    }

    public final void mo634b(int i, int i2) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Must be run on UI thread");
        }
        for (ConnectionListener b : this.f7933a) {
            b.mo634b(i, i2);
        }
    }

    public final void mo631a() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Must be run on UI thread");
        }
        for (ConnectionListener a : this.f7933a) {
            a.mo631a();
        }
    }
}
