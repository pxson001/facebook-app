package com.facebook.ui.futures;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.DisposableFutureCallback;
import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;

@ThreadSafe
/* compiled from: platform_webdialogs_manifest_fetch */
public class TasksManager<Key> {
    public static final PendingResultHolder f9553d = new PendingResultHolder(null, null, PendingTaskStatus.DISPOSED);
    @GuardedBy("this")
    public final ArrayListMultimap<Key, FutureAndCallbackHolder<?>> f9554a = ArrayListMultimap.m2971t();
    private final DefaultAndroidThreadUtil f9555b;
    private final Executor f9556c;

    /* compiled from: platform_webdialogs_manifest_fetch */
    public class PendingResultHolder<T> {
        @Nullable
        public T f9557a;
        @Nullable
        public Throwable f9558b;
        public PendingTaskStatus f9559c;

        public PendingResultHolder(T t, Throwable th, PendingTaskStatus pendingTaskStatus) {
            Preconditions.checkNotNull(pendingTaskStatus);
            this.f9557a = t;
            this.f9558b = th;
            this.f9559c = pendingTaskStatus;
        }
    }

    /* compiled from: platform_webdialogs_manifest_fetch */
    public enum PendingTaskStatus {
        SUCCESSFUL,
        FAILED,
        DISPOSED
    }

    /* compiled from: platform_webdialogs_manifest_fetch */
    public class CallbackWithCleanup<T> implements DisposableFutureCallback<T> {
        final /* synthetic */ TasksManager f14022a;
        private DisposableFutureCallback<T> f14023b;
        private final Key f14024c;

        CallbackWithCleanup(TasksManager tasksManager, Key key, DisposableFutureCallback<T> disposableFutureCallback) {
            this.f14022a = tasksManager;
            this.f14023b = disposableFutureCallback;
            this.f14024c = key;
        }

        protected final Key m20343b() {
            return this.f14024c;
        }

        public final void jc_() {
            TasksManager.m14549a(this.f14022a, this.f14024c, (DisposableFutureCallback) this);
            synchronized (this) {
                this.f14023b.jc_();
                this.f14023b = null;
            }
        }

        public final boolean ba_() {
            boolean z;
            synchronized (this) {
                z = this.f14023b == null || this.f14023b.ba_();
            }
            return z;
        }

        public void onSuccess(T t) {
            TasksManager.m14549a(this.f14022a, this.f14024c, (DisposableFutureCallback) this);
            synchronized (this) {
                if (this.f14023b != null) {
                    this.f14023b.onSuccess(t);
                }
            }
        }

        public void onFailure(Throwable th) {
            TasksManager.m14549a(this.f14022a, this.f14024c, (DisposableFutureCallback) this);
            synchronized (this) {
                if (this.f14023b != null) {
                    this.f14023b.onFailure(th);
                }
            }
        }
    }

    public static TasksManager m14550b(InjectorLike injectorLike) {
        return new TasksManager(DefaultAndroidThreadUtil.m1646b(injectorLike), ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.m1951a(injectorLike));
    }

    private <T> void m14548a(FutureAndCallbackHolder<T> futureAndCallbackHolder) {
        Futures.m2458a(futureAndCallbackHolder.f14025a, (FutureCallback) futureAndCallbackHolder.f14026b, this.f9556c);
    }

    @Inject
    public TasksManager(DefaultAndroidThreadUtil defaultAndroidThreadUtil, ScheduledExecutorService scheduledExecutorService) {
        this.f9555b = defaultAndroidThreadUtil;
        this.f9556c = scheduledExecutorService;
    }

    public static TasksManager m14546a(InjectorLike injectorLike) {
        return m14550b(injectorLike);
    }

    public final <T> boolean m14556a(Key key, Callable<ListenableFuture<T>> callable, DisposableFutureCallback<T> disposableFutureCallback) {
        this.f9555b.m1649a();
        if (m14555a((Object) key)) {
            return false;
        }
        m14551d(key, m14547a((Callable) callable), new CallbackWithCleanup(this, key, disposableFutureCallback));
        return true;
    }

    public final <T> void m14553a(Key key, ListenableFuture<T> listenableFuture, DisposableFutureCallback<T> disposableFutureCallback) {
        this.f9555b.m1649a();
        m14561c(key);
        m14551d(key, listenableFuture, new CallbackWithCleanup(this, key, disposableFutureCallback));
    }

    public final <T> void m14559b(Key key, ListenableFuture<T> listenableFuture, DisposableFutureCallback<T> disposableFutureCallback) {
        m14551d(key, listenableFuture, new CallbackWithOlderTasksCleanup(this, key, disposableFutureCallback));
    }

    public final <T> void m14562c(Key key, ListenableFuture<T> listenableFuture, DisposableFutureCallback<T> disposableFutureCallback) {
        OrderedDisposableFutureCallback orderedDisposableFutureCallback = new OrderedDisposableFutureCallback(this, key, disposableFutureCallback);
        DisposableFutureCallback e = m14552e(key);
        if (e == null || (e instanceof OrderedDisposableFutureCallback)) {
            OrderedDisposableFutureCallback orderedDisposableFutureCallback2 = (OrderedDisposableFutureCallback) e;
            if (orderedDisposableFutureCallback2 != null) {
                orderedDisposableFutureCallback.e = orderedDisposableFutureCallback2;
                orderedDisposableFutureCallback2.f = orderedDisposableFutureCallback;
            }
            m14551d(key, listenableFuture, orderedDisposableFutureCallback);
            return;
        }
        throw new RuntimeException("Ordered and unordered task can't be added under same key : " + key);
    }

    private <T> void m14551d(Key key, ListenableFuture<T> listenableFuture, DisposableFutureCallback<T> disposableFutureCallback) {
        FutureAndCallbackHolder futureAndCallbackHolder = new FutureAndCallbackHolder(listenableFuture, disposableFutureCallback);
        synchronized (this) {
            this.f9554a.mo431a((Object) key, (Object) futureAndCallbackHolder);
        }
        m14548a(futureAndCallbackHolder);
    }

    public final synchronized boolean m14555a(Key key) {
        return this.f9554a.mo414f(key);
    }

    @Nullable
    public final synchronized ListenableFuture<?> m14558b(Key key) {
        ListenableFuture<?> listenableFuture;
        boolean z = true;
        synchronized (this) {
            List a = this.f9554a.mo424a(key);
            if (a.size() > 1) {
                z = false;
            }
            Preconditions.checkState(z);
            if (a.isEmpty()) {
                listenableFuture = null;
            } else {
                listenableFuture = ((FutureAndCallbackHolder) a.get(0)).m20345a();
            }
        }
        return listenableFuture;
    }

    public final synchronized boolean m14554a() {
        return !this.f9554a.mo420n();
    }

    public final synchronized Multiset<Key> m14557b() {
        return this.f9554a.mo422q();
    }

    public final void m14561c(Key key) {
        if (m14555a((Object) key)) {
            ArrayList a;
            synchronized (this) {
                a = Lists.m1298a(this.f9554a.mo424a(key));
            }
            int size = a.size();
            for (int i = 0; i < size; i++) {
                ((FutureAndCallbackHolder) a.get(i)).m20346a(false);
            }
            synchronized (this) {
                this.f9554a.mo425b(key);
            }
        }
    }

    public final synchronized void m14560c() {
        while (!this.f9554a.mo420n()) {
            m14561c(this.f9554a.mo421p().iterator().next());
        }
    }

    public static synchronized void m14549a(TasksManager tasksManager, Object obj, DisposableFutureCallback disposableFutureCallback) {
        synchronized (tasksManager) {
            for (FutureAndCallbackHolder futureAndCallbackHolder : tasksManager.f9554a.mo424a(obj)) {
                if (futureAndCallbackHolder.m20347b() == disposableFutureCallback) {
                    tasksManager.f9554a.mo412c(obj, futureAndCallbackHolder);
                    break;
                }
            }
        }
    }

    private static <T> ListenableFuture<T> m14547a(Callable<ListenableFuture<T>> callable) {
        try {
            return (ListenableFuture) callable.call();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Nullable
    private <T> DisposableFutureCallback<T> m14552e(Key key) {
        FutureAndCallbackHolder futureAndCallbackHolder;
        synchronized (this) {
            List a = this.f9554a.mo424a(key);
        }
        if (a.isEmpty()) {
            futureAndCallbackHolder = null;
        } else {
            futureAndCallbackHolder = (FutureAndCallbackHolder) a.get(a.size() - 1);
        }
        return futureAndCallbackHolder != null ? futureAndCallbackHolder.m20347b() : null;
    }
}
