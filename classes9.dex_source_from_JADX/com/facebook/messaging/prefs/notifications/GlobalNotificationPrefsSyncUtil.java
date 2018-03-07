package com.facebook.messaging.prefs.notifications;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.NamedRunnable;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.threads.NotificationSetting;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.annotations.VisibleForTesting;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: device_received */
public class GlobalNotificationPrefsSyncUtil {
    private static final Class<?> f16317a = GlobalNotificationPrefsSyncUtil.class;
    private static volatile GlobalNotificationPrefsSyncUtil f16318e;
    private final Context f16319b;
    private final FbSharedPreferences f16320c;
    private final ExecutorService f16321d;

    public static com.facebook.messaging.prefs.notifications.GlobalNotificationPrefsSyncUtil m16387a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f16318e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.prefs.notifications.GlobalNotificationPrefsSyncUtil.class;
        monitor-enter(r1);
        r0 = f16318e;	 Catch:{ all -> 0x003a }
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
        r0 = m16388b(r0);	 Catch:{ all -> 0x0035 }
        f16318e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f16318e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.prefs.notifications.GlobalNotificationPrefsSyncUtil.a(com.facebook.inject.InjectorLike):com.facebook.messaging.prefs.notifications.GlobalNotificationPrefsSyncUtil");
    }

    private static GlobalNotificationPrefsSyncUtil m16388b(InjectorLike injectorLike) {
        return new GlobalNotificationPrefsSyncUtil((Context) injectorLike.getInstance(Context.class), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public GlobalNotificationPrefsSyncUtil(Context context, FbSharedPreferences fbSharedPreferences, ExecutorService executorService) {
        this.f16319b = context;
        this.f16320c = fbSharedPreferences;
        this.f16321d = executorService;
    }

    public final void m16391a() {
        ExecutorDetour.a(this.f16321d, new NamedRunnable(this, f16317a, "synchronizeAfterClientChange") {
            final /* synthetic */ GlobalNotificationPrefsSyncUtil f16315c;

            public void run() {
                this.f16315c.m16393c();
            }
        }, 1974573901);
    }

    public final void m16392b() {
        ExecutorDetour.a(this.f16321d, new NamedRunnable(this, f16317a, "synchronizeAfterServerChange") {
            final /* synthetic */ GlobalNotificationPrefsSyncUtil f16316c;

            public void run() {
                this.f16316c.m16394d();
            }
        }, -529295381);
    }

    @VisibleForTesting
    final void m16393c() {
        Intent intent = new Intent(this.f16319b, NotificationPrefsSyncService.class);
        intent.setAction("NotificationsPrefsService.SYNC_GLOBAL_FROM_CLIENT");
        this.f16319b.startService(intent);
    }

    @VisibleForTesting
    final void m16394d() {
        if (m16395e().m16422a()) {
            Intent intent = new Intent(this.f16319b, NotificationPrefsSyncService.class);
            intent.setAction("NotificationsPrefsService.SYNC_GLOBAL_FROM_SERVER");
            this.f16319b.startService(intent);
        }
    }

    final NotificationSettingDelta m16395e() {
        return new NotificationSettingDelta(m16389f(), m16390g());
    }

    @VisibleForTesting
    private NotificationSetting m16389f() {
        return NotificationSetting.b(this.f16320c.a(MessagingPrefKeys.F, 0));
    }

    @VisibleForTesting
    private NotificationSetting m16390g() {
        return NotificationSetting.b(this.f16320c.a(MessagingPrefKeys.av, 0));
    }
}
