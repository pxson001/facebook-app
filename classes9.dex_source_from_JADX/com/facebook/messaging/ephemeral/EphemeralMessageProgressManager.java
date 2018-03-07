package com.facebook.messaging.ephemeral;

import com.facebook.common.executors.ForUiThread;
import com.facebook.common.time.SystemClock;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.orca.threadview.MessageItemView.21;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;

@ThreadSafe
/* compiled from: mTransactionId */
public class EphemeralMessageProgressManager {
    @ForUiThread
    ScheduledExecutorService f11017a;
    private EphemeralProgressUtil f11018b;
    private final Set<EphemeralMessageProgressListener> f11019c = new HashSet();
    public Message f11020d;
    private ScheduledFuture f11021e;

    /* compiled from: mTransactionId */
    class C12171 implements Runnable {
        final /* synthetic */ EphemeralMessageProgressManager f11016a;

        C12171(EphemeralMessageProgressManager ephemeralMessageProgressManager) {
            this.f11016a = ephemeralMessageProgressManager;
        }

        public void run() {
            EphemeralMessageProgressManager.m11430a(this.f11016a, this, EphemeralProgressUtil.b(this.f11016a.f11020d));
            EphemeralMessageProgressManager.m11431c(this.f11016a);
        }
    }

    @Inject
    public EphemeralMessageProgressManager(EphemeralProgressUtil ephemeralProgressUtil, ScheduledExecutorService scheduledExecutorService) {
        this.f11018b = ephemeralProgressUtil;
        this.f11017a = scheduledExecutorService;
    }

    public final synchronized void m11434a(21 21) {
        this.f11019c.add(21);
    }

    public final synchronized void m11432a() {
        this.f11019c.clear();
    }

    public final synchronized void m11433a(Message message) {
        if ((this.f11020d == null || !message.a.equals(this.f11020d.a)) && MessageUtil.V(message)) {
            m11435b();
            this.f11020d = message;
            m11430a(this, new C12171(this), SystemClock.b().a() % 1000);
        }
    }

    public static synchronized void m11430a(EphemeralMessageProgressManager ephemeralMessageProgressManager, Runnable runnable, long j) {
        synchronized (ephemeralMessageProgressManager) {
            ephemeralMessageProgressManager.f11021e = ephemeralMessageProgressManager.f11017a.schedule(runnable, j, TimeUnit.MILLISECONDS);
        }
    }

    public static synchronized void m11431c(EphemeralMessageProgressManager ephemeralMessageProgressManager) {
        synchronized (ephemeralMessageProgressManager) {
            int a = ephemeralMessageProgressManager.f11018b.a(ephemeralMessageProgressManager.f11020d);
            for (21 a2 : ephemeralMessageProgressManager.f11019c) {
                a2.a(a);
            }
            if (a == 0) {
                ephemeralMessageProgressManager.f11021e.cancel(false);
            }
        }
    }

    public final synchronized void m11435b() {
        if (this.f11021e != null) {
            this.f11021e.cancel(false);
            this.f11021e = null;
            this.f11020d = null;
        }
    }
}
