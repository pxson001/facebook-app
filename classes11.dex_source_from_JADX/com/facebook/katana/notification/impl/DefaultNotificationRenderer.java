package com.facebook.katana.notification.impl;

import android.content.Context;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.notifications.model.SystemTrayNotificationBuilder;
import com.facebook.notifications.util.SystemTrayNotificationManager;
import com.google.common.base.Preconditions;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: Unsupported HTTP request method  */
public class DefaultNotificationRenderer {
    private static volatile DefaultNotificationRenderer f10401d;
    public final Context f10402a;
    public final Lazy<SystemTrayNotificationManager> f10403b;
    public final Provider<SystemTrayNotificationBuilder> f10404c;

    public static com.facebook.katana.notification.impl.DefaultNotificationRenderer m10798a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10401d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.katana.notification.impl.DefaultNotificationRenderer.class;
        monitor-enter(r1);
        r0 = f10401d;	 Catch:{ all -> 0x003a }
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
        r0 = m10799b(r0);	 Catch:{ all -> 0x0035 }
        f10401d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10401d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.katana.notification.impl.DefaultNotificationRenderer.a(com.facebook.inject.InjectorLike):com.facebook.katana.notification.impl.DefaultNotificationRenderer");
    }

    private static DefaultNotificationRenderer m10799b(InjectorLike injectorLike) {
        return new DefaultNotificationRenderer((Context) injectorLike.getInstance(Context.class, ForAppContext.class), IdBasedSingletonScopeProvider.b(injectorLike, 2841), IdBasedProvider.a(injectorLike, 8699));
    }

    @Inject
    public DefaultNotificationRenderer(@ForAppContext Context context, Lazy<SystemTrayNotificationManager> lazy, Provider<SystemTrayNotificationBuilder> provider) {
        this.f10402a = (Context) Preconditions.checkNotNull(context);
        this.f10403b = (Lazy) Preconditions.checkNotNull(lazy);
        this.f10404c = (Provider) Preconditions.checkNotNull(provider);
    }
}
