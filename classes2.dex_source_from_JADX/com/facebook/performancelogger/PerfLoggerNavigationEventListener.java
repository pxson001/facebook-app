package com.facebook.performancelogger;

import android.content.Context;
import android.content.Intent;
import com.facebook.analytics.tagging.NavigationEventListener;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.collect.ImmutableSet;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: qp_eligibility_waterfall */
public class PerfLoggerNavigationEventListener implements NavigationEventListener {
    private static ImmutableSet<String> f8483a = ImmutableSet.of("login_screen");
    private static volatile PerfLoggerNavigationEventListener f8484e;
    private final PerformanceLogger f8485b;
    private final BaseFbBroadcastManager f8486c;
    private SelfRegistrableReceiverImpl f8487d = this.f8486c.m2951a().mo506a(AppStateManager.f1111c, new C03701(this)).mo503a();

    /* compiled from: qp_eligibility_waterfall */
    class C03701 implements ActionReceiver {
        final /* synthetic */ PerfLoggerNavigationEventListener f8488a;

        C03701(PerfLoggerNavigationEventListener perfLoggerNavigationEventListener) {
            this.f8488a = perfLoggerNavigationEventListener;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1919778851);
            this.f8488a.mo1751a(null, "user_left_app", null);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -759679979, a);
        }
    }

    public static com.facebook.performancelogger.PerfLoggerNavigationEventListener m13041a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8484e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.performancelogger.PerfLoggerNavigationEventListener.class;
        monitor-enter(r1);
        r0 = f8484e;	 Catch:{ all -> 0x003a }
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
        r0 = m13042b(r0);	 Catch:{ all -> 0x0035 }
        f8484e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8484e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.performancelogger.PerfLoggerNavigationEventListener.a(com.facebook.inject.InjectorLike):com.facebook.performancelogger.PerfLoggerNavigationEventListener");
    }

    private static PerfLoggerNavigationEventListener m13042b(InjectorLike injectorLike) {
        return new PerfLoggerNavigationEventListener(DelegatingPerformanceLogger.m2803a(injectorLike), LocalFbBroadcastManager.m2946a(injectorLike));
    }

    @Inject
    public PerfLoggerNavigationEventListener(PerformanceLogger performanceLogger, BaseFbBroadcastManager baseFbBroadcastManager) {
        this.f8485b = performanceLogger;
        this.f8486c = baseFbBroadcastManager;
        this.f8487d.m3296b();
    }

    public final void mo1751a(@Nullable String str, @Nullable String str2, @Nullable Map<String, ?> map) {
        if (str2 != null && str2 != "unknown" && !f8483a.contains(str2)) {
            this.f8485b.mo383a(str2);
        }
    }
}
