package com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* compiled from: method/user.sendMessengerOnlyPhoneConfirmationCode */
public abstract class ForwardingListenableFuture<V> extends ForwardingFuture<V> implements ListenableFuture<V> {
    protected abstract ListenableFuture<V> mo2648b();

    protected /* synthetic */ Future mo1830a() {
        return mo2648b();
    }

    protected /* synthetic */ Object mo105e() {
        return mo2648b();
    }

    protected ForwardingListenableFuture() {
    }

    public final void mo223a(Runnable runnable, Executor executor) {
        mo2648b().mo223a(runnable, executor);
    }
}
