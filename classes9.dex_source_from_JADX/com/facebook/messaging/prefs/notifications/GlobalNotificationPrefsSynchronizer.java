package com.facebook.messaging.prefs.notifications;

import android.os.Bundle;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.common.executors.ScheduledExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.threads.NotificationSetting;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.messaging.prefs.notifications.NotificationPrefsSyncService.C19272;
import com.facebook.messaging.service.model.SetSettingsParams;
import com.facebook.messaging.service.model.SetSettingsParamsBuilder;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: device_permission_denied */
public class GlobalNotificationPrefsSynchronizer {
    private static Class<?> f16324a = GlobalNotificationPrefsSynchronizer.class;
    private static volatile GlobalNotificationPrefsSynchronizer f16325m;
    private final LoggedInUserSessionManager f16326b;
    private final DefaultBlueServiceOperationFactory f16327c;
    private final FbSharedPreferences f16328d;
    private final GlobalNotificationPrefsSyncUtil f16329e;
    private final ScheduledExecutorService f16330f;
    @GuardedBy("this")
    private OperationFuture f16331g;
    @GuardedBy("this")
    private SetSettingsParamsBuilder f16332h;
    @GuardedBy("this")
    private SetSettingsParams f16333i;
    @GuardedBy("this")
    private long f16334j;
    @GuardedBy("this")
    private int f16335k;
    public volatile C19272 f16336l;

    /* compiled from: device_permission_denied */
    class C19221 implements Runnable {
        final /* synthetic */ GlobalNotificationPrefsSynchronizer f16322a;

        C19221(GlobalNotificationPrefsSynchronizer globalNotificationPrefsSynchronizer) {
            this.f16322a = globalNotificationPrefsSynchronizer;
        }

        public void run() {
            GlobalNotificationPrefsSynchronizer.m16400f(this.f16322a);
        }
    }

    /* compiled from: device_permission_denied */
    class C19232 implements FutureCallback<OperationResult> {
        final /* synthetic */ GlobalNotificationPrefsSynchronizer f16323a;

        C19232(GlobalNotificationPrefsSynchronizer globalNotificationPrefsSynchronizer) {
            this.f16323a = globalNotificationPrefsSynchronizer;
        }

        public void onSuccess(Object obj) {
            GlobalNotificationPrefsSynchronizer.m16401g(this.f16323a);
        }

        public void onFailure(Throwable th) {
            GlobalNotificationPrefsSynchronizer.m16402h(this.f16323a);
        }
    }

    public static com.facebook.messaging.prefs.notifications.GlobalNotificationPrefsSynchronizer m16396a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f16325m;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.prefs.notifications.GlobalNotificationPrefsSynchronizer.class;
        monitor-enter(r1);
        r0 = f16325m;	 Catch:{ all -> 0x003a }
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
        r0 = m16397b(r0);	 Catch:{ all -> 0x0035 }
        f16325m = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f16325m;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.prefs.notifications.GlobalNotificationPrefsSynchronizer.a(com.facebook.inject.InjectorLike):com.facebook.messaging.prefs.notifications.GlobalNotificationPrefsSynchronizer");
    }

    private static GlobalNotificationPrefsSynchronizer m16397b(InjectorLike injectorLike) {
        return new GlobalNotificationPrefsSynchronizer(LoggedInUserSessionManager.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike), GlobalNotificationPrefsSyncUtil.m16387a(injectorLike), ScheduledExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public GlobalNotificationPrefsSynchronizer(LoggedInUserSessionManager loggedInUserSessionManager, FbSharedPreferences fbSharedPreferences, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, GlobalNotificationPrefsSyncUtil globalNotificationPrefsSyncUtil, ScheduledExecutorService scheduledExecutorService) {
        this.f16326b = loggedInUserSessionManager;
        this.f16328d = fbSharedPreferences;
        this.f16327c = defaultBlueServiceOperationFactory;
        this.f16329e = globalNotificationPrefsSyncUtil;
        this.f16330f = scheduledExecutorService;
    }

    final void m16404a() {
        if (this.f16326b.b()) {
            NotificationSettingDelta e = this.f16329e.m16395e();
            synchronized (this) {
                if (this.f16332h != null || e.m16422a()) {
                    NotificationSetting b = NotificationSetting.b(this.f16328d.a(MessagingPrefKeys.F, 0));
                    synchronized (this) {
                        SetSettingsParamsBuilder d = m16398d();
                        d.m17192a(true);
                        d.m17191a(b);
                    }
                    m16403i();
                    return;
                }
            }
        }
    }

    final void m16405b() {
        NotificationSettingDelta e = this.f16329e.m16395e();
        if (e.m16422a()) {
            synchronized (this) {
                if (this.f16333i == null && this.f16332h == null) {
                    Editor edit = this.f16328d.edit();
                    edit.a(MessagingPrefKeys.F, e.f16354b.a());
                    edit.commit();
                }
            }
            m16403i();
        }
    }

    final synchronized boolean m16406c() {
        boolean z;
        z = (this.f16331g == null && this.f16332h == null && this.f16333i == null) ? false : true;
        return z;
    }

    @GuardedBy("this")
    private SetSettingsParamsBuilder m16398d() {
        if (this.f16332h == null) {
            this.f16332h = new SetSettingsParamsBuilder();
            this.f16334j = 4000;
            m16399e();
        }
        return this.f16332h;
    }

    private void m16399e() {
        this.f16330f.schedule(new C19221(this), this.f16334j, TimeUnit.MILLISECONDS);
    }

    public static synchronized void m16400f(GlobalNotificationPrefsSynchronizer globalNotificationPrefsSynchronizer) {
        synchronized (globalNotificationPrefsSynchronizer) {
            if (globalNotificationPrefsSynchronizer.f16332h != null && globalNotificationPrefsSynchronizer.f16326b.b() && globalNotificationPrefsSynchronizer.f16331g == null) {
                globalNotificationPrefsSynchronizer.f16333i = globalNotificationPrefsSynchronizer.f16332h.m17193c();
                globalNotificationPrefsSynchronizer.f16332h = null;
                Bundle bundle = new Bundle();
                bundle.putParcelable("setSettingsParams", globalNotificationPrefsSynchronizer.f16333i);
                globalNotificationPrefsSynchronizer.f16331g = BlueServiceOperationFactoryDetour.a(globalNotificationPrefsSynchronizer.f16327c, "update_user_settings", bundle, -1437392150).a();
                Futures.a(globalNotificationPrefsSynchronizer.f16331g, new C19232(globalNotificationPrefsSynchronizer));
            }
        }
    }

    public static synchronized void m16401g(GlobalNotificationPrefsSynchronizer globalNotificationPrefsSynchronizer) {
        synchronized (globalNotificationPrefsSynchronizer) {
            globalNotificationPrefsSynchronizer.f16331g = null;
            globalNotificationPrefsSynchronizer.f16333i = null;
            globalNotificationPrefsSynchronizer.f16334j = 4000;
            globalNotificationPrefsSynchronizer.f16335k = 0;
            m16400f(globalNotificationPrefsSynchronizer);
            globalNotificationPrefsSynchronizer.m16403i();
        }
    }

    public static synchronized void m16402h(GlobalNotificationPrefsSynchronizer globalNotificationPrefsSynchronizer) {
        synchronized (globalNotificationPrefsSynchronizer) {
            globalNotificationPrefsSynchronizer.f16331g = null;
            if (globalNotificationPrefsSynchronizer.f16332h == null) {
                globalNotificationPrefsSynchronizer.f16332h = new SetSettingsParamsBuilder();
            }
            globalNotificationPrefsSynchronizer.f16332h.m17192a(true);
            globalNotificationPrefsSynchronizer.f16332h.m17191a(globalNotificationPrefsSynchronizer.f16333i.m17190b());
            globalNotificationPrefsSynchronizer.f16333i = null;
            if (((long) globalNotificationPrefsSynchronizer.f16335k) < 5) {
                globalNotificationPrefsSynchronizer.f16335k++;
                globalNotificationPrefsSynchronizer.f16334j = Math.min(2 * globalNotificationPrefsSynchronizer.f16334j, 600000);
                new StringBuilder("Failed to update thread notification settings. Retrying in ").append(globalNotificationPrefsSynchronizer.f16334j / 1000).append(" seconds");
                globalNotificationPrefsSynchronizer.m16399e();
            } else {
                globalNotificationPrefsSynchronizer.f16335k = 0;
                globalNotificationPrefsSynchronizer.f16334j = 4000;
            }
            globalNotificationPrefsSynchronizer.m16403i();
        }
    }

    private void m16403i() {
        C19272 c19272 = this.f16336l;
        if (c19272 != null) {
            c19272.m16408a();
        }
    }
}
