package com.facebook.messaging.captiveportal;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat$Builder;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.android.NotificationManagerMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.init.INeedInit;
import com.facebook.common.netchecker.NetCheckState;
import com.facebook.common.netchecker.NetChecker;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.notify.SafeNotificationManager;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: is_network_available */
public class CaptivePortalNotificationManager implements INeedInit {
    private static volatile CaptivePortalNotificationManager f9943h;
    private final Context f9944a;
    private final BaseFbBroadcastManager f9945b;
    private final NetChecker f9946c;
    private final CaptivePortalUtil f9947d;
    public final SafeNotificationManager f9948e;
    public final DefaultAndroidThreadUtil f9949f;
    public final AbstractFbErrorReporter f9950g;

    /* compiled from: is_network_available */
    class C04521 implements ActionReceiver {
        final /* synthetic */ CaptivePortalNotificationManager f9956a;

        C04521(CaptivePortalNotificationManager captivePortalNotificationManager) {
            this.f9956a = captivePortalNotificationManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1613341039);
            CaptivePortalNotificationManager.m10326a(this.f9956a);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1262755520, a);
        }
    }

    public static com.facebook.messaging.captiveportal.CaptivePortalNotificationManager m10325a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9943h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.captiveportal.CaptivePortalNotificationManager.class;
        monitor-enter(r1);
        r0 = f9943h;	 Catch:{ all -> 0x003a }
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
        r0 = m10327b(r0);	 Catch:{ all -> 0x0035 }
        f9943h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9943h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.captiveportal.CaptivePortalNotificationManager.a(com.facebook.inject.InjectorLike):com.facebook.messaging.captiveportal.CaptivePortalNotificationManager");
    }

    private static CaptivePortalNotificationManager m10327b(InjectorLike injectorLike) {
        return new CaptivePortalNotificationManager((Context) injectorLike.getInstance(Context.class), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), NetChecker.m8781a(injectorLike), CaptivePortalUtil.m10328a(injectorLike), new SafeNotificationManager(NotificationManagerMethodAutoProvider.m8723b(injectorLike)), DefaultAndroidThreadUtil.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public CaptivePortalNotificationManager(Context context, BaseFbBroadcastManager baseFbBroadcastManager, NetChecker netChecker, CaptivePortalUtil captivePortalUtil, SafeNotificationManager safeNotificationManager, DefaultAndroidThreadUtil defaultAndroidThreadUtil, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f9944a = context;
        this.f9945b = baseFbBroadcastManager;
        this.f9946c = netChecker;
        this.f9947d = captivePortalUtil;
        this.f9948e = safeNotificationManager;
        this.f9949f = defaultAndroidThreadUtil;
        this.f9950g = abstractFbErrorReporter;
    }

    public void init() {
        this.f9945b.a().a("com.facebook.common.netchecker.ACTION_NETCHECK_STATE_CHANGED", new C04521(this)).a().b();
        m10326a(this);
    }

    public static void m10326a(CaptivePortalNotificationManager captivePortalNotificationManager) {
        if (captivePortalNotificationManager.f9946c.f8536m == NetCheckState.CAPTIVE_PORTAL) {
            PendingIntent activity = PendingIntent.getActivity(captivePortalNotificationManager.f9944a, 0, new Intent("android.intent.action.VIEW", captivePortalNotificationManager.f9947d.m10330a()), 0);
            NotificationCompat$Builder a = new NotificationCompat$Builder(captivePortalNotificationManager.f9944a).m2a(2130842225);
            a.f12j = 0;
            a = a;
            a.f6d = activity;
            Notification c = a.m6a(0).m13a(captivePortalNotificationManager.f9944a.getString(2131231846)).m19b(captivePortalNotificationManager.f9944a.getString(2131231844)).m21c();
            if (captivePortalNotificationManager.f9948e.m10331a(10011)) {
                captivePortalNotificationManager.f9948e.m10332a(10011, c);
                return;
            } else {
                captivePortalNotificationManager.f9949f.a(new 3(captivePortalNotificationManager, c), 3000);
                return;
            }
        }
        if (!captivePortalNotificationManager.f9948e.m10331a(10011)) {
            captivePortalNotificationManager.f9949f.a(new 2(captivePortalNotificationManager), 3000);
        }
    }
}
