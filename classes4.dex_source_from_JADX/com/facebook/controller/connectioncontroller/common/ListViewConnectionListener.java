package com.facebook.controller.connectioncontroller.common;

/* compiled from: minimal_hash */
public abstract class ListViewConnectionListener<TEdge> implements ConnectionListener<TEdge> {
    protected abstract void mo629a(boolean z);

    public final void mo633a(int i, int i2, boolean z) {
        mo629a(z);
    }

    public final void mo632a(int i, int i2) {
        mo629a(false);
    }

    public final void mo634b(int i, int i2) {
        mo629a(false);
    }

    public final void mo631a() {
    }
}
