package com.facebook.notifications.activitylistener;

import android.app.NotificationManager;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.NeedsApplicationInjector;
import com.facebook.notifications.logging.NotificationsLogger;
import com.facebook.notifications.util.NotificationsUtils;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: Tried to render plus button for collection with no id */
public class NotificationsActivityListener {
    private static volatile NotificationsActivityListener f10542d;
    public final Lazy<NotificationsLogger> f10543a;
    public final Lazy<NotificationManager> f10544b;
    public final Lazy<NotificationsUtils> f10545c;

    public static com.facebook.notifications.activitylistener.NotificationsActivityListener m11041a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10542d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.notifications.activitylistener.NotificationsActivityListener.class;
        monitor-enter(r1);
        r0 = f10542d;	 Catch:{ all -> 0x003a }
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
        r0 = m11042b(r0);	 Catch:{ all -> 0x0035 }
        f10542d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10542d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.notifications.activitylistener.NotificationsActivityListener.a(com.facebook.inject.InjectorLike):com.facebook.notifications.activitylistener.NotificationsActivityListener");
    }

    private static NotificationsActivityListener m11042b(InjectorLike injectorLike) {
        return new NotificationsActivityListener(IdBasedSingletonScopeProvider.b(injectorLike, 2809), IdBasedLazy.a(injectorLike.getApplicationInjector(), 6), IdBasedSingletonScopeProvider.b(injectorLike, 2839));
    }

    @Inject
    public NotificationsActivityListener(Lazy<NotificationsLogger> lazy, @NeedsApplicationInjector Lazy<NotificationManager> lazy2, Lazy<NotificationsUtils> lazy3) {
        this.f10543a = lazy;
        this.f10544b = lazy2;
        this.f10545c = lazy3;
    }
}
