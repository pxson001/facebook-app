package com.facebook.messaging.prefs.notifications;

import com.facebook.androidcompat.AndroidCompat;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.viewercontext.PushedViewerContext;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.auth.viewercontext.ViewerContext.ViewerContextBuilder;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.prefs.shared.PrefKey;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: device_local_text */
public class NotificationPrefsWatcher {
    private static volatile NotificationPrefsWatcher f16348e;
    private final Provider<ThreadNotificationPrefsSyncUtil> f16349a;
    private final GlobalNotificationPrefsSyncUtil f16350b;
    private final ViewerContextManager f16351c;
    private final Product f16352d;

    public static com.facebook.messaging.prefs.notifications.NotificationPrefsWatcher m16419a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f16348e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.prefs.notifications.NotificationPrefsWatcher.class;
        monitor-enter(r1);
        r0 = f16348e;	 Catch:{ all -> 0x003a }
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
        r0 = m16421b(r0);	 Catch:{ all -> 0x0035 }
        f16348e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f16348e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.prefs.notifications.NotificationPrefsWatcher.a(com.facebook.inject.InjectorLike):com.facebook.messaging.prefs.notifications.NotificationPrefsWatcher");
    }

    private static NotificationPrefsWatcher m16421b(InjectorLike injectorLike) {
        return new NotificationPrefsWatcher(IdBasedProvider.a(injectorLike, 8302), GlobalNotificationPrefsSyncUtil.m16387a(injectorLike), ViewerContextManagerProvider.b(injectorLike), ProductMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public NotificationPrefsWatcher(Provider<ThreadNotificationPrefsSyncUtil> provider, GlobalNotificationPrefsSyncUtil globalNotificationPrefsSyncUtil, ViewerContextManager viewerContextManager, Product product) {
        this.f16349a = provider;
        this.f16350b = globalNotificationPrefsSyncUtil;
        this.f16351c = viewerContextManager;
        this.f16352d = product;
    }

    public static void m16420a(NotificationPrefsWatcher notificationPrefsWatcher, PrefKey prefKey) {
        PushedViewerContext a;
        Throwable th;
        Throwable th2;
        ThreadKey a2 = MessagingPrefKeys.a(prefKey);
        if (a2 != null) {
            if (!ThreadKey.d(a2)) {
                a = notificationPrefsWatcher.m16418a(a2);
                th = null;
                try {
                    ((ThreadNotificationPrefsSyncUtil) notificationPrefsWatcher.f16349a.get()).m16428a(a2);
                    if (a != null) {
                        a.close();
                        return;
                    }
                    return;
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    th3 = th2;
                    th2 = th4;
                }
            } else {
                return;
            }
        } else if (prefKey.equals(MessagingPrefKeys.F)) {
            notificationPrefsWatcher.f16350b.m16391a();
            return;
        } else {
            return;
        }
        if (a != null) {
            if (th3 != null) {
                try {
                    a.close();
                } catch (Throwable th5) {
                    AndroidCompat.addSuppressed(th3, th5);
                }
            } else {
                a.close();
            }
        }
        throw th2;
        throw th2;
    }

    private PushedViewerContext m16418a(ThreadKey threadKey) {
        if (this.f16352d != Product.PAA) {
            return PushedViewerContext.a;
        }
        ViewerContextManager viewerContextManager = this.f16351c;
        ViewerContextBuilder newBuilder = ViewerContext.newBuilder();
        newBuilder.d = true;
        newBuilder = newBuilder;
        newBuilder.a = Long.toString(threadKey.e);
        newBuilder = newBuilder;
        newBuilder.b = "";
        return viewerContextManager.b(newBuilder.h());
    }
}
