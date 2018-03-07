package com.facebook.push.fbnslite;

import android.content.Context;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.push.PushManager;
import com.facebook.push.externalcloud.PushServiceSelector;
import com.facebook.push.fbnslite.FbnsLitePushNotificationHandler.FbnsLiteCallbackReceiver;
import com.facebook.push.registration.ServiceType;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: important_reactors */
public class FbnsLitePushManager implements PushManager {
    private static final Class<?> f10454a = FbnsLitePushManager.class;
    private static volatile FbnsLitePushManager f10455e;
    private final Lazy<FbnsLiteRegistrar> f10456b;
    private final PushServiceSelector f10457c;
    private final String f10458d;

    public static com.facebook.push.fbnslite.FbnsLitePushManager m10988a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10455e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.push.fbnslite.FbnsLitePushManager.class;
        monitor-enter(r1);
        r0 = f10455e;	 Catch:{ all -> 0x003a }
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
        r0 = m10989b(r0);	 Catch:{ all -> 0x0035 }
        f10455e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10455e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.push.fbnslite.FbnsLitePushManager.a(com.facebook.inject.InjectorLike):com.facebook.push.fbnslite.FbnsLitePushManager");
    }

    private static FbnsLitePushManager m10989b(InjectorLike injectorLike) {
        return new FbnsLitePushManager(IdBasedSingletonScopeProvider.b(injectorLike, 3178), PushServiceSelector.m10724a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public FbnsLitePushManager(Lazy<FbnsLiteRegistrar> lazy, PushServiceSelector pushServiceSelector, Context context) {
        this.f10456b = lazy;
        this.f10457c = pushServiceSelector;
        this.f10458d = context.getPackageName();
    }

    public final ServiceType mo794a() {
        return ServiceType.FBNS_LITE;
    }

    private boolean m10990f() {
        return this.f10457c.m10731a(ServiceType.FBNS_LITE);
    }

    public final void mo795b() {
        if (m10990f()) {
            this.f10457c.m10730a(this.f10458d, FbnsLitePushNotificationHandler.class, FbnsLiteCallbackReceiver.class);
        }
    }

    public final void mo796c() {
        if (m10990f()) {
            ((FbnsLiteRegistrar) this.f10456b.get()).m10866a(true);
        }
    }

    public final void mo797d() {
        if (m10990f()) {
            ((FbnsLiteRegistrar) this.f10456b.get()).m10866a(false);
        }
    }

    public final void mo798e() {
        if (m10990f()) {
            FbnsLiteRegistrar.m10862a((FbnsLiteRegistrar) this.f10456b.get(), null);
        }
    }
}
