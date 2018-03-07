package com.facebook.http.common.executorimpl.apache;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.facebook.common.android.PowerManagerMethodAutoProvider;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ScheduledExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.wakelock.FbWakeLockManager;
import com.facebook.common.wakelock.FbWakeLockManager.WakeLock;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DynamicSecureBroadcastReceiver;
import com.facebook.http.common.FbHttpModule;
import com.facebook.http.common.HttpParamsMethodAutoProvider;
import com.facebook.http.common.SocketFactory_SslSocketFactoryMethodAutoProvider;
import com.facebook.http.enginehooks.DefaultOpenConnectionEventListenerProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableBiMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.conn.tsccm.AbstractConnPool;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.HttpParams;

@Singleton
@ThreadSafe
/* compiled from: distance_unit */
public class FbClientConnManager extends ThreadSafeClientConnManager {
    private static final Class<?> f4964a = FbClientConnManager.class;
    private static volatile FbClientConnManager f4965n;
    private final Context f4966b;
    private final Clock f4967c;
    private final DefaultAndroidThreadUtil f4968d;
    private final PowerManager f4969e;
    private final FbWakeLockManager f4970f;
    private final boolean f4971g;
    private final ScheduledExecutorService f4972h;
    private final Runnable f4973i = new CloseIdleConnectionsRunnable(this);
    @Nullable
    private final WakeLock f4974j;
    private final DynamicSecureBroadcastReceiver f4975k;
    private final Object f4976l = new Object();
    private long f4977m;

    /* compiled from: distance_unit */
    class CloseIdleConnectionsRunnable implements Runnable {
        final /* synthetic */ FbClientConnManager f4962a;

        public CloseIdleConnectionsRunnable(FbClientConnManager fbClientConnManager) {
            this.f4962a = fbClientConnManager;
        }

        public void run() {
            this.f4962a.m9907b();
        }
    }

    /* compiled from: distance_unit */
    class ScreenOffActionReceiver implements ActionReceiver {
        final /* synthetic */ FbClientConnManager f4963a;

        public ScreenOffActionReceiver(FbClientConnManager fbClientConnManager) {
            this.f4963a = fbClientConnManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 9682169);
            this.f4963a.m9906a();
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 2965332, a);
        }
    }

    public static com.facebook.http.common.executorimpl.apache.FbClientConnManager m9902a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f4965n;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.common.executorimpl.apache.FbClientConnManager.class;
        monitor-enter(r1);
        r0 = f4965n;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m9903b(r0);	 Catch:{ all -> 0x0035 }
        f4965n = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4965n;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.common.executorimpl.apache.FbClientConnManager.a(com.facebook.inject.InjectorLike):com.facebook.http.common.executorimpl.apache.FbClientConnManager");
    }

    private static FbClientConnManager m9903b(InjectorLike injectorLike) {
        return new FbClientConnManager((Context) injectorLike.getInstance(Context.class), HttpParamsMethodAutoProvider.b(injectorLike), FbHttpModule.a(SocketFactory_SslSocketFactoryMethodAutoProvider.m9886b(injectorLike)), (Clock) SystemClockMethodAutoProvider.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), PowerManagerMethodAutoProvider.b(injectorLike), FbWakeLockManager.a(injectorLike), FbHttpModule.f(), ScheduledExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), FbHttpModule.a());
    }

    @Inject
    public FbClientConnManager(Context context, HttpParams httpParams, SchemeRegistry schemeRegistry, Clock clock, DefaultAndroidThreadUtil defaultAndroidThreadUtil, PowerManager powerManager, FbWakeLockManager fbWakeLockManager, Boolean bool, ScheduledExecutorService scheduledExecutorService, DefaultOpenConnectionEventListenerProvider defaultOpenConnectionEventListenerProvider) {
        super(httpParams, schemeRegistry);
        this.f4966b = context;
        this.f4967c = clock;
        this.f4968d = defaultAndroidThreadUtil;
        this.f4969e = powerManager;
        this.f4970f = fbWakeLockManager;
        this.f4971g = bool.booleanValue();
        this.f4972h = scheduledExecutorService;
        ((FbHttpClientConnectionOperator) this.connOperator).f4982b = defaultOpenConnectionEventListenerProvider;
        this.f4974j = this.f4971g ? this.f4970f.a(1, "FbClientConnManager") : null;
        this.f4975k = new DynamicSecureBroadcastReceiver(ImmutableBiMap.b("android.intent.action.SCREEN_OFF", new ScreenOffActionReceiver(this)));
        IntentFilter intentFilter = new IntentFilter();
        for (String addAction : this.f4975k.a()) {
            intentFilter.addAction(addAction);
        }
        this.f4966b.registerReceiver(this.f4975k, intentFilter);
    }

    protected final ClientConnectionOperator createConnectionOperator(SchemeRegistry schemeRegistry) {
        return new FbHttpClientConnectionOperator(schemeRegistry);
    }

    protected final AbstractConnPool createConnectionPool(HttpParams httpParams) {
        return super.createConnectionPool(httpParams);
    }

    public void releaseConnection(ManagedClientConnection managedClientConnection, long j, TimeUnit timeUnit) {
        if (j <= 0) {
            j = 120000;
            timeUnit = TimeUnit.MILLISECONDS;
        }
        try {
            super.releaseConnection(managedClientConnection, j, timeUnit);
            closeExpiredConnections();
        } finally {
            m9904c();
        }
    }

    @VisibleForTesting
    final void m9906a() {
        m9904c();
    }

    @VisibleForTesting
    private void m9904c() {
        if (!this.f4969e.isScreenOn() && m9905d()) {
            synchronized (this.f4976l) {
                if (this.f4967c.a() - this.f4977m > 100) {
                    if (this.f4971g && this.f4974j != null) {
                        this.f4974j.c();
                    }
                    this.f4977m = this.f4967c.a();
                    this.f4972h.schedule(this.f4973i, 1500, TimeUnit.MILLISECONDS);
                }
            }
        }
    }

    @VisibleForTesting
    private boolean m9905d() {
        return getConnectionsInPool() > 0;
    }

    @VisibleForTesting
    final void m9907b() {
        this.f4968d.b();
        synchronized (this.f4976l) {
            try {
                if (!this.f4969e.isScreenOn()) {
                    closeIdleConnections(1300, TimeUnit.MILLISECONDS);
                }
                if (this.f4971g && this.f4974j != null) {
                    this.f4974j.d();
                }
            } catch (Throwable th) {
                if (this.f4971g && this.f4974j != null) {
                    this.f4974j.d();
                }
            }
        }
    }
}
