package com.facebook.common.executors;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* compiled from: voip_audio_speaker_on */
public abstract class WrappingListeningExecutorService extends WrappingExecutorService implements ListeningExecutorService {
    ListeningExecutorService f963b;

    public /* synthetic */ Future submit(Runnable runnable) {
        return mo269a(runnable);
    }

    public /* synthetic */ Future submit(Runnable runnable, Object obj) {
        return mo270a(runnable, obj);
    }

    public /* synthetic */ Future submit(Callable callable) {
        return mo271a(callable);
    }

    public WrappingListeningExecutorService(ListeningExecutorService listeningExecutorService) {
        super(listeningExecutorService);
        this.f963b = listeningExecutorService;
    }

    public final <T> ListenableFuture<T> mo271a(Callable<T> callable) {
        return this.f963b.mo271a(a_((Callable) Preconditions.checkNotNull(callable)));
    }

    public final ListenableFuture<?> mo269a(Runnable runnable) {
        return this.f963b.mo269a(m1950b(runnable));
    }

    public final <T> ListenableFuture<T> mo270a(Runnable runnable, T t) {
        return this.f963b.mo270a(m1950b(runnable), t);
    }
}
