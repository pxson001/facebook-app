package com.facebook.graphql.cursor;

import android.os.Bundle;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.inject.Assisted;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.base.Preconditions;
import com.google.common.collect.HashMultimap;
import java.io.Closeable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;

/* compiled from: messenger_user_prefs */
public class LocalModelCursorLoaderManager implements Closeable {
    @GuardedBy("sActiveLoaders")
    private static final HashMultimap<String, LocalModelCursorLoaderManager> f7901a = HashMultimap.u();
    private final String f7902b;
    public final LoaderCallbacks f7903c;
    public final ModelCursorLoader f7904d;
    public final DefaultAndroidThreadUtil f7905e;
    private final Executor f7906f;
    public final Executor f7907g;
    public final AtomicBoolean f7908h = new AtomicBoolean(false);

    /* compiled from: messenger_user_prefs */
    public interface LoaderCallbacks {
        void mo662a(@Nullable ModelCursor modelCursor);
    }

    public static void m8199a(String str, Bundle bundle) {
        synchronized (f7901a) {
            for (LocalModelCursorLoaderManager a : f7901a.a(str)) {
                a.m8198a(bundle);
            }
        }
    }

    @Inject
    public LocalModelCursorLoaderManager(@Assisted String str, @Assisted LoaderCallbacks loaderCallbacks, ModelCursorLoaderProvider modelCursorLoaderProvider, DefaultAndroidThreadUtil defaultAndroidThreadUtil, ExecutorService executorService, Executor executor) {
        this.f7902b = (String) Preconditions.checkNotNull(str);
        this.f7903c = (LoaderCallbacks) Preconditions.checkNotNull(loaderCallbacks);
        this.f7904d = modelCursorLoaderProvider.m8191a(str);
        this.f7905e = defaultAndroidThreadUtil;
        this.f7906f = executorService;
        this.f7907g = executor;
        synchronized (f7901a) {
            f7901a.a(this.f7902b, this);
        }
    }

    public final void m8200a() {
        m8198a(Bundle.EMPTY);
    }

    private void m8198a(Bundle bundle) {
        this.f7908h.set(true);
        ExecutorDetour.a(this.f7906f, new LoadRunnable(this, bundle), 1216831180);
    }

    public void close() {
        this.f7908h.set(false);
        synchronized (f7901a) {
            f7901a.c(this.f7902b, this);
        }
        ExecutorDetour.a(this.f7907g, new NotifyRunnable(this, null), 1272157098);
    }
}
