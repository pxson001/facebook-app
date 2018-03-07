package com.facebook.orca.threadlist;

import com.facebook.common.idleexecutor.DefaultProcessIdleExecutor;
import com.facebook.common.idleexecutor.IdleExecutor_ForUiThreadMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ultralight.Inject;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;

/* compiled from: native_close */
public class ThreadListFragmentUpdateOrchestrator {
    private static final Class<?> f6666a = ThreadListFragmentUpdateOrchestrator.class;
    private final DefaultProcessIdleExecutor f6667b;
    private final Runnable f6668c = new C10091(this);
    public Runnable f6669d;
    private int f6670e;
    private boolean f6671f;
    @Nullable
    private Urgency f6672g;
    @Nullable
    public ListenableFuture<?> f6673h;

    /* compiled from: native_close */
    class C10091 implements Runnable {
        final /* synthetic */ ThreadListFragmentUpdateOrchestrator f6665a;

        C10091(ThreadListFragmentUpdateOrchestrator threadListFragmentUpdateOrchestrator) {
            this.f6665a = threadListFragmentUpdateOrchestrator;
        }

        public void run() {
            this.f6665a.f6673h = null;
            ThreadListFragmentUpdateOrchestrator.m6375c(this.f6665a);
        }
    }

    /* compiled from: native_close */
    public enum Urgency {
        USER_ACTION,
        THREADS,
        INBOX_TOP_UNITS,
        ACTIVE_NOW,
        OTHER
    }

    public static ThreadListFragmentUpdateOrchestrator m6374a(InjectorLike injectorLike) {
        return new ThreadListFragmentUpdateOrchestrator(IdleExecutor_ForUiThreadMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public ThreadListFragmentUpdateOrchestrator(DefaultProcessIdleExecutor defaultProcessIdleExecutor) {
        this.f6667b = defaultProcessIdleExecutor;
    }

    final void m6376a() {
        this.f6670e++;
    }

    final void m6378b() {
        this.f6670e--;
        if (this.f6670e == 0 && this.f6671f) {
            m6377a(this.f6672g, "resume recompute");
            this.f6671f = false;
        }
    }

    public final void m6377a(Urgency urgency, String str) {
        Preconditions.checkNotNull(urgency);
        if (this.f6670e > 0) {
            this.f6671f = true;
            this.f6672g = m6373a(this.f6672g, urgency);
            return;
        }
        this.f6672g = null;
        if (urgency.ordinal() < Urgency.OTHER.ordinal()) {
            m6375c(this);
        } else if (this.f6673h == null) {
            this.f6673h = this.f6667b.a(this.f6668c);
        }
    }

    public static void m6375c(ThreadListFragmentUpdateOrchestrator threadListFragmentUpdateOrchestrator) {
        if (threadListFragmentUpdateOrchestrator.f6673h != null) {
            threadListFragmentUpdateOrchestrator.f6673h.cancel(false);
            threadListFragmentUpdateOrchestrator.f6673h = null;
        }
        if (threadListFragmentUpdateOrchestrator.f6669d != null) {
            threadListFragmentUpdateOrchestrator.f6669d.run();
        }
    }

    private static Urgency m6373a(Urgency urgency, Urgency urgency2) {
        if (urgency == null || urgency2 == null) {
            if (urgency != null) {
                return urgency;
            }
            if (urgency2 != null) {
                return urgency2;
            }
            return null;
        } else if (urgency.ordinal() < urgency2.ordinal()) {
            return urgency;
        } else {
            return urgency2;
        }
    }
}
