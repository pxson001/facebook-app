package com.facebook.analytics;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.view.WindowManager;
import com.facebook.analytics.ConnectionStatusLogger.C03722;
import com.facebook.analytics.ConnectionStatusLogger.C03733;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.util.AnalyticsDeviceUtils;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.common.android.WindowManagerMethodAutoProvider;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.content.DynamicSecureBroadcastReceiver;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: qrcodelogin/?info={%s} */
public class AnalyticsActivityListener {
    private static volatile AnalyticsActivityListener f8457f;
    private final AnalyticsLogger f8458a;
    public final WindowManager f8459b;
    private final Lazy<AnalyticsDeviceUtils> f8460c;
    private final ConnectionStatusLogger f8461d;
    public final NavigationLogger f8462e;

    public static com.facebook.analytics.AnalyticsActivityListener m13016a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8457f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.AnalyticsActivityListener.class;
        monitor-enter(r1);
        r0 = f8457f;	 Catch:{ all -> 0x003a }
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
        r0 = m13017b(r0);	 Catch:{ all -> 0x0035 }
        f8457f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8457f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.AnalyticsActivityListener.a(com.facebook.inject.InjectorLike):com.facebook.analytics.AnalyticsActivityListener");
    }

    private static AnalyticsActivityListener m13017b(InjectorLike injectorLike) {
        return new AnalyticsActivityListener(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), WindowManagerMethodAutoProvider.m8708b(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 202), ConnectionStatusLogger.m12202a(injectorLike), NavigationLogger.m5475a(injectorLike));
    }

    @Inject
    public AnalyticsActivityListener(AnalyticsLogger analyticsLogger, WindowManager windowManager, Lazy<AnalyticsDeviceUtils> lazy, ConnectionStatusLogger connectionStatusLogger, NavigationLogger navigationLogger) {
        this.f8458a = analyticsLogger;
        this.f8459b = windowManager;
        this.f8460c = lazy;
        this.f8461d = connectionStatusLogger;
        this.f8462e = navigationLogger;
    }

    public final void m13018a(Activity activity) {
        this.f8462e.m5516b(activity);
        if (!(activity instanceof ManualAnalyticsNavigationActivity)) {
            this.f8462e.m5498a(null);
        }
        this.f8461d.m12207a((Context) activity);
        ConnectionStatusLogger connectionStatusLogger = this.f8461d;
        Context applicationContext = activity.getApplicationContext();
        if (connectionStatusLogger.f7639j == null && connectionStatusLogger.f7638i == null) {
            connectionStatusLogger.f7639j = new DynamicSecureBroadcastReceiver("android.net.conn.CONNECTIVITY_CHANGE", new C03722(connectionStatusLogger));
            applicationContext.registerReceiver(connectionStatusLogger.f7639j, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            if (((Boolean) connectionStatusLogger.f7633d.get()).booleanValue()) {
                connectionStatusLogger.f7638i = ((BaseFbBroadcastManager) connectionStatusLogger.f7631b.get()).m2951a().mo506a(FbDataConnectionManager.f1876a, new C03733(connectionStatusLogger)).mo503a();
                connectionStatusLogger.f7638i.m3296b();
            }
        }
        this.f8462e.m5500a(this.f8459b.getDefaultDisplay().getRotation(), true);
    }
}
