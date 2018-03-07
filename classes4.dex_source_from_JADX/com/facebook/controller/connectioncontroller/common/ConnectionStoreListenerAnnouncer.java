package com.facebook.controller.connectioncontroller.common;

import android.os.Looper;
import com.facebook.controller.connectioncontroller.common.ConnectionStore.ConnectionStoreListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: messenger_update_message_phase_two_failed */
public final class ConnectionStoreListenerAnnouncer<TEdge> implements ConnectionStoreListener<TEdge> {
    private final List<ConnectionStoreListener<TEdge>> f7909a = new CopyOnWriteArrayList();

    public final void m8205a(ConnectionStoreListener<TEdge> connectionStoreListener) {
        if (connectionStoreListener == null) {
            throw new NullPointerException();
        }
        this.f7909a.add(connectionStoreListener);
    }

    public final void m8208b(ConnectionStoreListener<TEdge> connectionStoreListener) {
        if (connectionStoreListener == null) {
            throw new NullPointerException();
        }
        this.f7909a.remove(connectionStoreListener);
    }

    public final void mo665a(int i, int i2, ConnectionState<TEdge> connectionState, boolean z) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Must be run on UI thread");
        }
        for (ConnectionStoreListener a : this.f7909a) {
            a.mo665a(i, i2, connectionState, z);
        }
    }

    public final void mo664a(int i, int i2, ConnectionState<TEdge> connectionState) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Must be run on UI thread");
        }
        for (ConnectionStoreListener a : this.f7909a) {
            a.mo664a(i, i2, connectionState);
        }
    }

    public final void mo668b(int i, int i2, ConnectionState<TEdge> connectionState) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Must be run on UI thread");
        }
        for (ConnectionStoreListener b : this.f7909a) {
            b.mo668b(i, i2, connectionState);
        }
    }

    public final void mo663a() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Must be run on UI thread");
        }
        for (ConnectionStoreListener a : this.f7909a) {
            a.mo663a();
        }
    }

    public final void mo666a(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Must be run on UI thread");
        }
        for (ConnectionStoreListener a : this.f7909a) {
            a.mo666a(connectionLocation, connectionOrder);
        }
    }

    public final void mo667b() {
        for (ConnectionStoreListener b : this.f7909a) {
            b.mo667b();
        }
    }
}
