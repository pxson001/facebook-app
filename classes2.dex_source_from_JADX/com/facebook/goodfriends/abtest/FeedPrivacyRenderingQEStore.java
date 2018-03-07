package com.facebook.goodfriends.abtest;

import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: image/x-fba */
public class FeedPrivacyRenderingQEStore {
    private static final String f20486a = FeedPrivacyRenderingQEStore.class.getSimpleName();
    private static volatile FeedPrivacyRenderingQEStore f20487e;
    private final QeAccessor f20488b;
    private Integer f20489c = null;
    private Integer f20490d = null;

    public static com.facebook.goodfriends.abtest.FeedPrivacyRenderingQEStore m28224a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f20487e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.goodfriends.abtest.FeedPrivacyRenderingQEStore.class;
        monitor-enter(r1);
        r0 = f20487e;	 Catch:{ all -> 0x003a }
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
        r0 = m28225b(r0);	 Catch:{ all -> 0x0035 }
        f20487e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20487e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.goodfriends.abtest.FeedPrivacyRenderingQEStore.a(com.facebook.inject.InjectorLike):com.facebook.goodfriends.abtest.FeedPrivacyRenderingQEStore");
    }

    private static FeedPrivacyRenderingQEStore m28225b(InjectorLike injectorLike) {
        return new FeedPrivacyRenderingQEStore(QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public FeedPrivacyRenderingQEStore(QeAccessor qeAccessor) {
        this.f20488b = qeAccessor;
    }

    public final boolean m28226a() {
        return this.f20488b.mo596a(ExperimentsForGoodFriendsAbtestModule.f8977g, false);
    }

    public final boolean m28227b() {
        return this.f20488b.mo596a(ExperimentsForGoodFriendsAbtestModule.f8978h, false);
    }

    public final boolean m28228c() {
        return this.f20488b.mo596a(ExperimentsForGoodFriendsAbtestModule.f8980j, false);
    }

    public final boolean m28229d() {
        return this.f20488b.mo596a(ExperimentsForGoodFriendsAbtestModule.f8981k, false);
    }

    public final int m28230e() {
        if (this.f20489c == null) {
            this.f20489c = Integer.valueOf(m28223a(this.f20488b.mo581a(ExperimentsForGoodFriendsAbtestModule.f8982l, ""), -7235677));
        }
        return this.f20489c.intValue();
    }

    public final int m28231f() {
        if (this.f20490d == null) {
            this.f20490d = Integer.valueOf(m28223a(this.f20488b.mo581a(ExperimentsForGoodFriendsAbtestModule.f8979i, ""), -1447187));
        }
        return this.f20490d.intValue();
    }

    public static int m28223a(String str, int i) {
        try {
            return Long.decode(str).intValue();
        } catch (NumberFormatException e) {
            BLog.b(f20486a, "Error while decoding : %s", new Object[]{str, e});
            try {
                return (int) Long.parseLong(str, 16);
            } catch (NumberFormatException e2) {
                BLog.b(f20486a, "Error while parsing : %s", new Object[]{str, e2});
                return i;
            }
        }
    }
}
