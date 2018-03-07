package com.facebook.xconfig.core;

import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: users */
public class XConfigReader {
    private static volatile XConfigReader f1407c;
    private final Provider<String> f1408a;
    private final XConfigStorage f1409b;

    public static com.facebook.xconfig.core.XConfigReader m2681a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1407c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.xconfig.core.XConfigReader.class;
        monitor-enter(r1);
        r0 = f1407c;	 Catch:{ all -> 0x003a }
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
        r0 = m2682b(r0);	 Catch:{ all -> 0x0035 }
        f1407c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1407c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.xconfig.core.XConfigReader.a(com.facebook.inject.InjectorLike):com.facebook.xconfig.core.XConfigReader");
    }

    private static XConfigReader m2682b(InjectorLike injectorLike) {
        return new XConfigReader(IdBasedProvider.m1811a(injectorLike, 4443), XConfigStorage.m2688a(injectorLike));
    }

    @Inject
    public XConfigReader(Provider<String> provider, XConfigStorage xConfigStorage) {
        this.f1408a = provider;
        this.f1409b = xConfigStorage;
    }

    public final boolean m2686a(@Nonnull XConfigSetting xConfigSetting, boolean z) {
        Preconditions.checkNotNull(xConfigSetting);
        String a = xConfigSetting.f4701b.m2012a();
        String str = xConfigSetting.f4700a;
        String a2 = this.f1409b.m2700a((String) this.f1408a.get(), xConfigSetting);
        if (a2 == null) {
            return z;
        }
        if (a2.equalsIgnoreCase("true") || a2.equals("1")) {
            return true;
        }
        if (a2.equalsIgnoreCase("false") || a2.equals("0")) {
            return false;
        }
        BLog.c("XConfigReader", "Invalid casting of %s:%s to boolean - actual value is %s", new Object[]{a, str, a2});
        return z;
    }

    public final long m2684a(@Nonnull XConfigSetting xConfigSetting, long j) {
        Preconditions.checkNotNull(xConfigSetting);
        String a = xConfigSetting.f4701b.m2012a();
        String str = xConfigSetting.f4700a;
        String a2 = this.f1409b.m2700a((String) this.f1408a.get(), xConfigSetting);
        if (a2 != null) {
            try {
                j = Long.parseLong(a2);
            } catch (Throwable e) {
                BLog.c("XConfigReader", e, "Invalid casting of %s:%s to integer - actual value is %s", new Object[]{a, str, a2});
            }
        }
        return j;
    }

    public final int m2683a(@Nonnull XConfigSetting xConfigSetting, int i) {
        Preconditions.checkNotNull(xConfigSetting);
        xConfigSetting.f4701b.m2012a();
        String a = this.f1409b.m2700a((String) this.f1408a.get(), xConfigSetting);
        if (a != null) {
            try {
                i = Integer.parseInt(a);
            } catch (NumberFormatException e) {
            }
        }
        return i;
    }

    @Nullable
    public final String m2685a(@Nonnull XConfigSetting xConfigSetting, @Nullable String str) {
        Preconditions.checkNotNull(xConfigSetting);
        xConfigSetting.f4701b.m2012a();
        String a = this.f1409b.m2700a((String) this.f1408a.get(), xConfigSetting);
        return a == null ? str : a;
    }
}
