package com.facebook.crudolib.dbquery.loader.inprocess;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.MainThread;
import android.support.annotation.WorkerThread;
import android.support.v4.content.Loader;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: ccu_upload_success */
public abstract class ExecutorLoader<D> extends Loader<D> {
    public final ExecutorService f17858a;
    public final Handler f17859b = new Handler(Looper.getMainLooper());
    @GuardedBy("@MainThread")
    public InvocationState<D> f17860c;

    /* compiled from: ccu_upload_success */
    public class InvocationState<DATA> {
        public Future<?> f17851a;
        public volatile Runnable f17852b;
        public volatile DATA f17853c;
    }

    /* compiled from: ccu_upload_success */
    public class LoadRunnable implements Runnable {
        final /* synthetic */ ExecutorLoader f17854a;
        private final InvocationState f17855b;

        public LoadRunnable(ExecutorLoader executorLoader, InvocationState<D> invocationState) {
            this.f17854a = executorLoader;
            this.f17855b = invocationState;
        }

        public void run() {
            this.f17855b.f17853c = this.f17854a.mo1382b();
            this.f17855b.f17852b = new PostResultRunnable(this.f17854a, this.f17855b);
            HandlerDetour.a(this.f17854a.f17859b, this.f17855b.f17852b, -1038374878);
        }
    }

    /* compiled from: ccu_upload_success */
    class PostResultRunnable implements Runnable {
        final /* synthetic */ ExecutorLoader f17856a;
        private final InvocationState<D> f17857b;

        public PostResultRunnable(ExecutorLoader executorLoader, InvocationState<D> invocationState) {
            this.f17856a = executorLoader;
            this.f17857b = invocationState;
        }

        public void run() {
            ExecutorLoader executorLoader = this.f17856a;
            InvocationState invocationState = this.f17857b;
            if (executorLoader.f17860c != invocationState) {
                executorLoader.mo1381a(invocationState.f17853c);
            } else if (executorLoader.q) {
                executorLoader.mo1381a(invocationState.f17853c);
            } else {
                executorLoader.u();
                executorLoader.f17860c = null;
                executorLoader.b(invocationState.f17853c);
            }
        }
    }

    @WorkerThread
    protected abstract D mo1382b();

    public ExecutorLoader(Context context, ExecutorService executorService) {
        super(context);
        this.f17858a = executorService;
    }

    @MainThread
    protected final void m21701a() {
        super.a();
        m21704c();
        this.f17860c = new InvocationState();
        this.f17860c.f17851a = ExecutorDetour.a(this.f17858a, new LoadRunnable(this, this.f17860c), -760757227);
    }

    @MainThread
    public final boolean m21704c() {
        if (this.f17860c == null) {
            return false;
        }
        boolean cancel = this.f17860c.f17851a.cancel(false);
        this.f17860c = null;
        return cancel;
    }

    @MainThread
    public void mo1381a(D d) {
    }
}
