package com.facebook.messaging.prefs.notifications;

import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.init.INeedInitForSharedPrefsListenerRegistration;
import com.facebook.prefs.shared.init.INeedInitForSharedPrefsListenerRegistration.PrefKeyMatchType;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: title_truncated */
public class C0173x9f86acd4 extends INeedInitForSharedPrefsListenerRegistration<NotificationPrefsWatcher> {
    private static volatile C0173x9f86acd4 f2536b;

    public static com.facebook.messaging.prefs.notifications.C0173x9f86acd4 m4702a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2536b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.prefs.notifications.C0173x9f86acd4.class;
        monitor-enter(r1);
        r0 = f2536b;	 Catch:{ all -> 0x003a }
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
        r0 = com.facebook.messaging.prefs.notifications.C0173x9f86acd4.m4703b(r0);	 Catch:{ all -> 0x0035 }
        f2536b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2536b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.prefs.notifications.NotificationPrefsWatcher$NotificationPrefsWatcherSharedPrefsListenerRegistration.a(com.facebook.inject.InjectorLike):com.facebook.messaging.prefs.notifications.NotificationPrefsWatcher$NotificationPrefsWatcherSharedPrefsListenerRegistration");
    }

    private static C0173x9f86acd4 m4703b(InjectorLike injectorLike) {
        return new C0173x9f86acd4(IdBasedSingletonScopeProvider.m1810b(injectorLike, 8301));
    }

    protected final void mo667a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey, Object obj) {
        NotificationPrefsWatcher.a((NotificationPrefsWatcher) obj, prefKey);
    }

    @Inject
    public C0173x9f86acd4(Lazy<NotificationPrefsWatcher> lazy) {
        super(lazy, MessagingPrefKeys.f2540D, PrefKeyMatchType.PREFIX);
    }
}
