package com.facebook.messaging.platform;

import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: unprepare */
public class MessengerPlatformConfigManager {
    private static final ImmutableSet<Integer> f2421a = ImmutableSet.of(Integer.valueOf(20150314), Integer.valueOf(20150311), Integer.valueOf(20141218));
    private static volatile MessengerPlatformConfigManager f2422e;
    private final Provider<Boolean> f2423b;
    private final Provider<Boolean> f2424c;
    private final Provider<Boolean> f2425d;

    public static com.facebook.messaging.platform.MessengerPlatformConfigManager m3651a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2422e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.platform.MessengerPlatformConfigManager.class;
        monitor-enter(r1);
        r0 = f2422e;	 Catch:{ all -> 0x003a }
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
        r0 = m3652b(r0);	 Catch:{ all -> 0x0035 }
        f2422e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2422e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.platform.MessengerPlatformConfigManager.a(com.facebook.inject.InjectorLike):com.facebook.messaging.platform.MessengerPlatformConfigManager");
    }

    private static MessengerPlatformConfigManager m3652b(InjectorLike injectorLike) {
        return new MessengerPlatformConfigManager(IdBasedProvider.a(injectorLike, 4189), IdBasedProvider.a(injectorLike, 4190), IdBasedProvider.a(injectorLike, 4191));
    }

    @Inject
    public MessengerPlatformConfigManager(Provider<Boolean> provider, Provider<Boolean> provider2, Provider<Boolean> provider3) {
        this.f2423b = provider;
        this.f2424c = provider2;
        this.f2425d = provider3;
    }

    public final boolean m3653a(int i) {
        switch (i) {
            case 20141218:
                return ((Boolean) this.f2423b.get()).booleanValue();
            case 20150311:
                return ((Boolean) this.f2424c.get()).booleanValue();
            case 20150314:
                return ((Boolean) this.f2425d.get()).booleanValue();
            default:
                return false;
        }
    }

    public final boolean m3654a(int i, int i2) {
        Preconditions.checkArgument(f2421a.contains(Integer.valueOf(i)));
        if (m3653a(i2) && i2 >= i) {
            return true;
        }
        return false;
    }
}
