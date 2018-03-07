package com.facebook.analytics2.logger;

import android.content.Context;
import android.os.HandlerThread;
import android.util.SparseArray;
import com.facebook.analytics2.logger.UploadJobHandler.InvocationParams;
import com.facebook.analytics2.logger.UploadJobHandler.UploadJobHandlerCallback;
import com.facebook.infer.annotation.Assertions;
import java.util.ArrayDeque;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: tertiary_text */
class UploadJobHandlerManager {
    @GuardedBy("this")
    public final SparseArray<JobState> f2064a = new SparseArray(2);
    private final Context f2065b;

    /* compiled from: tertiary_text */
    public class JobState {
        public UploadJobHandler f2059a;
        private ArrayDeque<Runnable> f2060b;

        public final UploadJobHandler m2762a() {
            return this.f2059a;
        }

        public final void m2763a(UploadJobHandler uploadJobHandler) {
            this.f2059a = uploadJobHandler;
        }

        @Nullable
        public final void m2765b() {
            this.f2059a = null;
            if (this.f2060b != null) {
                Runnable runnable = (Runnable) this.f2060b.poll();
                if (runnable != null) {
                    runnable.run();
                }
            }
        }

        public final void m2764a(Runnable runnable) {
            if (this.f2060b == null) {
                this.f2060b = new ArrayDeque();
            }
            this.f2060b.offer(runnable);
        }
    }

    /* compiled from: tertiary_text */
    class JobStateManagementCallback implements UploadJobHandlerCallback {
        final /* synthetic */ UploadJobHandlerManager f2061a;
        private final int f2062b;
        private final UploadJobHandlerCallback f2063c;

        public JobStateManagementCallback(UploadJobHandlerManager uploadJobHandlerManager, int i, UploadJobHandlerCallback uploadJobHandlerCallback) {
            this.f2061a = uploadJobHandlerManager;
            this.f2062b = i;
            this.f2063c = uploadJobHandlerCallback;
        }

        public final void mo504a(boolean z) {
            Integer.valueOf(this.f2062b);
            this.f2063c.mo504a(z);
        }

        public final void mo503a() {
            Integer.valueOf(this.f2062b);
            synchronized (this.f2061a) {
                JobState jobState = (JobState) this.f2061a.f2064a.get(this.f2062b);
                if (jobState == null || jobState.m2762a() == null) {
                    throw new IllegalStateException("There was not a running job when onExit was called");
                }
                jobState.m2763a(null);
                jobState.m2765b();
                this.f2063c.mo503a();
            }
        }
    }

    public UploadJobHandlerManager(Context context) {
        this.f2065b = context;
    }

    public final synchronized boolean m2773a(InvocationParams invocationParams, UploadJobHandlerCallback uploadJobHandlerCallback) {
        return m2770a(invocationParams, (JobState) this.f2064a.get(invocationParams.f2042a), uploadJobHandlerCallback);
    }

    private synchronized boolean m2770a(InvocationParams invocationParams, @Nullable JobState jobState, UploadJobHandlerCallback uploadJobHandlerCallback) {
        boolean z;
        if ((jobState != null ? jobState.m2762a() : null) != null) {
            z = false;
        } else {
            m2771c(this, invocationParams, uploadJobHandlerCallback);
            z = true;
        }
        return z;
    }

    public final synchronized void m2774b(final InvocationParams invocationParams, final UploadJobHandlerCallback uploadJobHandlerCallback) {
        JobState jobState = (JobState) this.f2064a.get(invocationParams.f2042a);
        if (!m2770a(invocationParams, jobState, uploadJobHandlerCallback)) {
            ((JobState) Assertions.b(jobState)).m2764a(new Runnable(this) {
                final /* synthetic */ UploadJobHandlerManager f2058c;

                public void run() {
                    UploadJobHandlerManager.m2771c(this.f2058c, invocationParams, uploadJobHandlerCallback);
                }
            });
        }
    }

    public final synchronized void m2772a(int i) {
        JobState jobState = (JobState) this.f2064a.get(i);
        UploadJobHandler a = jobState != null ? jobState.m2762a() : null;
        if (a != null) {
            a.m2760c();
        }
    }

    public static synchronized void m2771c(UploadJobHandlerManager uploadJobHandlerManager, InvocationParams invocationParams, UploadJobHandlerCallback uploadJobHandlerCallback) {
        synchronized (uploadJobHandlerManager) {
            uploadJobHandlerManager.m2769a(invocationParams, new JobStateManagementCallback(uploadJobHandlerManager, invocationParams.f2042a, uploadJobHandlerCallback));
        }
    }

    private synchronized UploadJobHandler m2768a(HandlerThreadFactory handlerThreadFactory, int i, InvocationParams invocationParams, UploadJobHandlerCallback uploadJobHandlerCallback) {
        UploadJobHandler a;
        if (this.f2064a.get(i) == null || ((JobState) this.f2064a.get(i)).m2762a() == null) {
            HandlerThread a2 = handlerThreadFactory.a("UploadJobHandlerManager-" + i);
            a2.start();
            a = UploadJobHandlerFactory.m2761a(this.f2065b, a2.getLooper(), invocationParams, uploadJobHandlerCallback);
            JobState jobState = (JobState) this.f2064a.get(i);
            if (jobState == null) {
                jobState = new JobState();
                this.f2064a.put(i, jobState);
            }
            jobState.m2763a(a);
        } else {
            throw new IllegalStateException("Trying to create a new handler when one already exists for jobId: " + String.valueOf(i));
        }
        return a;
    }

    private synchronized void m2769a(InvocationParams invocationParams, JobStateManagementCallback jobStateManagementCallback) {
        m2768a(ContextConstructorHelper.a(this.f2065b).b(invocationParams.f2043b.c()), invocationParams.f2042a, invocationParams, jobStateManagementCallback).m2758a();
    }
}
