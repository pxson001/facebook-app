package com.facebook.common.hardware;

import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import com.facebook.common.executors.C0061x63d21d68;
import com.facebook.common.executors.NamedRunnable;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.base.Preconditions;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: notif_graphql_id */
public class NetworkActivityBroadcastManager {
    public static final String f12145a = (f12147c.getName() + ".NETWORKING_ACTIVE");
    public static final String f12146b = (f12147c.getName() + ".NETWORKING_INACTIVE");
    private static final Class<?> f12147c = NetworkActivityBroadcastManager.class;
    private static volatile NetworkActivityBroadcastManager f12148l;
    private final Context f12149d;
    public final ScheduledExecutorService f12150e;
    public final Object f12151f = new Object();
    private long f12152g;
    public Future f12153h;
    public Future f12154i;
    private final Runnable f12155j = new NamedRunnable(this, f12147c, "ActiveRadioRunner") {
        final /* synthetic */ NetworkActivityBroadcastManager f12157c;

        public void run() {
            synchronized (this.f12157c.f12151f) {
                if (!(this.f12157c.f12153h == null || this.f12157c.f12153h.isCancelled())) {
                    NetworkActivityBroadcastManager.m17857a(this.f12157c, NetworkActivityBroadcastManager.f12145a);
                    this.f12157c.f12153h = this.f12157c.f12150e.schedule(this, 60000, TimeUnit.MILLISECONDS);
                }
            }
        }
    };
    private final Runnable f12156k = new NamedRunnable(this, f12147c, "InactiveRadioRunner") {
        final /* synthetic */ NetworkActivityBroadcastManager f12158c;

        public void run() {
            synchronized (this.f12158c.f12151f) {
                if (!(this.f12158c.f12154i == null || this.f12158c.f12154i.isCancelled())) {
                    NetworkActivityBroadcastManager.m17857a(this.f12158c, NetworkActivityBroadcastManager.f12146b);
                    this.f12158c.f12154i = null;
                    Preconditions.checkNotNull(this.f12158c.f12153h, "Internal inconsistency managing intent futures");
                    this.f12158c.f12153h.cancel(false);
                    this.f12158c.f12153h = null;
                }
            }
        }
    };

    public static com.facebook.common.hardware.NetworkActivityBroadcastManager m17855a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f12148l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.hardware.NetworkActivityBroadcastManager.class;
        monitor-enter(r1);
        r0 = f12148l;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m17858b(r0);	 Catch:{ all -> 0x0035 }
        f12148l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12148l;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.hardware.NetworkActivityBroadcastManager.a(com.facebook.inject.InjectorLike):com.facebook.common.hardware.NetworkActivityBroadcastManager");
    }

    private static NetworkActivityBroadcastManager m17858b(InjectorLike injectorLike) {
        return new NetworkActivityBroadcastManager((Context) injectorLike.getInstance(Context.class), C0061x63d21d68.m2106b(injectorLike));
    }

    @Inject
    public NetworkActivityBroadcastManager(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f12149d = context;
        this.f12150e = scheduledExecutorService;
    }

    public final void m17860a() {
        synchronized (this.f12151f) {
            long j = this.f12152g + 1;
            this.f12152g = j;
            if (j != 1) {
                Preconditions.checkNotNull(this.f12153h, "Internal inconsistency managing intent futures");
            } else if (this.f12154i != null) {
                Preconditions.checkNotNull(this.f12153h);
                this.f12154i.cancel(false);
                this.f12154i = null;
            } else if (this.f12153h == null) {
                this.f12153h = ExecutorDetour.a(this.f12150e, this.f12155j, 1358261395);
            }
        }
    }

    public final void m17861b() {
        boolean z = true;
        synchronized (this.f12151f) {
            Preconditions.checkState(this.f12152g > 0, "Imbalanced activate/inactivate calls");
            if (this.f12154i != null) {
                z = false;
            }
            Preconditions.checkState(z, "Internal inconsistency managing intent futures");
            long j = this.f12152g - 1;
            this.f12152g = j;
            if (j == 0) {
                this.f12154i = this.f12150e.schedule(this.f12156k, 2000, TimeUnit.MILLISECONDS);
            }
        }
    }

    public static void m17857a(NetworkActivityBroadcastManager networkActivityBroadcastManager, String str) {
        Intent intent = new Intent(str);
        intent.putExtra("pid", Binder.getCallingPid());
        networkActivityBroadcastManager.f12149d.sendBroadcast(intent);
    }
}
