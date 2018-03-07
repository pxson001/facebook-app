package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: mechanism */
public class JobScheduler {
    @GuardedBy("this")
    @VisibleForTesting
    EncodedImage f14636a = null;
    @GuardedBy("this")
    @VisibleForTesting
    boolean f14637b = false;
    @GuardedBy("this")
    @VisibleForTesting
    JobState f14638c = JobState.IDLE;
    @GuardedBy("this")
    @VisibleForTesting
    long f14639d = 0;
    @GuardedBy("this")
    @VisibleForTesting
    long f14640e = 0;
    public final Executor f14641f;
    private final JobRunnable f14642g;
    public final Runnable f14643h = new C06161(this);
    private final Runnable f14644i = new C06172(this);
    private final int f14645j;

    /* compiled from: mechanism */
    public interface JobRunnable {
        void mo2822a(EncodedImage encodedImage, boolean z);
    }

    /* compiled from: mechanism */
    class C06161 implements Runnable {
        final /* synthetic */ JobScheduler f14646a;

        C06161(JobScheduler jobScheduler) {
            this.f14646a = jobScheduler;
        }

        public void run() {
            JobScheduler.m21059e(this.f14646a);
        }
    }

    /* compiled from: mechanism */
    class C06172 implements Runnable {
        final /* synthetic */ JobScheduler f14647a;

        C06172(JobScheduler jobScheduler) {
            this.f14647a = jobScheduler;
        }

        public void run() {
            JobScheduler jobScheduler = this.f14647a;
            ExecutorDetour.a(jobScheduler.f14641f, jobScheduler.f14643h, 1363619221);
        }
    }

    @VisibleForTesting
    /* compiled from: mechanism */
    enum JobState {
        IDLE,
        QUEUED,
        RUNNING,
        RUNNING_AND_PENDING
    }

    /* compiled from: mechanism */
    /* synthetic */ class C07213 {
        static final /* synthetic */ int[] f17871a = new int[JobState.values().length];

        static {
            try {
                f17871a[JobState.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f17871a[JobState.QUEUED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f17871a[JobState.RUNNING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f17871a[JobState.RUNNING_AND_PENDING.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public JobScheduler(Executor executor, JobRunnable jobRunnable, int i) {
        this.f14641f = executor;
        this.f14642g = jobRunnable;
        this.f14645j = i;
    }

    public final void m21061a() {
        EncodedImage encodedImage;
        synchronized (this) {
            encodedImage = this.f14636a;
            this.f14636a = null;
            this.f14637b = false;
        }
        EncodedImage.m15704d(encodedImage);
    }

    public final boolean m21062a(EncodedImage encodedImage, boolean z) {
        if (!m21058b(encodedImage, z)) {
            return false;
        }
        EncodedImage encodedImage2;
        synchronized (this) {
            encodedImage2 = this.f14636a;
            this.f14636a = EncodedImage.m15702a(encodedImage);
            this.f14637b = z;
        }
        EncodedImage.m15704d(encodedImage2);
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m21063b() {
        /*
        r8 = this;
        r1 = 1;
        r0 = 0;
        r4 = android.os.SystemClock.uptimeMillis();
        r2 = 0;
        monitor-enter(r8);
        r6 = r8.f14636a;	 Catch:{ all -> 0x0042 }
        r7 = r8.f14637b;	 Catch:{ all -> 0x0042 }
        r6 = m21058b(r6, r7);	 Catch:{ all -> 0x0042 }
        if (r6 != 0) goto L_0x0015;
    L_0x0013:
        monitor-exit(r8);	 Catch:{ all -> 0x0042 }
    L_0x0014:
        return r0;
    L_0x0015:
        r6 = com.facebook.imagepipeline.producers.JobScheduler.C07213.f17871a;	 Catch:{ all -> 0x0042 }
        r7 = r8.f14638c;	 Catch:{ all -> 0x0042 }
        r7 = r7.ordinal();	 Catch:{ all -> 0x0042 }
        r6 = r6[r7];	 Catch:{ all -> 0x0042 }
        switch(r6) {
            case 1: goto L_0x002b;
            case 2: goto L_0x0022;
            case 3: goto L_0x003d;
            default: goto L_0x0022;
        };	 Catch:{ all -> 0x0042 }
    L_0x0022:
        monitor-exit(r8);	 Catch:{ all -> 0x0042 }
        if (r0 == 0) goto L_0x0029;
    L_0x0025:
        r2 = r2 - r4;
        r8.m21057a(r2);
    L_0x0029:
        r0 = r1;
        goto L_0x0014;
    L_0x002b:
        r2 = r8.f14640e;	 Catch:{  }
        r0 = r8.f14645j;	 Catch:{  }
        r6 = (long) r0;	 Catch:{  }
        r2 = r2 + r6;
        r2 = java.lang.Math.max(r2, r4);	 Catch:{  }
        r8.f14639d = r4;	 Catch:{  }
        r0 = com.facebook.imagepipeline.producers.JobScheduler.JobState.QUEUED;	 Catch:{  }
        r8.f14638c = r0;	 Catch:{  }
        r0 = r1;
        goto L_0x0022;
    L_0x003d:
        r6 = com.facebook.imagepipeline.producers.JobScheduler.JobState.RUNNING_AND_PENDING;	 Catch:{  }
        r8.f14638c = r6;	 Catch:{  }
        goto L_0x0022;
    L_0x0042:
        r0 = move-exception;
        monitor-exit(r8);	 Catch:{  }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.JobScheduler.b():boolean");
    }

    private void m21057a(long j) {
        if (j > 0) {
            if (JobStartExecutorSupplier.a == null) {
                JobStartExecutorSupplier.a = Executors.newSingleThreadScheduledExecutor();
            }
            JobStartExecutorSupplier.a.schedule(this.f14644i, j, TimeUnit.MILLISECONDS);
            return;
        }
        this.f14644i.run();
    }

    public static void m21059e(JobScheduler jobScheduler) {
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (jobScheduler) {
            EncodedImage encodedImage = jobScheduler.f14636a;
            boolean z = jobScheduler.f14637b;
            jobScheduler.f14636a = null;
            jobScheduler.f14637b = false;
            jobScheduler.f14638c = JobState.RUNNING;
            jobScheduler.f14640e = uptimeMillis;
        }
        try {
            if (m21058b(encodedImage, z)) {
                jobScheduler.f14642g.mo2822a(encodedImage, z);
            }
            EncodedImage.m15704d(encodedImage);
            jobScheduler.m21060f();
        } catch (Throwable th) {
            EncodedImage.m15704d(encodedImage);
            jobScheduler.m21060f();
        }
    }

    private void m21060f() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        Object obj = null;
        synchronized (this) {
            if (this.f14638c == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.f14640e + ((long) this.f14645j), uptimeMillis);
                obj = 1;
                this.f14639d = uptimeMillis;
                this.f14638c = JobState.QUEUED;
            } else {
                this.f14638c = JobState.IDLE;
            }
        }
        if (obj != null) {
            m21057a(j - uptimeMillis);
        }
    }

    private static boolean m21058b(EncodedImage encodedImage, boolean z) {
        return z || EncodedImage.m15705e(encodedImage);
    }

    public final synchronized long m21064c() {
        return this.f14640e - this.f14639d;
    }
}
