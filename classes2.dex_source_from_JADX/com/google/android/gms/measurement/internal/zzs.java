package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.facebook.tools.dextr.runtime.detour.ObjectDetour;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznl;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

public class zzs extends zzw {
    public zzc f263a;
    public zzc f264b;
    private final BlockingQueue<FutureTask<?>> f265c = new LinkedBlockingQueue();
    private final BlockingQueue<FutureTask<?>> f266d = new LinkedBlockingQueue();
    private final UncaughtExceptionHandler f267e = new zzb(this, "Thread death: Uncaught exception on worker thread");
    private final UncaughtExceptionHandler f268f = new zzb(this, "Thread death: Uncaught exception on network thread");
    public final Object f269h = new Object();
    public final Semaphore f270i = new Semaphore(2);
    public volatile boolean f271j;

    final class zzb implements UncaughtExceptionHandler {
        final /* synthetic */ zzs f272a;
        private final String f273b;

        public zzb(zzs com_google_android_gms_measurement_internal_zzs, String str) {
            this.f272a = com_google_android_gms_measurement_internal_zzs;
            zzx.m104a((Object) str);
            this.f273b = str;
        }

        public final synchronized void uncaughtException(Thread thread, Throwable th) {
            this.f272a.mo35l().m335b().m356a(this.f273b, th);
        }
    }

    final class zza<V> extends FutureTask<V> {
        final /* synthetic */ zzs f276a;
        private final String f277b;

        zza(zzs com_google_android_gms_measurement_internal_zzs, Runnable runnable, String str) {
            this.f276a = com_google_android_gms_measurement_internal_zzs;
            super(runnable, null);
            zzx.m104a((Object) str);
            this.f277b = str;
        }

        protected final void setException(Throwable th) {
            this.f276a.mo35l().f203d.m356a(this.f277b, th);
            super.setException(th);
        }
    }

    final class zzc extends Thread {
        final /* synthetic */ zzs f278a;
        private final Object f279b = new Object();
        private final BlockingQueue<FutureTask<?>> f280c;

        public zzc(zzs com_google_android_gms_measurement_internal_zzs, String str, BlockingQueue<FutureTask<?>> blockingQueue) {
            this.f278a = com_google_android_gms_measurement_internal_zzs;
            zzx.m104a((Object) str);
            this.f280c = blockingQueue;
            setName(str);
        }

        private void m570a(InterruptedException interruptedException) {
            this.f278a.mo35l().f206h.m356a(getName() + " was interrupted", interruptedException);
        }

        public final void m571a() {
            synchronized (this.f279b) {
                ObjectDetour.c(this.f279b, -271886311);
            }
        }

        public final void run() {
            while (true) {
                FutureTask futureTask = (FutureTask) this.f280c.poll();
                if (futureTask == null) {
                    synchronized (this.f279b) {
                        if (this.f280c.peek() == null && !this.f278a.f271j) {
                            try {
                                ObjectDetour.a(this.f279b, 30000, -516925036);
                            } catch (InterruptedException e) {
                                m570a(e);
                            }
                        }
                    }
                    synchronized (this.f278a.f269h) {
                        if (this.f280c.peek() == null) {
                            break;
                        }
                    }
                }
                futureTask.run();
            }
            this.f278a.f270i.release();
            ObjectDetour.c(this.f278a.f269h, 1761583657);
            if (this == this.f278a.f263a) {
                this.f278a.f263a = null;
            } else if (this == this.f278a.f264b) {
                this.f278a.f264b = null;
            } else {
                this.f278a.mo35l().m335b().m355a("Current scheduler thread is neither worker nor network");
            }
        }
    }

    public zzs(zzt com_google_android_gms_measurement_internal_zzt) {
        super(com_google_android_gms_measurement_internal_zzt);
    }

    private void m551a(FutureTask<?> futureTask) {
        synchronized (this.f269h) {
            this.f265c.add(futureTask);
            if (this.f263a == null) {
                this.f263a = new zzc(this, "Measurement Worker", this.f265c);
                this.f263a.setUncaughtExceptionHandler(this.f267e);
                this.f263a.start();
            } else {
                this.f263a.m571a();
            }
        }
    }

    private void m553b(FutureTask<?> futureTask) {
        synchronized (this.f269h) {
            this.f266d.add(futureTask);
            if (this.f264b == null) {
                this.f264b = new zzc(this, "Measurement Network", this.f266d);
                this.f264b.setUncaughtExceptionHandler(this.f268f);
                this.f264b.start();
            } else {
                this.f264b.m571a();
            }
        }
    }

    protected final void mo24a() {
    }

    public final void m555a(Runnable runnable) {
        m303x();
        zzx.m104a((Object) runnable);
        m551a(new zza(this, runnable, "Task exception on worker thread"));
    }

    public final void m556b(Runnable runnable) {
        m303x();
        zzx.m104a((Object) runnable);
        m553b(new zza(this, runnable, "Task exception on network thread"));
    }

    public final /* bridge */ /* synthetic */ void mo26c() {
        super.mo26c();
    }

    public final void mo27d() {
        if (Thread.currentThread() != this.f264b) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public final void mo28e() {
        if (Thread.currentThread() != this.f263a) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public final /* bridge */ /* synthetic */ zzm mo29f() {
        return super.mo29f();
    }

    public final /* bridge */ /* synthetic */ zzz mo30g() {
        return super.mo30g();
    }

    public final /* bridge */ /* synthetic */ zznl mo31h() {
        return super.mo31h();
    }

    public final /* bridge */ /* synthetic */ Context mo32i() {
        return super.mo32i();
    }

    public final /* bridge */ /* synthetic */ zzae mo33j() {
        return super.mo33j();
    }

    public final /* bridge */ /* synthetic */ zzs mo34k() {
        return super.mo34k();
    }

    public final /* bridge */ /* synthetic */ zzo mo35l() {
        return super.mo35l();
    }

    public final /* bridge */ /* synthetic */ zzr mo36m() {
        return super.mo36m();
    }

    public final /* bridge */ /* synthetic */ zzc mo37n() {
        return super.mo37n();
    }
}
